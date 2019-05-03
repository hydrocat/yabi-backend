package ipb.yabi.YabiUser;

import org.springframework.security.authentication.BadCredentialsException;
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
        if (auth == null) {
            throw new BadCredentialsException("Credentials not specified");
        }
        // Need a YabiUserViewModel to avoid the recursion in PermissionTree model
        return new YabiUserViewModel( (YabiUser) auth.getPrincipal() );
    }
}
