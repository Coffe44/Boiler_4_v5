package org.example;

public class Player
{
    private String name;
    private int health = 100;

    public Player(String name)
    {
        this.name = name;
    }

    public void  takeDamage(int damage)
    {
        health -= damage;
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
