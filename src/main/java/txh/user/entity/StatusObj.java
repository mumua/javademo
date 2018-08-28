package txh.user.entity;


import java.util.List;

/**
 * Created by lxl on 2018/8/16.
 */
public class StatusObj <T>{
    private  int statusCode;
    private String messege;
    private List<T> data;

    public StatusObj(int statusCode){
        this.statusCode=statusCode;
    }

    public StatusObj(String messege ){
        this.messege=messege;
    }

    public StatusObj(int statusCode,String messege ){
        this.statusCode=statusCode;
        this.messege=messege;
      //  this.data=data;
    }
    public StatusObj(int statusCode,String messege ,List<T> data){
        this.statusCode=statusCode;
        this.messege=messege;
        this.data=data;
    }
    public StatusObj(List<T> data){
        this.data=data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode){
        this.statusCode=statusCode;
    }
    public String getMessege(){
        return  messege;
    }
    public void setMessege(String messege){
        this.messege=messege;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
