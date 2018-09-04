package txh.user.entity;




/**
 * Created by lxl on 2018/9/3.
 * 分页查询的参数请求对象
 */
public class UserPage {
    private  User user;
    private PageInfo pageInfo;

    public UserPage(){

    }
    public  UserPage(User user,PageInfo pageInfo){
        this.user=user;
        this.pageInfo=pageInfo;
    }

    public User getUser(){
        return  user;
    }
    public void setUser(User user){
        this.user=user;
    }

    public PageInfo getPageInfo(){
        return  pageInfo;
    }
    public void setPageInfo(PageInfo pageInfo){
        this.pageInfo=pageInfo;
    }
}
