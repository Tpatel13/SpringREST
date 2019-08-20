package Models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="admin")
@IdClass(Admin.class)
public class Admin implements Serializable {

    @Id
    private int id;
    private String password, email;

    @Column(unique = true)
    private String name;

    public Admin(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public Admin(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
