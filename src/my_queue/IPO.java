package my_queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    class pair{
        int capital;
        int profit;
        pair(int c, int p){
            capital = c;
            profit = p;
        }
    }
    public  int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
//        Capital heap is a MIN heap based on capital
        PriorityQueue<pair>cap_heap  = new PriorityQueue<pair>(new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                if (o1.capital > o2.capital)
                    return 1;
                if (o1.capital < o2.capital)
                    return -1;
                return 0;
            }
        });

//        Build proift MAX heap by considering profit
        PriorityQueue<pair>profit_heap = new PriorityQueue<pair>(new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                if(o1.profit < o2.profit)
                    return 1;
                if(o1.profit > o2.profit)
                    return -1;
                return 0;
            }
        });
        for(int i =0;i<Capital.length;i++){
            cap_heap.add(new pair(Capital[i], Profits[i]));
        }
        System.out.println("Top element from capital queue is" + cap_heap.peek().capital);
        while(k > 0 ) {
            while (cap_heap.isEmpty() == false && W >= cap_heap.peek().capital) {
                pair tmp = cap_heap.poll();
                profit_heap.add(tmp);
            }
            if (profit_heap.isEmpty() == false) {
                W += profit_heap.poll().profit;
            }
            k--;
        }
        return W;
    }
    public static void main(String args[]){
        IPO ip = new IPO();
        int k = 2;
        int w = 0;
        int profit [] = {1, 2, 3,};
        int capital [] = {0, 1, 1};
        System.out.println("Max profit is " + ip.findMaximizedCapital(k, w, profit, capital));
    }
}
