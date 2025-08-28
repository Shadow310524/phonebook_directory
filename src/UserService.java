public class UserService {
//    Instatntiating User Directory
    private UserDirectory ud=new UserDirectory();

    //    Add Users
    public void addUser(String userName, String password) {
        Users user=new Users(userName,password);
        if(ud.adduser(user)) {
            System.out.println(userName + " added Successfully!!");
        }
        else {
            System.out.println(userName + " exists already!!");
        }
    }

    //    Check Users
    public boolean checkUser(String userName, String password) {
        if(ud.checkUser(userName,password)){
            System.out.println("logged in successfully as "+userName);
            System.out.println("------------------------------------");
            return true;
        }
        else
            System.out.println("Invalid Username or password");
        return false;
    }
}
