package txh.user.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import txh.user.entity.PageInfo;
import txh.user.entity.StatusObj;
import txh.user.entity.User;

import java.util.List;

/**
 * Created by lxl on 2018/8/7.
 */
public interface UserService {


    public  User addInfo(User dto);

    public User editInfo(User dto);


    StatusObj getInfo(String id, String name);

    StatusObj login(String login, String password);

   // StatusObj findUserList(Integer page, Integer size, User dto);

    StatusObj detele(String id);

     StatusObj findAll(User dto, PageRequest pageInfo);

    // public User upload(String data);
}
