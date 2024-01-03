package JavaSetFundementals.set;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"all"})
public class MapExercise {
    public static void main(String[] args) {
        Map hashmap = new HashMap();
        hashmap.put(1, new Employee("Jack", 300000, 1));
        hashmap.put(2, new Employee("Tom", 21000, 2));
        hashmap.put(3, new Employee("Mary", 15000, 3));
        // Method1
        Set keyset1 = hashmap.keySet();
        for (Object key : keyset1) {
            Employee emp = (Employee) hashmap.get(key);
            if (emp.getSalary() > 18000) {
                System.out.println(emp);
            }
        }

        // Method2
        Set entrySet = hashmap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Employee emp = (Employee) entry.getValue();
            if (emp.getSalary() > 18000) {
                System.out.println(emp);
            }
        }
    }
}

class Employee {
    private String name;
    private int salary;
    private int id;

    public Employee() {
    }

    public Employee(String name, int salary, int id) {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }
}