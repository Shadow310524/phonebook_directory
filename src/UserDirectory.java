import java.util.LinkedHashMap;
import java.util.Map;

public class UserDirectory {
    private final Map<String,Users> users;

    public UserDirectory(){
        this.users=new LinkedHashMap<>();
    }
    public boolean adduser(Users user){
        if(users.containsKey(user.getName()))
            return false;
        else{
            users.put(user.getName(),new Users(user.getName(), user.getPassword()));
            return true;
        }
    }
    public boolean checkUser(String name,String password){
            Users u=users.get(name);
            if(u!=null)
                return u.getPassword().equals(password);
            return false;
    }
    public Map<String,Users> getUsers(){
        return users;
    }
    public Users getUser(String name){
        return users.get(name);
    }
}
