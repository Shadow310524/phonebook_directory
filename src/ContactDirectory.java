import java.util.*;

public class ContactDirectory {
    private final Map<String,Contacts> contacts;
    public ContactDirectory(){
        this.contacts=new LinkedHashMap<>();
    }
    public boolean addContact(Contacts contact){
        if(!contacts.containsKey(contact.getName())) {
            contacts.put(contact.getName(), contact);
            return true;
        }
        return false;
    }

    public boolean removeContact(String name){
//        contacts.removeIf(c -> c.name.equals(name));
        if(contacts.containsKey(name)){
            contacts.remove(name);
            return true;
        }
        return false;
    }
    public Contacts getContact(String name){
        if(contacts.containsKey(name)){
            return contacts.get(name);
        }
        return null;
    }

    public Collection<Contacts> getContacts() {
        return contacts.values();
    }
}
