import java.util.Objects;

public class Contacts {
    String name;
    long phone_no;

    Contacts(String name,long phone_no){
        this.name=name;
        this.phone_no=phone_no;
    }
    public String getName(){
        return name;
    }
    public long getPhone_No(){
        return phone_no;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setPhone_no(long phone_no){
        this.phone_no=phone_no;
    }
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof Contacts)) return false;
        Contacts c=(Contacts) o;
        return Objects.equals(c.name,name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
}
