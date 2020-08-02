package ru.geekbrains.task_1;

public class Main {

    public static void main(String[] args)
    {
	// write your code here

        ThreadABC threadABC = new ThreadABC();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadABC.doA();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadABC.doB();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadABC.doC();
            }
        }).start();

    }
}
