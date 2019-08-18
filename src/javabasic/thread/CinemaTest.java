package javabasic.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhouwei
 * @Description: 并发同步-模拟购票
 * @Date: 2019/8/16 19:08
 * @Version: 1.0
 **/
public class CinemaTest {

    public static void main(String[] args) {
        ArrayList<Integer> availableSeatlist = new ArrayList();
        for (int i=0; i<20; i++) {
            availableSeatlist.add(i);
        }
        Cinema cinema = new Cinema("Timing影院",availableSeatlist);

        List<Integer> seatList1 = Arrays.asList(1,2,5);
        new Thread(new Customer(cinema,seatList1),"customer1").start();
        List<Integer> seatList2 = Arrays.asList(3,4,5);
        new Thread(new Customer(cinema,seatList2),"customer2").start();
    }

    /**
     * 顾客
     */
    static class Customer implements Runnable {
        final Cinema cinema;
        List<Integer> seatList;
        public Customer(Cinema cinema, List<Integer> seatList) {
            this.cinema = cinema;
            this.seatList = seatList;
        }

        @Override
        public void run() {
            synchronized (cinema) {
                boolean flag = cinema.buy(seatList);
                if (flag) {
                    System.out.println("出票成功！" + Thread.currentThread().getName());
                } else {
                    System.out.println("出票失败！" + Thread.currentThread().getName());
                }
            }
        }
    }

    /**
     * 电影院
     */
    static class Cinema {
        private List<Integer> available;
        private String name;
        public Cinema(String name, List<Integer> available) {
            this.name = name;
            this.available = available;
        }

        /**
         * 购票
         * @param seatList 座位集
         * @return
         */
        boolean buy(List<Integer> seatList) {
            System.out.print("可用位置：");
            available.forEach(System.out::print);
            System.out.println();
            List<Integer> copy = new ArrayList<>();
            copy.addAll(available);

            copy.removeAll(seatList);
            if ((available.size()-copy.size())==seatList.size()) {
                available = copy;
                return true;
            } else {
                return false;
            }
        }

    }

}
