package ipb.yabi.PermissionTree;

import ipb.yabi.YabiUser.YabiUser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @DeleteMapping("/permission/{node}")
    public Integer deleteNode(@PathVariable PermissionTree node) {
        List<PermissionTree> permissions = pr.findAllBynodePathStartingWith(node.getNodePath());
        Integer elementCount = permissions.size();

        permissions.forEach(pr::delete);

        return elementCount;
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
