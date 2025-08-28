import java.util.*;

public class ContactService {

    private final ContactDirectory cd = new ContactDirectory();
    private final UserDirectory ud = new UserDirectory();
    private final DialledDirectory dd = new DialledDirectory();
    private final SortedDirectory sd = new SortedDirectory();
//    Add Contacts
    public void addContact(String user_name, Contacts contact){
        if(cd.addContact(contact)) {
            System.out.println(contact.getName()+" Contact added");
        }
        else
            System.out.println(contact.getName()+" Contact already exist");
    }

//    Remove
    public void removeContact(String user_name,String name) {
        Users user=ud.getUser(user_name);
        if(cd.removeContact(name))
            System.out.println("Successfully deleted");
        else
            System.out.println("Contact Not found");
    }


//Print
    public void printContact(String user_name) {
        Users user=ud.getUser(user_name);
        System.out.println("----------------------");
        System.out.println("Contacts");
        System.out.println("----------------------");
        for(Contacts c:cd.getContacts()){
            String name = c.getName();
            long phone_no = c.getPhone_No();
            System.out.println(name + "->"+phone_no);
        }
            System.out.println("----------------------");
    }

    public void updateContact(String user_name,String name,long phone_no) {
        Users user=ud.getUser(user_name);
        Contacts contact=cd.getContact(name);
        if(contact!=null) {
            contact.setPhone_no(phone_no);
            System.out.println("Phone number updated successfully");
        }
        else
            System.out.println("No contact exists");

    }

    public void printLogDetails(String user_name) {
        Users user=ud.getUser(user_name);
        List<Map.Entry<String,Integer>> list=new ArrayList<>(sd.getSorted_log().entrySet());
        list.sort((a,b)->b.getValue().compareTo(a.getValue()));
        System.out.println(user_name);
        for(Map.Entry<String,Integer> logs:list) {
            String name = logs.getKey();
            System.out.println("-------------------------------------------");
            System.out.println("-------------------------------------------");
//            for(Map.Entry<String,Integer> list:sorted_list){
            System.out.println(logs.getKey()+"->"+logs.getValue());
//            }
        }
    }

    public void print(String user_name){
        Users user=ud.getUser(user_name);
        List<Contacts> contacts= (List<Contacts>) cd.getContacts();
            System.out.println("-------------------------------------------");
            System.out.println(user_name);
            System.out.println("-------------------------------------------");
        for(Contacts c:contacts){
            System.out.println("-------------------------------------------");
            System.out.println(c.getName()+"->"+c.getPhone_No());
            System.out.println("-------------------------------------------");
        }
    }

    public void dial(String user_name, String name) {
        Users user=ud.getUser(user_name);
        Contacts c=cd.getContact(name);
        if(c!=null){
            System.out.println("Dialled to "+name);
            dd.dialContact(c);
            sd.addCall(name);
        }
        else{
            System.out.println("Dialled to "+name);
        }
    }
}
