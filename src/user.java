public class user {
    //the data only name, email and password
    private String name;
    private String email;
    private String password;

    //constructor
    public user(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    //getter
    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    //setter

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
