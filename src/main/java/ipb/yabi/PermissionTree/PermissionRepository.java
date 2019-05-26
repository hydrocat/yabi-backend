package ipb.yabi.PermissionTree;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface PermissionRepository extends PagingAndSortingRepository<PermissionTree, Long> {
    public List<PermissionTree> findAllByNodePathStartingWith(String nodePath);
}
