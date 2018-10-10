package ipb.yabi.YabiUser;

import ipb.yabi.UserGroup.UserGroup;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
    
    @OneToOne
    @JoinColumn(name="group_id")
    private UserGroup group;
    
}
