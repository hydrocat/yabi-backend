package ipb.yabi.Directory;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface DirectoryRepository extends PagingAndSortingRepository<Directory, Long> {

    public Directory findByName(String name);
}