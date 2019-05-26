package ipb.yabi.Configuration;

import ipb.yabi.PermissionTree.PermissionRepository;
import ipb.yabi.PermissionTree.PermissionTree;
import ipb.yabi.YabiUser.Role;
import ipb.yabi.YabiUser.YabiUser;
import ipb.yabi.YabiUser.YabiUserRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Database initializer that populates the database with some initial
 * accounts using a JPA repository.
 *
 * This component is started only when app.db-init property is set to true
 */
@Component
@ConditionalOnProperty(name = "yabi.db.init", havingValue = "create")
public class DbInitializer implements CommandLineRunner {

    @Autowired
    private Environment env;
    @Autowired
    private PermissionRepository pr;
    @Autowired
    private YabiUserRepository userRepo;


    @Override
    public void run(String... strings) throws Exception {
        pr.deleteAll();

        PermissionTree pt = pr.save(PermissionTree.rootNode());
        
        ArrayList<PermissionTree> apt = new ArrayList<>();
        apt.add(pt);
        
        userRepo.save( new YabiUser(0l, env.getProperty("yabi.db.init.admin.username"), apt, Role.ROLE_ADMIN));
        
        System.out.println(" -- Database has been initialized");
    }
}
