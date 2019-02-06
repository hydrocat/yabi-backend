package ipb.yabi.Configuration;

import ipb.yabi.PermissionTree.PermissionRepository;
import ipb.yabi.PermissionTree.PermissionTree;
import ipb.yabi.YabiUser.YabiUser;
import ipb.yabi.YabiUser.YabiUserRepository;
import java.util.ArrayList;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * Database initializer that populates the database with some initial bank
 * accounts using a JPA repository.
 *
 * This component is started only when app.db-init property is set to true
 */
@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class DbInitializer implements CommandLineRunner {

    private final PermissionRepository pr;
    private final YabiUserRepository userRepo;

    public DbInitializer(PermissionRepository pr, YabiUserRepository ur) {
        this.pr = pr;
        this.userRepo = ur;
    }

    @Override
    public void run(String... strings) throws Exception {
        pr.deleteAll();
        System.out.println(PermissionTree.rootNode());
        PermissionTree pt = pr.save(PermissionTree.rootNode());
        
        ArrayList<PermissionTree> apt = new ArrayList<>();
        apt.add(pt);
        userRepo.save( new YabiUser(0l, "admin", apt));
        
        System.out.println(" -- Database has been initialized");
    }
}
