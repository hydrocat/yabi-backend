package ipb.yabi.PermissionTree;

/**
 *
 * @author vitorio <a40920@alunos.ipb.pt>
 */
public class PermissionTreeViewModel {
    public long id;
    public String nodePath;
    public String description;

    public PermissionTreeViewModel(PermissionTree p) {
        this.id = p.getId();
        this.nodePath = p.getNodePath();
        this.description = p.getDescription();
    }
}
