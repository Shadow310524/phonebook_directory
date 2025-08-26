import java.util.*;

public class ContactService {

//    Add Users

    public void addUser(String userName, String password) {
        Main.users.put(userName,password);
        System.out.println(userName+" added Successfully!!");
    }


//    Check Users
public boolean checkUser(String userName, String password) {
    if(Main.users.get(userName).equals(password)){
        System.out.println("logged in successfully as "+userName);
        System.out.println("------------------------------------");
        return true;
    }
    else
        System.out.println("Invalid Username or password");
    return false;
}

//    Add Contacts
    public void addContact(String user_name, Contacts contact){
        if(!Main.phonebook.containsKey(user_name)) {
            Main.phonebook.put(user_name, new HashSet<>());
            Main.phonebook.get(user_name).add(contact);
        }
        else
            Main.phonebook.get(user_name).add(contact);
    }

//    Remove
    public void removeContact(String user_name,String name) {
        Set<Contacts> s=Main.phonebook.get(user_name);
        for (Contacts c:s){
            if(c.name.equals(name)) {
                s.remove(c);
                System.out.println("Removed Successfully!!");
            }
        }
    }


//Print
    public void printContact(Map<String,Set<Contacts>> phonebook) {
        for(Map.Entry<String,Set<Contacts>> entry:phonebook.entrySet()){
            Set<Contacts> temp=entry.getValue();
            System.out.println(entry.getKey());
            System.out.println("----------------------");
            for (Contacts c:temp) {
                String name = c.getName();
                long phone_no = c.getPhone_No();
                System.out.println(name + "->"+phone_no);
            }
            System.out.println("----------------------");
        }
    }

    public void updateContact(String user_name,String name,long phone_no) {
        Set<Contacts> s=Main.phonebook.get(user_name);
        for (Contacts c:s){
            if(c.name.equals(name)) {
                c.setPhone_no(phone_no);
                System.out.println("Phone number Updated Successfully!!");
            }
        }
    }

    public void printLogDetails(Map<String,Integer> sortedLog) {
        List<Map.Entry<String,Integer> sorted_list=new ArrayList<>(sortedLog.entrySet());
        sorted_list.sort((a,b)->b.getValue().compareTo(a.getValue()));

    }

    public void dial(String user_name, String name, Map<String, Integer> sortedLog) {
        Set<Contacts> s=Main.phonebook.get(user_name);
        for(Contacts c:s){
            if(c.name.equals(name)){
                System.out.println("Dialling to "+name);
                if(!Main.dialedLog.containsKey(c)){
                    Main.dialedLog.put(user_name,c);
                }
                else
                    Main.dialedLog.put(user_name,c);

                if(!sortedLog.containsKey(name)){
                    Main.dialedLog.put(user_name,c);
                }
                else
                    Main.dialedLog.put(user_name,c);
            }
        }
    }
}
