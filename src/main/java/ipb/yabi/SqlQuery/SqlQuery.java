package ipb.yabi.SqlQuery;

import ipb.yabi.Directory.Directory;
import ipb.yabi.PermissionTree.PermissionTree;
import ipb.yabi.UserGroup.UserGroup;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
public @Data class SqlQuery {

    @Id
    @GeneratedValue
    private Long id;

    private String command;
    private String name;
    private String description;
    
    @ManyToOne
    private Directory directory;

    @OneToOne
    private PermissionTree permission;

}
