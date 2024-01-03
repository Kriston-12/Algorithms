package InterProbP25;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

// video explain see https://www.bilibili.com/video/BV13g41157hK/?p=25&spm_id_from=pageDriver&vd_source=d67679eb2bbd122f6cd7f6d142b724f3 1:30min
public class ChooseJob {
    public static class Job {
        int hard;   // the demanding(difficulty level) of the job
        int money;  // payment
        public Job(int a, int b) {
            hard = a;
            money = b;
        }
    }

    public static class JobComparator implements Comparator<Job> {
        public int compare(Job o1, Job o2) {
            return o1.hard != o2.hard ? o1.hard - o2.hard : o2.money - o1.money;
        }
    }

    public static int[] getBestJob(Job[] job, int[] ability) {
        Arrays.sort(job, new JobComparator());
        int pre = job[0].money;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(job[0].hard, job[0].money);
        for (int i = 1; i < job.length; i++) {
            if (job[i].money > pre) {
                map.put(job[i].hard, job[i].money);
                pre = job[i].money;
            }
        }
        int[] res = new int[ability.length];
        for (int i = 0; i < res.length; i++) {
            Integer key = map.floorKey(ability[i]);
            res[i] = key != null ? map.get(key) : 0;
        }
        return res;
    }
}
