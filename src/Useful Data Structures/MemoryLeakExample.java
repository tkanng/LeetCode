
import java.util.HashMap;
import java.util.Map;


public class MemoryLeakExample {

    public static void main(String[] args) {

        Map<CustomKey, String> map = new HashMap<CustomKey, String>();
        // 通过new CustomKey() put一个对象，不保存这个引用的话，未来是无法使用这个值的
        // But this entry is not able to GCed as the map has a reference to it but application can’t access it. Surely a memory leak.
        map.put(new CustomKey("Shamik"), "Shamik Mitra");
        String val = map.get(new CustomKey("Shamik"));
        System.out.println("Missing equals and hascode so value is not accessible from Map " + val);

    }
}

class CustomKey {

    CustomKey(String name) {
        this.name = name;
    }
    private String name;
}

