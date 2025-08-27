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

    public void printLogDetails(Map<String,Map<String,Integer>> sortedLog) {
        for(Map.Entry<String,Map<String,Integer>> logs:sortedLog.entrySet()) {
            String name = logs.getKey();
            Map<String,Integer> call_log=logs.getValue();
            List<Map.Entry<String, Integer>> sorted_list = new ArrayList<>(call_log.entrySet());
            sorted_list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
            System.out.println("-------------------------------------------");
            System.out.println(name);
            System.out.println("-------------------------------------------");
            for(Map.Entry<String,Integer> list:sorted_list){
                System.out.println(list.getKey()+"->"+list.getValue());
            }
        }

    }

    public void dial(String user_name, String name, Map<String,Map<String,Integer>> sortedLog) {
        Set<Contacts> s=Main.phonebook.get(user_name);
        for(Contacts c:s){
            if(c.name.equals(name)) {
                System.out.println("Dialling to " + name);
                if (!Main.dialedLog.containsKey(user_name)) {
                    Main.dialedLog.put(user_name, new ArrayList<>());
                    Main.dialedLog.get(user_name).add(c);
                } else
                    Main.dialedLog.get(user_name).add(c);
            }
            else
                System.out.println("No Contacts Found");
            if(!sortedLog.containsKey(user_name))
                Main.sortedLog.put(user_name,new HashMap<>());
                Map<String,Integer> userLog=sortedLog.get(user_name);
                userLog.putIfAbsent(name,1);
                userLog.put(name,userLog.get(name)+1);
            }
        }
    }
