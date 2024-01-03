package GreedyAlgorithm;


import java.util.Arrays;
import java.util.Comparator;

public class BestArrange {

    // 按照结束时间从早到晚的comparator
    public static class ProgramComparator implements Comparator<Program> {
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }
    public static int bestArrange(Program[] program, int timePoint) {
        Arrays.sort(program, new ProgramComparator());
        int result = 0;
        for (int i = 0; i < program.length; i++) {
            if (timePoint <= program[i].start) {
                result++;
                timePoint = program[i].end;
            }
        }
        return result;
    }
}

class Program {
    int start;
    int end;
    Program() {}
}

