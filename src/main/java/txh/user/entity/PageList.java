package txh.user.entity;

import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * Created by lxl on 2018/9/4.
 */
public class PageList<T> {
    private List<T> datasource;
    private PageInfo pageInfo;

    public  PageList(){

    }
    public  PageList(List<T> datasource){
        this.datasource=datasource;
    }
    public PageList(PageInfo pageInfo ){
        this.pageInfo=pageInfo;
    }
    public  PageList(List<T> datasource,PageInfo pageInfo){
        this.datasource=datasource;
        this.pageInfo=pageInfo;
    }

    public List<T> getDatasource(){
        return  datasource;
    }

    public  void setDatasource(List<T> datasource){
        this.datasource=datasource;
    }
    public  PageInfo getPageInfo(){
        return  pageInfo;
    }
    public  void setPageInfo(PageInfo pageInfo){
        this.pageInfo=pageInfo;
    }
}
