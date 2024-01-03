package JavaSetFundementals.set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressWarnings({"all"})
public class SetMethod {
    public static void main(String[] args) {
        // 1. 以接口的实现类 HashSet 来讲解 set 的接口方法
        // 2. set 接口实现类的对象(Set obj), 不能方重复的元素，可以添加一个null
        // 3. set 接口存放对象是无序的(即添加的顺序和取出的顺序不同）
        // 4. Attention： 取出的数据虽然不是添加的顺序，但是顺序是固定的
        Set set = new HashSet();
        set.add("Kris");
        set.add("John");
        set.add("Lucy");
        set.add(null);
        System.out.println(set);

        set.remove(null);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
}
