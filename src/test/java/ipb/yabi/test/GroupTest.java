package ipb.yabi.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ipb.yabi.UserGroup.UserGroupRepository;

/**
 *
 * @author hydrocat
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
public class GroupTest {
    
    @Autowired
    UserGroupRepository repo;
    
    @Test
    public void insert() { 
        
    }
}