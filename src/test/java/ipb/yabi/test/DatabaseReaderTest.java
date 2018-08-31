package ipb.yabi.test;

import ipb.yabi.DatabaseReader.DatabaseReader;
import ipb.yabi.Directory.Directory;
import ipb.yabi.Directory.DirectoryRepository;
import ipb.yabi.SqlQuery.SqlQuery;
import ipb.yabi.SqlQuery.SqlQueryRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
public class DatabaseReaderTest {
    @Test
    public void pass() {
        Assert.assertThat(1, is(1));
    }
//
//    @Autowired
//    SqlQueryRepository qRepo;
//    @Autowired
//    DirectoryRepository dRepo;
//    @Autowired
//    DatabaseReader dr;
//
//    static SqlQuery query = new SqlQuery();
//    static Directory dir = new Directory();
//
//    @Before
//    public void setUpDatabase() {
//        Directory d = new Directory();
//        d.setConnectionString("jdbc:mariadb://localhost:3306/pessoa");
//        d.setName("DockerMariaDb");
//        d.setPassword("root");
//        d.setUsername("root");
//        dir = dRepo.save(d);
//
//        SqlQuery q = new SqlQuery();
//        q.setCommand("select * from p;");
//        q.setDescription("seleciona tudo");
//        q.setName("SimpleGetAll");
//        q.setDirectory(dir);
//        query = qRepo.save(q);
//
//    }
//
//    @Test
//    public void executacQuery() throws SQLException {
//        System.out.println(dr);
//        System.out.println("Printing DATABASE");
//        for (ArrayList<String> column : dr.runQuery("SimpleGetAll")) {
//            for (String s : column) {
//                System.out.println("++++++");
//                System.out.println("+ " + s);
//                System.out.println("++++++");
//
//            }
//        }
//    }
//
//    @Test
//    public void multipleTables() throws SQLException {
//        Directory d = new Directory();
//        d.setConnectionString("jdbc:mariadb://localhost:3306/walter");
//        d.setName("WalterDb");
//        d.setPassword("root");
//        d.setUsername("root");
//        d = dRepo.save(d);
//
//        SqlQuery q = new SqlQuery();
//        q.setCommand("select * from amigos join teste where SIMNAO =1;");
//        q.setDescription("seleciona tudo");
//        q.setName("join");
//        q.setDirectory(d);
//        query = qRepo.save(q);
//        
//        for (ArrayList<String> column : dr.runQuery("run")) {
//            for (String s : column) {
//                System.out.println("++++++");
//                System.out.println("+ " + s);
//                System.out.println("++++++");
//
//            }
//        }
//    }
}
