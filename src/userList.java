import java.util.ArrayList;

public class userList {
    private ArrayList<user> users;

    public userList() {
        users = new ArrayList<>();
    }

    public void addUser(user user) {
        users.add(user);
    }

    public ArrayList<user> getUsers() {

        return users;
    }

    //make method to show all user
    public void showAllUser(){
        for(user user : users){
            System.out.println(user.getName());
            System.out.println(user.getEmail());
            System.out.println(user.getPassword());
        }
    }

    public void setUsers(ArrayList<user> users) {
        this.users = users;
    }

    public user getUser(int index) {
        return users.get(index);
    }

    public int getSize() {
        return users.size();
    }
}
