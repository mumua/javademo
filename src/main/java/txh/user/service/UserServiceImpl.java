package txh.user.service;


import org.springframework.stereotype.Service;
import txh.user.entity.StatusObj;
import txh.user.entity.User;
import txh.user.dao.UserDao;

import javax.annotation.Resource;

import java.util.List;




/**
 * Created by lxl on 2018/8/8.
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao  userDao;

    @Override
    public User addInfo(User dto) {
         return userDao.save(dto);

    }

    public User editInfo(User dto){

       return  userDao.save(dto);
    }

    @Override
    public StatusObj getInfo(String id, String name) {
        //List<User>  list=userDao.findAll();
        //StatusObj statusObj;
        StatusObj statusObj=new StatusObj(210,"this is ok");
        List<User>  list=userDao.findByNameLike("%"+name+"%");
        if (list.size() > 0) {
            // List<User>  list=userDao.findByNameLike("%"+name+"%");

            // statusObj.setMessege();

            statusObj.setData(list);
        }else{
            statusObj.setMessege("0 list");
            statusObj.setStatusCode(2001);
        }


        /*if (name.isEmpty()&&id.isEmpty()){
            list = userDao.findAll();
        }else if(!name.isEmpty()&&id.isEmpty()){
            list=userDao.findByNameLike(name);
        }else if(name.isEmpty()&&!id.isEmpty()){
            list=userDao.findByIdLike(id);
        }else{
             list=userDao.findByNameAndIdLike(name,id);
        }*/
        return statusObj;
    }

    @Override
    public StatusObj login(String login, String password){
        StatusObj statusObj=new StatusObj(200,"is ok");
        List<User> arr=userDao.findByLogin(login);
        if (arr.size()>=1){
            String str=arr.get(0).getPassword().trim();
            if (str.equals(password)){
                statusObj.setStatusCode(200);
                statusObj.setMessege("登录成功");
                statusObj.setData(arr);
            }else{
                statusObj.setStatusCode(40002);
                statusObj.setMessege("密码错误");
            }

        }else if (arr.size()<1){
            statusObj.setStatusCode(40001);
            statusObj.setMessege("账号不存在");

        }
        return statusObj;
    }




}
