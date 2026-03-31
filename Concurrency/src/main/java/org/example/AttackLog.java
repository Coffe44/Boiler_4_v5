package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AttackLog
{
    private final List<String> attacks = Collections.synchronizedList(new ArrayList<>());

    public void log(String message)
    {
        try { Thread.sleep(1); } catch (Exception e){}

        attacks.add(message);
    }

    public List<String> getAttacks()
    {
        return attacks;
    }
}
