package ipb.yabi.YabiUser;

import ipb.yabi.PermissionTree.PermissionTreeViewModel;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vitorio <a40920@alunos.ipb.pt>
 */
@RestController
public class YabiUserController {

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PreAuthorize("isAuthenticated()")
//    @PreAuthorize("authentication.getDetails().getRole().toString().equals(\"ROLE_ADMIN\")")
    @GetMapping("/user")
    YabiUserViewModel user(Authentication auth) {
        return new YabiUserViewModel( ((YabiUser) auth.getDetails()) );
//        return auth.getDetails();
    }
}
