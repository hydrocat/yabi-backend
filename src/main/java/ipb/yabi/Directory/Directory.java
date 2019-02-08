package ipb.yabi.Directory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public @Data class Directory {

    @Id
    @GeneratedValue
    private Long id;
    
    @Column(unique = true)
    private String connectionString;
    @Column(unique = true)
    private String name;
    private String username;
    private String password;

}
