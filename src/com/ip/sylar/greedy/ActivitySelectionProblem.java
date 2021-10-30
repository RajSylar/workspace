package com.ip.sylar.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelectionProblem {
    public static void main(String[] args) {
        int[] start = new int[]{10, 12, 20, 4};
        int[] finish = new int[]{20, 25, 30, 11};
        int n = start.length;

        System.out.println(findMaxActivity(start, finish, n));
    }

    static class Activity {
        int start;
        int finish;

        public Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        public int getFinish() {
            return this.finish;
        }
    }

    private static int findMaxActivity(int[] start, int[] finish, int n) {
        Activity[] activity = new Activity[n];
        for (int i = 0; i < n; i++) {
            activity[i] = new Activity(start[i], finish[i]);
        }

        Comparator<Activity> comp = Comparator.comparing(Activity::getFinish);

        Arrays.sort(activity, comp);

        int maxAct = 1;

        int i = 0;

        for (int j = 1; j < n; j++) {
            if (activity[j].start >= activity[i].finish) {
                maxAct = maxAct + 1;
                i = j;
            }
        }
        return maxAct;
    }
}
