package txh.user.controller;


import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import txh.user.entity.StatusObj;
import txh.user.entity.User;
import txh.user.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lxl on 2018/8/7.
 * user控制器
 */
@RestController
@RequestMapping( value = "/user")
public class UserController {

    @Resource
    private UserService userService;
    /**
     *
     * @param dto
     * @return
     */
    @RequestMapping(value ="/add",method = RequestMethod.POST)
    @CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST }, origins = "*")
    public void add(@RequestBody User dto){
        userService.addInfo(dto);
    }

    @RequestMapping(value ="/get",method = RequestMethod.GET)
    @CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST }, origins = "*")
    public String get(){
        return "1";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public Object edit(@RequestBody User dto){
       return userService.editInfo(dto);
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.POST)
    @CrossOrigin(methods = {RequestMethod.GET,RequestMethod.POST},origins = "*")
    public StatusObj getAll(@RequestBody User dto){
        return userService.getInfo(dto.getId(),dto.getName());

    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @CrossOrigin(methods = {RequestMethod.GET,RequestMethod.POST},origins = "*")
    public StatusObj login(@RequestBody User dto){
        return  userService.login(dto.getLogin(),dto.getPassword());
    }


}
