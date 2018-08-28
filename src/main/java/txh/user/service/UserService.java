package txh.user.service;

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

    // public User upload(String data);
}
