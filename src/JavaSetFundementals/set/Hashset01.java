package JavaSetFundementals.set;
import java.util.HashSet;

@SuppressWarnings({"all"})
public class Hashset01 {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        System.out.println(set.add("John"));
        System.out.println(set.add("Kris"));
        System.out.println(set.add("Tom"));
        System.out.println(set.add("Tony"));
        System.out.println(set.add("John"));

        System.out.println(set);
        set.add(new Dog("lucy"));
        set.add(new Dog("lucy"));
        System.out.println(set);

        set.add(new String("hsp"));
        set.add(new String("hsp"));
        System.out.println(set);

    }
}

class Dog
{
    public String name;
    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}