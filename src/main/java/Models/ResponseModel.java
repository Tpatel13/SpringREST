package Models;

public class ResponseModel {

    private String name;
    private String password;
    private String message;
    private String email;
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseModel(String name, String password, String message) {
        this.name = name;
        this.password = password;
        this.message = message;
    }

    public ResponseModel(String name, String password, String message, String email) {
        this.name = name;
        this.password = password;
        this.message = message;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
