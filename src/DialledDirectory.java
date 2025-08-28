import java.util.ArrayList;
import java.util.List;

public class DialledDirectory {
    private final List<Contacts> dialled_log;

    public DialledDirectory(){
        this.dialled_log=new ArrayList<>();
    }
    public List<Contacts> getDialled_log() {
        return dialled_log;
    }
    public void dialContact(Contacts c){
         dialled_log.add(c);
    }
}
