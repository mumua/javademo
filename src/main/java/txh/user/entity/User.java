package txh.user.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by 46623 on 2018/8/6.
 */
@Entity
@Table(name = "\"user6\"")
public class User {
    @Id
    @GeneratedValue(generator = "uuidGen")
    @GenericGenerator(name="uuidGen",strategy = "uuid")
    @Column(name = "\"id\"",length = 50)
    private  String id;
    private String name;
    private String login;
    private String password;

    /**
     * 无参数的构造函数
     */
    public User(){

    }

    /**
     * 带参数的构造函数
     * @param id
     * @param name
     * @param login
     * @param password
     */
    public User(String id,String name,String login,String password){
        this.id=id;
        this.name=name;
        this.login=login;
        this.password=password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName(){
        return  name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword(){
        return  password;
    }
    public void setPassword(){
        this.password=password;
    }
}
