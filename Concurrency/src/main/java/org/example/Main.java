package org.example;

import java.util.concurrent.*;

public class Main {
    static void main() throws InterruptedException {
        Player p = new Player("Boss");

        ExecutorService pool = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 200; i++)
        {
            int x = i;
            pool.submit(() ->
            {
                p.takeDamage(2);
                System.out.println("X " + x);
            });

            System.out.println("loop " + i);
        }

        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);

        Thread.sleep(1000);

        System.out.println(p.getHealth());
    }
}
