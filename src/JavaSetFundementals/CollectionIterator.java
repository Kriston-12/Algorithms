package JavaSetFundementals;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionIterator {
    public static void main(String[] args) {
        Collection col = new ArrayList();

        col.add(new Book("sanguo", "luo", 10.1));
        col.add(new Book("xiyou", "wu", 5.1));
        col.add(new Book("honglou", "cao", 34.6));

        Iterator iterator = col.iterator();
        while(iterator.hasNext()){      // 快捷键：itit
            Object obj = iterator.next();
            System.out.println(obj);
        }
//        iterator.next();  Exception: No such Element
        // 如果希望再次遍历，则需要重置编译器
        iterator = col.iterator();

        for (Object Book: col) {
            System.out.println("Book = " + Book);
        }

        int[] arr1 = {1, 3, 5, 8, 5};

        for(int i: arr1) {
            System.out.println(i);
        }
    }
}

class Book {
    public String name;
    public String authorName;
    public double price;

    public Book(String name, String authorName, double price) {
        this.name = name;
        this.authorName = authorName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", authorName='" + authorName + '\'' +
                ", price=" + price +
                '}';
    }
}
