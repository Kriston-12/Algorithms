package SlidingWindowMonotonicStack;

import java.util.List;

public class MaxHappy {
    public static class Employee{
        public int happy;
        public List<Employee> subordinates;

        public Employee(int happy, List<Employee> subordinates) {
            this.happy = happy;
            this.subordinates = subordinates;
        }
    }

    public static class Info {
        public int laiMaxHappy;  // 来的时候的最大快乐
        public int buMaxHappy;   // 不来的时候的最大快乐

        public Info(int lai, int bu) {
            this.laiMaxHappy = lai;
            this.buMaxHappy = bu;
        }


        public static int MaxHappy(Employee boss) {
            Info headInfo = process(boss);
            return Math.max(headInfo.laiMaxHappy, headInfo.buMaxHappy);
        }
        public static Info process(Employee x) {
            if ((x.subordinates).isEmpty()) {       // x是基层员工，没有下级
                return new Info(x.happy, 0);
            }
            int lai = x.happy;
            int bu = 0;
            for (Employee nexts : x.subordinates) {
                Info nextInfo = process(nexts);
                lai += nextInfo.buMaxHappy;
                bu += Math.max(nextInfo.laiMaxHappy, nextInfo.buMaxHappy);
            }
            return new Info(lai, bu);
        }
    }

}
