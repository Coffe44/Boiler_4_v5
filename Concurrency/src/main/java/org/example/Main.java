package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    static void main() throws InterruptedException
    {
        int loops = 50;
        ExecutorService pool = Executors.newFixedThreadPool(10);

        Player boss = new Player("Boss");
        List<Future<Integer>> attacks = new ArrayList<>();

        for (int i = 0; i < loops; i++)
        {
            attacks.add
                    (
                            pool.submit(() ->
                            {
                                int damage = 2;
                                boss.takeDamage(damage);
                                return damage;
                            })
                    );
        }

        int totalDamage = 0;

        for (Future<Integer> future : attacks)
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

        System.out.println("Expected damage: " + totalDamage);
        System.out.println("Boss's health: " + boss.getHealth());
    }
}
