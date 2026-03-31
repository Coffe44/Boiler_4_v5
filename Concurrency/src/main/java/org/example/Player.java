package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class Player
{
    private String name;
//    private int health = 100;
private AtomicInteger health = new AtomicInteger(100);


    public Player(String name)
    {
        this.name = name;
    }

//    public synchronized void takeDamage(int damage)
//    {
//        int currentHealth = health;
//
//        try { Thread.sleep(1); } catch (Exception _){}
//
//        health = currentHealth - damage;
//    }

    public void takeDamage(int damage)
    {
        health.addAndGet(-damage);
    }

    public  String getName()
    {
        return name;
    }
    public int getHealth()
    {
        return health.get();
    }
}
