package ca.bytetube._13_greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 思路：minCost && maxProfit
 * k:项目的数量
 * W:能投入的钱
 *
 */

public class IPO {

    public static class Project {
        public int cost;
        public int profit;

        public Project(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }

    public static int IPO (int k, int W, int[] profits, int[] costs){
        Project[] projects = new Project[profits.length];
        for (int i = 0; i < projects.length; i++) {
            projects[i] = new Project(costs[i], profits[i]);
        }

        PriorityQueue<Project> minCostQ = new PriorityQueue<>(new Comparator<Project>() {
            @Override
            public int compare(Project e1, Project e2) {
                return e1.cost - e2.cost;
            }
        });

        PriorityQueue<Project> maxProfitQ = new PriorityQueue<>(new Comparator<Project>() {
            @Override
            public int compare(Project e1, Project e2) {
                return e2.profit - e1.profit;
            }
        });

        for (int i = 0; i < projects.length ; i++) {
            minCostQ.add(projects[i]);
        }

        for (int i = 0; i < k ; i++) {
            while(!minCostQ.isEmpty() && minCostQ.peek().cost <= W){
                maxProfitQ.add(minCostQ.poll());
            }

            if(maxProfitQ.isEmpty()) return W;

            W += maxProfitQ.poll().profit;
        }

        return W;
    }
}
