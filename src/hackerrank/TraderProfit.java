package hackerrank;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Mike is a stock trader and makes a profit by buying and selling stocks. He buys a stock at a lower price and sells it at a higher price to book a profit. He has come to know the stock prices of a particular stock for  upcoming days in future and wants to calculate the maximum profit by doing the right transactions (single transaction = buying + selling). Can you help him maximize his profit?

 Note: A transaction starts after the previous transaction has ended. Two transactions can't overlap or run in parallel.

 The stock prices are given in the form of an array  for  days.

 Given the stock prices and a positive integer , find and print the maximum profit Mike can make in at most transactions.

 For example,  stock prices are given as , and . For one transaction, maximum profit is  when stock is purchased on day  and sold on day .

 Input Format

 The first line of input contains an integer  denoting the number of queries.

 The first line of each test case contains a positive integer , denoting the number of transactions.

 The second line of each test case contains a positive integer , denoting the length of the array .

 The third line of each test case contains  space-separated positive integers, denoting the prices of each day in the array .

 Constraints





 Output Format

 For each query print the maximum profit earned by Mike on a new line.

 Sample Input 0

 3
 2
 6
 10 22 5 75 65 80
 3
 4
 20 580 420 900
 1
 5
 100 90 80 50 25
 Sample Output 0

 87
 1040
 0
 Explanation 0

 Output 1: Mike earns  as sum of  and  i.e. Buy at price , sell at , buy at  and sell at
 Output 2: Mike earns  as sum of  and  i.e. Buy at price , sell at , buy at  and sell at
 Output 3: Mike cannot make any profit as selling price is decreasing day by day. Hence, it is not possible to earn anything.

 Contest ends in a day
 Submissions: 2498
 Max Score: 35
 Difficulty: Medium
 Rate This Challenge:

 More
 Current Buffer (saved locally, editable)

 Java 8

 */
public class TraderProfit {

    @Test
    public void test() {
        int trans1 = 2;
        int[] ints = new int[]{10,22,5,75,65,80};

        Assert.assertEquals(87,traderProfit(trans1,ints.length,ints));

        trans1=3;
        ints = new int[]{20, 580, 420, 900};

        Assert.assertEquals(1040,traderProfit(trans1,ints.length,ints));

        trans1=1;
        ints = new int[]{100, 90, 80, 50, 25};
        Assert.assertEquals(0,traderProfit(trans1,ints.length,ints));

        Assert.assertEquals(0,traderProfit(trans1,0,new int[]{}));

    }

    class Transaction implements Comparable<Transaction> {
        Integer profit;
        int day1;
        int day2;

        public Transaction(int profit, int day1, int day2) {
            this.profit = profit;
            this.day1 = day1;
            this.day2 = day2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Transaction that = (Transaction) o;

            if(this.day2>=that.day1 && this.day1<=that.day2) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            int result = profit;
            result = 31 * result + day1;
            result = 31 * result + day2;
            return result;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "profit=" + profit +
                    ", day1=" + day1 +
                    ", day2=" + day2 +
                    '}';
        }

        @Override
        public int compareTo(Transaction o) {
            return o.profit.compareTo(this.profit);
        }
    }

    void back(List<Transaction> temp, List<Transaction> possibleTrans, List<List<Transaction>> subset, int start, int maxSize) {

        if(temp.size()<=maxSize) {
            subset.add(new LinkedList<>(temp));
        }


        for(int i=start; i<possibleTrans.size(); i++) {
            Transaction actual = possibleTrans.get(i);

            if(temp.contains(actual)) {
                continue;
            }
            temp.add(actual);
            back(temp,possibleTrans,subset,i+1,maxSize);
            temp.remove(temp.size()-1);
        }

    }

    int traderProfit(int k, int n, int[] A) {
        List<Transaction> possibleTrans=new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int profit = A[j] - A[i];
                if(profit >0) {
                    possibleTrans.add(new Transaction(profit,i,j));
                }
            }
        }
        if(possibleTrans.size()==0) {
            return 0;
        }

        List<List<Transaction>> list = new LinkedList<>();

        back(new LinkedList<Transaction>(),possibleTrans,list,0, k);


        int maxProfix =0;
        for (List<Transaction> transactions : list) {
            int profit =0;
            for (Transaction transaction : transactions) {
                profit+=transaction.profit;
            }
            if(profit>maxProfix)
                maxProfix=profit;
        }


        return maxProfix;
    }
}
