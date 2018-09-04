package txh.user.entity;



/**
 * Created by lxl on 2018/9/3.
 */
public class PageInfo  {
    private int total;
    private int size;
    private  int current;
    private  int pagenumber;
    private String orderby;

    public  PageInfo(){

    }
    public PageInfo(int total,int size,int current,int pagenumber,String orderby){
        this.total=total;
        this.size=size;
        this.current=current;
        this.pagenumber=pagenumber;
        this.orderby=orderby;
    }

    public PageInfo(int total,int size,int current){
        this.total=total;
        this.size=size;
        this.current=current;
    }
    public  int getTotal(){
        return  total;
    }
    public  void setTotal(int total){
        this.total=total;
    }

    public  int getSize(){
        return  size;
    }
    public  void setSize(int size){
        this.size=size;
    }

    public int getCurrent(){
        return  current;
    }
    public  void setCurrent(int current){
        this.current=current;
    }
    public  int getPagenumber(){
        return  pagenumber;
    }
    public  void setPagenumber(int pagenumber){
        this.pagenumber=pagenumber;
    }
    public String getOrderby(){
        return  orderby;
    }
    public void setOrderby(String orderby){
        this.orderby=orderby;
    }
}
