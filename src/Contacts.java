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
}
