package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    static void main() throws InterruptedException
    {
        int loops = 10;

        Player p = new Player("Boss");
        AttackLog l = new AttackLog();

        ExecutorService pool = Executors.newFixedThreadPool(5);

        List<Future<Integer>> results = new ArrayList<>();

        for (int i = 0; i < loops; i++)
        {
            results.add
                    (
                            pool.submit(() ->
                            {
                                Thread.sleep(100);
                                return 10;
                            })
                    );
        }

        int totalDamage = 0;

        for (Future<Integer> future : results)
        {
            try
            {
                totalDamage += future.get();
                } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        pool.shutdown();

        System.out.println("Total damage " + totalDamage);
    }
}
