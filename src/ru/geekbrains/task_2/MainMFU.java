package ru.geekbrains.task_2;

public class MainMFU
{
    public static void main(String[] args)
    {
        // write your code here
        MFU mfu = new MFU();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.doAll1();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.doAll2();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.doAll1();
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.doAll2();
            }
        });
        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.doAll1();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try
        {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }


    }
}
