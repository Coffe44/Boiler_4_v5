package org.example;

public class Player
{
    private String name;
    private int health = 100;

    public Player(String name)
    {
        this.name = name;
    }

    public synchronized void takeDamage(int damage)
    {
        int currentHealth = health;

        try { Thread.sleep(1); } catch (Exception _){}

        health = currentHealth - damage;
    }

    public  String getName()
    {
        return name;
    }
    public int getHealth()
    {
        return health;
    }
}
