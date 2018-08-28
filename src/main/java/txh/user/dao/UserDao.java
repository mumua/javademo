package txh.user.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import txh.user.entity.User;

import java.util.List;

/**
 * Created by lxl on 2018/8/7.
 */
public interface UserDao extends JpaRepository<User, Long> {
    List<User> findByNameLike(String name);
    List<User> findByIdLike(String id);
    List<User> findByNameAndIdLike(String id,String name);
    List<User> findByLogin(String login);
}
