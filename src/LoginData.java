public class LoginData {
    private String name;
    private String password;

    public LoginData(String username, String password){
        this.name = username;
        this.password = password;
    }

    //getter
    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    //setter

    public void setName(String name){
        this.name = name;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
