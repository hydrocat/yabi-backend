package ipb.yabi.SqlQuery;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface SqlQueryRepository extends PagingAndSortingRepository<SqlQuery, Long> {
    public SqlQuery findByName(String name);
    public List<SqlQuery> findByPermissionNodePathStartingWith( String nodePath );
}
