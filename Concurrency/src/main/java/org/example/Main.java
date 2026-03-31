package org.example;

public class Main {
    static void main() throws InterruptedException {
        Player p = new Player("Boss");

        for (int i = 0; i < 100; i++)
        {
            int x = i;
            new Thread(() ->
            {
                p.takeDamage(10);
                System.out.println("X " + x);
            }).start();

            System.out.println("loop " + i);
        }

        Thread.sleep(1000);

        System.out.println(p.getHealth());
    }
}
