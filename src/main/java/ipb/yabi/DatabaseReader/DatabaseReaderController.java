package ipb.yabi.DatabaseReader;

import ipb.yabi.Directory.DirectoryRepository;
import ipb.yabi.SqlQuery.SqlQueryRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hydrocat
 */
@RestController
public class DatabaseReaderController {
    @Autowired
    SqlQueryRepository queryRepo;
    @Autowired
    DirectoryRepository dirRepo;
    
    @GetMapping("/runQuery/{queryId}")
    public ArrayList<ArrayList<String>> runQuery(@PathVariable String queryId)
        throws SQLException{
        return new DatabaseReader(queryRepo, dirRepo).runQuery(queryId);
    }
}
