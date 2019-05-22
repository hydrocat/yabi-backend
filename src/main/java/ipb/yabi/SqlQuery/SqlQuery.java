package ipb.yabi.SqlQuery;

import ipb.yabi.Directory.Directory;
import ipb.yabi.PermissionTree.PermissionTree;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"permission", "name"}))
public @Data class SqlQuery {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 2048)
    private String command;
    
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "directory_id", nullable = false)
    private Directory directory;

    @OneToOne
    @JoinColumn(name = "permission", nullable = false)
    private PermissionTree permission;

}
