package ipb.yabi.SqlQuery;

import ipb.yabi.PermissionTree.PermissionTree;
import ipb.yabi.YabiUser.YabiUser;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hydrocat
 */
@RestController
public class SqlQueryController {
    
    @Autowired
    private SqlQueryRepository queryRepo;
    
    @CrossOrigin
    @GetMapping("/queries")
    public List<SqlQueryViewModel> getQueries(Authentication auth){
        YabiUser user = (YabiUser) auth.getPrincipal();
        List<SqlQueryViewModel> queries = new ArrayList<>();
        
        for ( PermissionTree permission : user.getPermissions() ){
            for ( SqlQuery q : queryRepo.findByPermissionNodePathStartingWith(permission.getNodePath()) ){
                queries.add( new SqlQueryViewModel(q) );
            }
        }
        return queries;
    }
    
}
