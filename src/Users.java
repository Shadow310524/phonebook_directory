 import java.util.List;
 import java.util.Objects;

    public class Users {
        String name;
        String password;
        private ContactDirectory contactDirectory;
        private DialledDirectory dialledDirectory;
        private SortedDirectory sortedDirectory;

        Users(String name,String password){
            this.name=name;
            this.password=password;
            this.contactDirectory = new ContactDirectory();
            this.dialledDirectory = new DialledDirectory();
            this.sortedDirectory = new SortedDirectory();
        }
        public String getName(){
            return name;
        }
        public String getPassword(){
            return password;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPassword(String password) {
            this.password = password;
        }
        public DialledDirectory getDialledDirectory(){
            return dialledDirectory;
        }

        @Override
        public boolean equals(Object o){
            if(this==o) return true;
            if(!(o instanceof Users)) return false;
            Users u=(Users) o;
            return Objects.equals(u.name,name);
        }

        @Override
        public int hashCode(){
            return Objects.hash(name);
        }

    }
