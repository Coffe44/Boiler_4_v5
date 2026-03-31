package org.example;

public class Main {
    static void main()
    {
        Player p = new Player("Boss");

        for (int i = 0; i < 10; i++)
        {
            p.takeDamage(10);
        }

        System.out.println(p.getHealth());
    }
}
