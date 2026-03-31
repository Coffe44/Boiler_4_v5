package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    static void main() throws InterruptedException
    {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> results = executor.submit(() ->
        {
            try
            {
                Thread.sleep(2000); // set to < 1000 to not get timeout
            }
            catch (Exception e){}
            return 42;
        });

        try
        {
            System.out.println("Waiting for results...");
            Integer value = results.get(1,TimeUnit.SECONDS);
            System.out.println("Result: " + value);
        }
        catch ( TimeoutException e)
        {
            System.out.println("Timeout");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
