package ru.geekbrains.task_1;

public class ThreadABC
{
    private volatile String letter;

    public ThreadABC()
    {
        letter = "A";
    }

    public synchronized void doA()
    {
                try
                {
                    for(int i = 0; i < 5; i++)
                    {
                        while (!letter.equals("A"))
                        {
                            wait();
                        }
                        System.out.println("A");
                        letter = "B";
                        notifyAll();
                    }
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
    }

    public synchronized void doB()
    {
        try
        {
            for(int i = 0; i < 5; i++)
            {
                while (!letter.equals("B"))
                {
                    wait();
                }
                System.out.println("B");
                letter = "C";
                notifyAll();
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public synchronized void doC()
    {
        try
        {
            for(int i = 0; i < 5; i++)
            {
                while (!letter.equals("C"))
                {
                    wait();
                }
                System.out.println("C");
                letter = "A";
                notifyAll();
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }




}
