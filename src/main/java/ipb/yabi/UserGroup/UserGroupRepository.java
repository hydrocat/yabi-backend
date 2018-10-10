package ipb.yabi.UserGroup;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserGroupRepository extends PagingAndSortingRepository<UserGroup, Long> {
    public UserGroup findByName(String name);

}
