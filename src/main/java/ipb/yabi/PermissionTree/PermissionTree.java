package ipb.yabi.PermissionTree;
import ipb.yabi.YabiUser.YabiUser;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
    @JoinColumn(name = "parent_id", nullable = false)
    private PermissionTree parent;
    
    @ManyToMany
    private List<YabiUser> yabiUser;
    
    public static PermissionTree rootNode(){
        PermissionTree pt = new PermissionTree();
        pt.setNodePath("/");
        pt.setDescription("root node");
        pt.setParent(pt);
        return pt;
    }
    
    public Boolean childOf (PermissionTree someone){
        return this.nodePath.startsWith(someone.nodePath);
    }
    
    public boolean parentOf ( PermissionTree someone){
        return someone.nodePath.startsWith(this.nodePath);
    }
    
    @Override
    public String toString(){
        return this.id + "," + this.nodePath;
    }
    
    /*
    Need to validate so that nodePath string is the same as the parent's nodePath
    
    Example:
    Initially the db has:
        id | nodePath |parent | description
    -------+----------+-------+--------------------
        1  | /        |   1   | root node
        2  | /a       |   1   | 1st level
        3  | /a/b     |   2   | 2nd level
    
    Inserting the following permission should raise an error:
        id | nodePath |parent | description
    -------+----------+-------+--------------------
        4  | /a/b/c/d |   3   | Conflicting node
    */

}
