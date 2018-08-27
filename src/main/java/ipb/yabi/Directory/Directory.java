package ipb.yabi.Directory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author hydrocat
 */
@Entity
public @Data class Directory {

    @Id
    @GeneratedValue
    private Long id;
    private String connectionString;
    private String name;
    private String username;
    private String password;

}
