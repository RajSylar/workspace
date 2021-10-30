package com.ip.sylar.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class JobSequencingWithDeadlines {

    static class Job {
        int id;
        int profit;
        int deadline;

        public Job(int id, int profit, int deadline) {
            this.id = id;
            this.profit = profit;
            this.deadline = deadline;
        }

        public int getProfit()
        {
            return this.profit;
        }
    }

    public static void main(String[] args) {
        ArrayList<Job> arr = new ArrayList<Job>();

        arr.add(new Job(1, 2, 100));
        arr.add(new Job(2, 1, 19));
        arr.add(new Job(3, 2, 27));
        arr.add(new Job(4, 1, 25));
        arr.add(new Job(5, 3, 15));

        int t = 3;
        System.out.println(makeJobSchedule(arr, t));
    }

    private static int makeJobSchedule(ArrayList<Job> arr, int t) {

        Collections.sort(arr, Comparator.comparing(Job::getProfit).reversed());

        boolean[] marked = new boolean[t];

        int maxProfit = 0;

        for(int i=0; i<arr.size(); i++)
        {
            int deadline = arr.get(i).deadline;
            for(int j=Math.min(t-1, deadline-1) ; j>=0; j--)
            {
                if(marked[j] == false)
                {
                    marked[j]= true;
                    maxProfit = maxProfit + arr.get(i).profit;
                    break;
                }
            }
        }
        return maxProfit;
    }


}
