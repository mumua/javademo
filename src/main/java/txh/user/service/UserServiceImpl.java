package txh.user.service;


import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import txh.user.entity.*;
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
            statusObj.setStatusCode(200);
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

    //@Override
   // public StatusObj findUserList(Integer page, Integer size, User dto) {
    //    StatusObj statusObj=new StatusObj(200,"is ok");
    //    List<User> arr=userDao.findAll();

   //     return statusObj;
   // }

    @Override
    public  StatusObj detele(String id){
        StatusObj statusObj=new StatusObj(200,"is ok");
        userDao.deleteById(id);
        return  statusObj;
    }

    @Override
    public StatusObj findAll(User dto, PageRequest pageInfo) {
        StatusObj statusObj=new StatusObj(200,"is ok");
        PageList<User> pageList=new PageList<>();

        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains()) //姓名采用“开始匹配”的方式查询
                .withIgnorePaths("id");

        Example<User> example = Example.of(dto,matcher);

        Page<User> users= userDao.findAll(example,pageInfo);

         statusObj.setData(users.getContent());
        PageInfo pageInfos=new PageInfo();
        pageList.setDatasource(users.getContent());
        System.out.println("总记录数: " + users.getTotalElements());
        System.out.println("总记录数: " + (int)users.getTotalElements());
        pageInfos.setTotal((int)users.getTotalElements());
        pageInfos.setSize(users.getSize());
        pageInfos.setCurrent(users.getNumber());
        pageList.setPageInfo(pageInfos);
        statusObj.setPageList(pageList);

        return statusObj;
    }


}
