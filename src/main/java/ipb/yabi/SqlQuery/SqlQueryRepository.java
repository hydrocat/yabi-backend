package ipb.yabi.SqlQuery;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


public interface SqlQueryRepository extends PagingAndSortingRepository<SqlQuery, Long> {
    public SqlQuery findByName(String name);

}
