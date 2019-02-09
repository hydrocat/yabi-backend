package ipb.yabi.PermissionTree;
import ipb.yabi.YabiUser.YabiUser;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


/**
 *
 * @author hydrocat
 */
//@Entity
//@AllArgsConstructor
@NoArgsConstructor
@Entity
public @Data class PermissionTree {

    @Id
    @GeneratedValue
    private Long id;
    
    @Column(unique=true)
    private String nodePath;
    private String description;
    
    @ManyToOne
    private PermissionTree parentNode;
    
    @ManyToMany
    private List<YabiUser> yabiUser;
    
    public static PermissionTree rootNode(){
        PermissionTree pt = new PermissionTree();
        pt.setNodePath("/");
        pt.setDescription("root node");
        return pt;
    }
    
    public Boolean childOf (PermissionTree someone){
        return this.nodePath.startsWith(someone.nodePath);
    }
    
    @Override
    public String toString(){
        return this.id + "," + this.nodePath;
    }

}
