package ipb.yabi.YabiUser;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface YabiUserRepository extends PagingAndSortingRepository<YabiUser, Long> {
    public YabiUser findByName(String name);
}
