package ipb.yabi.PermissionTree;

import ipb.yabi.YabiUser.YabiUser;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hydrocat
 */
@CrossOrigin
@RestController
public class PermissionTreeController {

    @Autowired
    PermissionRepository pr;

    @DeleteMapping("/permission/{permission}")
    public List<Long> deleteNode(@PathVariable PermissionTree permission) {
        List<PermissionTree> permissions = pr.findAllBynodePathStartingWith(permission.getNodePath());
        
        List<Long> deletedIds = permissions.stream().map( p -> p.getId()).collect( Collectors.toList() );
        permissions.forEach(pr::delete);

        return deletedIds;
    }

    @GetMapping(path = "/permissions")
    public List<PermissionTreeViewModel> myPermissions(Authentication auth) {
        List pl = new ArrayList<PermissionTreeViewModel>();
  
        for (PermissionTree userPermission : ((YabiUser) auth.getDetails()).getPermissions()) {
            for (PermissionTree p : pr.findAllBynodePathStartingWith( userPermission.getNodePath() )) {
                pl.add(new PermissionTreeViewModel(p));
            }
        }
        return pl;
    }
}
