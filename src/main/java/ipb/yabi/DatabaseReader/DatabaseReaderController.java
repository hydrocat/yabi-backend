package ipb.yabi.DatabaseReader;

import ipb.yabi.Directory.DirectoryRepository;
import ipb.yabi.SqlQuery.SqlQuery;
import ipb.yabi.SqlQuery.SqlQueryRepository;
import ipb.yabi.YabiUser.YabiUser;
import java.sql.SQLException;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    private Logger logger = LoggerFactory.getLogger(DatabaseReaderController.class );

    @GetMapping("/runQuery/{query}")
    public ArrayList<ArrayList<String>> runQuery(@PathVariable SqlQuery query,
            Authentication auth)
            throws SQLException {

        YabiUser user = ((YabiUser) auth.getPrincipal());
        // User must have at least one permission in which this query is child of
        if (user.getPermissions().stream().anyMatch(p -> p.parentOf(query.getPermission()))) {
            logger.info("User {} has permission to run query {}", user.getName(), query.getName());
            return DatabaseReader.runQuery(query);
        } else {
            logger.info("User {} does NOT have permission to run query {}", user.getName(), query.getName());
            throw new AuthorizationServiceException("Query does not belong to user");
        }
    }
}
