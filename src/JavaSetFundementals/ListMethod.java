package JavaSetFundementals;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Tom");
        list.add("Jack");
        list.add("Chris");
        list.add("Victoria");

        // 1. void add(int index, object element)
        list.add(4, "Boom");
        System.out.println(list);

        // 2. Object get(index)
        System.out.println(list.get(2));

        // 3. boolean addAll
        List list1 = new ArrayList();
        list1.add("Uzi");
        list1.add("Wolf");
        list.addAll(list1);
        System.out.println(list);

        // 4. int indexOf(Object obj)   return the index of the first element(object)
        list1.add("Uzi");
        System.out.println(list1.indexOf("Uzi"));

        // 5. int lastIndexOf(Object obj)
        System.out.println(list1.lastIndexOf("Uzi"));

        // 6. Object remove(int index) or (Object obj)
        list.remove("Wolf");
        System.out.println("After remove ele----" + list);
        list.remove(1);
        System.out.println("After remove index----" + list);

        // 7. Object set(int index, Object element)
        list.set(0, "Thomas");
        list.set(2, "Kriston");
        System.out.println(list);

        // 8. List subList(int fromIndex, int toIndex)

        System.out.println(list.subList(1, 3));


        Iterator iterator = list.iterator();
        while(iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
}
