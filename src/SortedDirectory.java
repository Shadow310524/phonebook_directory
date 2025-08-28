import java.util.LinkedHashMap;
import java.util.Map;

public class SortedDirectory {
    private final Map<String,Integer> sorted_log;

    public SortedDirectory() {
        this.sorted_log = new LinkedHashMap<>();
    }

    public Map<String, Integer> getSorted_log() {
        return sorted_log;
    }

    public void addCall(String name){
        sorted_log.put(name,sorted_log.getOrDefault(name,1)+1);
    }
}
