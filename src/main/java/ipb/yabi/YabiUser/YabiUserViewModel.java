package ipb.yabi.YabiUser;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

/**
 *
 * @author vitorio <a40920@alunos.ipb.pt>
 */
public class YabiUserViewModel {
    
    public String name;
    public Role role;
    public Collection<String> permissions;

    public YabiUserViewModel( YabiUser user ) {
        permissions = user.getPermissions().stream().map(x -> x.getNodePath() ).collect(Collectors.toList());
        name = user.getName();
        role = user.getRole();
    }
    
    
}
