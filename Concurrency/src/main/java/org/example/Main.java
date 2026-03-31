package org.example;

import java.util.concurrent.*;

public class Main {
    static void main() throws InterruptedException
    {
        int loops = 100;

        Player p = new Player("Boss");
        AttackLog l = new AttackLog();

        ExecutorService pool = Executors.newFixedThreadPool(5);

        for (int i = 0; i < loops; i++)
        {
            int id = i;
            pool.submit(() -> l.log("Attack " + id));
        }

        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("expected " + loops);
        System.out.println("actual " + l.getAttacks().size());
        System.out.println(l.getAttacks());
    }
}
