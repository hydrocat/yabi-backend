package ipb.yabi.DatabaseReader;

import ipb.yabi.Directory.DirectoryRepository;
import ipb.yabi.PermissionTree.PermissionTree;
import ipb.yabi.SqlQuery.SqlQuery;
import ipb.yabi.SqlQuery.SqlQueryRepository;
import ipb.yabi.YabiUser.YabiUser;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hydrocat
 */
@RestController
@CrossOrigin
public class DatabaseReaderController {

    @Autowired
    SqlQueryRepository queryRepo;
    @Autowired
    DirectoryRepository dirRepo;

    @GetMapping("/runQuery/{queryId}")
    public ArrayList<ArrayList<String>> runQuery(@PathVariable String queryId,
            Authentication auth)
            throws SQLException {

        SqlQuery query = queryRepo.findById(new Long(queryId)).get();
        YabiUser usr = ((YabiUser) auth.getDetails());
        System.out.println("Query Permission");
        System.out.println(query.getPermission().getNodePath());
        System.out.println("Permissions");
        usr.getPermission().stream().forEach( p -> System.out.print("[" +p.getNodePath() + "] "));
        System.out.println("");
        // Deve haver ao menos uma permissão na qual a query é filha
        System.out.print("O Usuário pode rodar a query ?: ");
        if (usr.getPermission().stream().anyMatch(p -> p.parentOf(query.getPermission()))) {
            System.out.println("SIM!");
            return DatabaseReader.runQuery(query);
        } else {
            System.out.println("NO!");
            throw new AuthorizationServiceException("Query %l does not belong to user %l".format(queryId, usr.getId()));
        }
    }
}
