package ipb.yabi.test;

import ipb.yabi.Application;
import ipb.yabi.DatabaseReader.DatabaseReader;
import ipb.yabi.Directory.Directory;
import ipb.yabi.Directory.DirectoryRepository;
import ipb.yabi.SqlQuery.SqlQuery;
import ipb.yabi.SqlQuery.SqlQueryRepository;
import ipb.yabi.test.testPojo.DirectoriesForTesting;
import ipb.yabi.test.testPojo.SqlQueryMaria;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
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
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestB‌uilders.get; 

@RunWith(SpringRunner.class)
@WebMvcTest(Application.class)
@DataJpaTest
//@SpringBootTest
public class DatabaseReaderTest {

    @Autowired
    DirectoryRepository dirRepo;
    @Autowired
    SqlQueryRepository sqlRepo;

    @Autowired
    private MockMvc mockMvc;

    List<Directory> savedDirs;

    @Before
    public void setUp() {
        System.out.println("---------------------------");
        savedDirs = Arrays.asList(DirectoriesForTesting.dirs).stream().map(dirRepo::save).collect(Collectors.toList());
    }

    @Test
    public void mariaDbTest() throws Exception {
        SqlQuery q = SqlQueryMaria.selectAllArtists();
        q.setDirectory(savedDirs.get(0));
        sqlRepo.save(q);
        System.out.println(mockMvc.perform(get("/runQuery?queryName="+q.getName())));

//        ArrayList<ArrayList<String>> result = dbreader.runQuery(q.getName());
//        for (ArrayList<String> l : result) {
//            for (String s : l) {
//                System.out.print(s + "\t");
//            }
//            System.out.println("");
//        }
        assertThat(1, is(1));
    }

}
