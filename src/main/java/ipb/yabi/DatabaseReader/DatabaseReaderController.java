package ipb.yabi.DatabaseReader;

import ipb.yabi.Directory.DirectoryRepository;
import ipb.yabi.SqlQuery.SqlQueryRepository;
import ipb.yabi.YabiUser.YabiUser;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
public class DatabaseReaderController {
    @Autowired
    SqlQueryRepository queryRepo;
    @Autowired
    DirectoryRepository dirRepo;
    
    @GetMapping("/runQuery/{queryId}")
    public ArrayList<ArrayList<String>> runQuery(@PathVariable String queryId)
        throws SQLException{
        return new DatabaseReader(queryRepo, dirRepo).runQuery(queryId);
    }
    
    @RequestMapping("/user")
    public String user(Authentication usr){
        
        return ((YabiUser) usr.getDetails()).toString();
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String userPost(Authentication usr, @RequestBody String body){
        System.out.println(body);
        return ((YabiUser) usr.getDetails()).toString();
    }
}
