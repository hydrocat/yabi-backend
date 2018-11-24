package ipb.yabi.PermissionTree;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author hydrocat
 */
@CrossOrigin
@Controller
public class PermissionTreeController {
    @Autowired
    PermissionRepository pr;
    
    @DeleteMapping("/permission/{node}")
    public String deleteNode( @PathVariable PermissionTree node ){
        List<PermissionTree> permissions = pr.findAllBynodePathStartingWith( node.getNodePath() );
        Integer elementCount = permissions.size();
        
        permissions.stream()
                .forEach( pr::delete);
        
        return elementCount.toString();
    }
    
}
