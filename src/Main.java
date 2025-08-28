import java.util.*;
public class Main {
    static Map<String,Map<String,Integer>> sortedLog=new HashMap<>();
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        System.out.println("-------------------Phone Contact Directory---------------------");
        String current_user="";
        boolean current=false;
        int n;
        UserService u=new UserService();
        ContactService c = new ContactService();
        while(true){
            while(!current) {
                System.out.println("1)Add User");
                System.out.println("2)Login User");
                n=inp.nextInt();
                inp.nextLine();
                String user_name;
                String password;
                switch (n) {
                    case 1:
                        System.out.println("Enter UserName");
                        user_name = inp.nextLine();
                        System.out.println("Enter Password");
                        password = inp.nextLine();
                        u.addUser(user_name, password);
                        break;
                    case 2:
                        System.out.println("Enter UserName");
                        user_name = inp.nextLine();
                        System.out.println("Enter Password");
                        password = inp.nextLine();
                        if(u.checkUser(user_name, password)) {
                            current_user = user_name;
                            current=true;
                        }
                        break;
                }
            }
            while(current==true){
                System.out.println("1)Add Contacts");
                System.out.println("2)Remove Contacts");
                System.out.println("3)Update Contacts");
                System.out.println("4)Print Contacts");
                System.out.println("5)Dial Contacts");
                System.out.println("6)Call Logs");
                System.out.println("7)Logout");
                System.out.println("8)Exit");
                n= inp.nextInt();
                inp.nextLine();
                String name;
                long phone_no;
                switch (n){
                    case 1:
                        System.out.println("Enter Contact name:");
                        name= inp.nextLine();
                        System.out.println("Enter Contact number:");
                        phone_no= inp.nextLong();
                        Contacts contact=new Contacts(name,phone_no);
                        c.addContact(current_user,contact);
                        break;
                    case 2:
                        System.out.println("Enter Contact name:");
                        name= inp.nextLine();
                        c.removeContact(current_user,name);
                        break;
                    case 3:
                        System.out.println("Enter Contact name:");
                        name= inp.nextLine();
                        System.out.println("Enter Updated phone number:");
                        phone_no= inp.nextLong();
                        c.updateContact(current_user,name,phone_no);
                        break;
                    case 4:
                        System.out.println("-------------------Printing Contact Details-------------------");
                        c.printContact(current_user);
                        break;
                    case 5:
                        System.out.println("Which Contact to Dial");
                        name= inp.nextLine();
                        c.dial(current_user,name);
                        break;
                    case 6:
                        System.out.println("-------------------Printing Call Logs-------------------");
                        c.printLogDetails(current_user);
                        break;
                    case 7:
                        System.out.println("-------------------Printing Call Logs-------------------");
                        c.print(current_user);
                        break;
                    case 8:
                        current=false;
                        System.out.println("Logging Out!!");
                        break;
                    case 9:
                        inp.close();
                        return;
                    default:
                        System.out.println("Shutting down!!");
                        break;
                }
            }
        }
    }

}