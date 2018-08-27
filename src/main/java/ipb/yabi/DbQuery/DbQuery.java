package ipb.yabi.DbQuery;

import ipb.yabi.Directory.Directory;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author hydrocat
 */
@Entity
public @Data class DbQuery {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String command;
    private String name;
    private String description;
    @ManyToOne
    private Directory directory;
    
}