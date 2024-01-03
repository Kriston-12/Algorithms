package JavaSetFundementals;
import java.util.HashMap;
import java.util.Map;
@SuppressWarnings({"ALL"})

public class Map_ {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("Luhan", "Guanxiaotong");
        map.put(null, null);
        map.put(null, "abc");  // key 只能有一个， 所以 "abc" 会替换之前的null 成为null新的value
        map.put(1, "zhaomin");
        map.put(new Object(), "zhangwuji");
        System.out.println(map.get("Luhan"));
    }
}
