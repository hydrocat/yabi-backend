package ipb.yabi.YabiUser;

import ipb.yabi.PermissionTree.PermissionTree;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author hydrocat
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
public @Data class YabiUser {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany
    private List<PermissionTree> permission;
    

}
