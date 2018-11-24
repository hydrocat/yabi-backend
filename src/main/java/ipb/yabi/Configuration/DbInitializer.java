package ipb.yabi.Configuration;

import ipb.yabi.PermissionTree.PermissionRepository;
import ipb.yabi.PermissionTree.PermissionTree;
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

    public DbInitializer(PermissionRepository pr) {
        this.pr = pr;
    }

    @Override
    public void run(String... strings) throws Exception {
        pr.deleteAll();
        System.out.println(PermissionTree.rootNode());
        pr.save(PermissionTree.rootNode());
        System.out.println(" -- Database has been initialized");
    }
}
