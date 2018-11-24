package ipb.yabi.YabiUser;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface YabiUserRepository extends PagingAndSortingRepository<YabiUser, Long> {
    public YabiUser findByName(String name);
    

}
