package ipb.yabi.PermissionTree;
import java.util.ArrayList;
import javax.persistence.Entity;


/**
 *
 * @author hydrocat
 */
//@Entity

@Entity
public class PermissionTree {

    //@Id
    //@GeneratedValue
    private Long id;
    private String nodePath;
    private String name;
    private static PermissionTree ROOT_NODE;

    private PermissionTree() {
        this.id = 1l;
        this.nodePath = "/";
        this.name = "root";
    }

    public static PermissionTree getRoot() {
        if (ROOT_NODE == null) {
            ROOT_NODE = new PermissionTree();
        }

        return ROOT_NODE;
    }

    public PermissionTree(String name, PermissionTree parent) {
        this.name = name;
        nodePath = parent.nodePath.concat(name + "/");
    }
    
    public Boolean childOf (PermissionTree someone){
        return this.nodePath.startsWith(someone.nodePath);
    }
    
    @Override
    public String toString(){
        return "«" +this.id + " "+ this.nodePath +" " + this.name+"»";
    }

    public static void main(String[] args) {
        System.out.println("ASDASKDJNASLKDJN");
        PermissionTree root = PermissionTree.getRoot();
        PermissionTree a = new PermissionTree("a", root);
        PermissionTree a1 = new PermissionTree("a1", a);

        PermissionTree b = new PermissionTree("b", root);
        PermissionTree b1 = new PermissionTree("b1", b);
        ArrayList<PermissionTree> list = new ArrayList<>();
        list.add(root);
        list.add(a);
        list.add(a1);
        list.add(b);
        list.add(b1);
        list.stream()
                .filter( P -> P.childOf(a))
                .forEach( x -> System.out.println(x + "\n")
                );
        
        System.out.println(list);
    }
}
