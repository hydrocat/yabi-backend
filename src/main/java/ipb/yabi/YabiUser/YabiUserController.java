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

    @GetMapping("/user")
    YabiUserViewModel user(Authentication auth) {
        // Need a YabiUserViewModel to avoid the recursion in PermissionTree model
        return new YabiUserViewModel( (YabiUser) auth.getPrincipal() );
    }
}
