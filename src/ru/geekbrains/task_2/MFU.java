package ru.geekbrains.task_2;

public class MFU
{
    private volatile boolean printer;
    private volatile boolean scanner;
    private volatile boolean xerox;

    private Object printerObj = new Object();
    private Object scannerObj = new Object();
    private Object xeroxObj = new Object();

    public MFU()
    {
        printer = false;
        scanner = false;
        xerox = false;
    }

    public void doAll1()
    {
        doPrinter();
        doScanner();
        doXerox();
    }
    public void doAll2()
    {
        doXerox();
        doScanner();
        doPrinter();
    }


    public synchronized void doPrinter()
    {
        System.out.println("Сотрудник " + (Thread.currentThread().getId() - 11) + " подошёл к принтеру.");
        if(!printer && !xerox)
        {
            helpPrinterUs();
        }
        else
        {
            System.out.println("Сотрудник " + (Thread.currentThread().getId() - 11) + " встал в очередь к принтеру.");
            while (printer || xerox) {}
                helpPrinter();
            }
    }

    public void doScanner()
    {
        System.out.println("Сотрудник " + (Thread.currentThread().getId() - 11) + " подошёл к сканнеру.");
        if(!scanner && !xerox)
        {
            helpScannerUs();
        }
        else
        {
            System.out.println("Сотрудник " + (Thread.currentThread().getId() - 11) + " встал в очередь к сканнеру.");
            while (scanner || xerox){}
            helpScanner();
        }
    }
    public synchronized void doXerox()
    {
        System.out.println("Сотрудник " + (Thread.currentThread().getId() - 11) + " подошёл к ксероксу.");
        while (scanner || xerox || printer) {}
        helpXerox();
    }

    public synchronized void helpPrinter()
    {
        try
        {
            printer = true;
            System.out.println("Сотрудник " + (Thread.currentThread().getId() - 11) + " начал работу с принтером.");
            Thread.sleep(2000);
            System.out.println("Сотрудник " + (Thread.currentThread().getId() - 11) + " закончил работу с принтером.");
            printer = false;
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public synchronized void helpScanner()
    {
        try
        {
            scanner = true;
            System.out.println("Сотрудник " + (Thread.currentThread().getId() - 11) + " начал работу со сканнером.");
            Thread.sleep(2000);
            System.out.println("Сотрудник " + (Thread.currentThread().getId() - 11) + " закончил работу со сканнером.");
            scanner = false;
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public synchronized void helpXerox()
    {
        try
        {
            xerox = true;
            System.out.println("Сотрудник " + (Thread.currentThread().getId() - 11) + " начал работу с ксероксом.");
            Thread.sleep(2000);
            System.out.println("Сотрудник " + (Thread.currentThread().getId() - 11) + " закончил работу с ксероксом.");
            xerox = false;
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private void helpPrinterUs()
    {
        try
        {
            printer = true;
            System.out.println("Сотрудник " + (Thread.currentThread().getId() - 11) + " начал работу с принтером.");
            Thread.sleep(2000);
            System.out.println("Сотрудник " + (Thread.currentThread().getId() - 11) + " закончил работу с принтером.");
            printer = false;
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private void helpScannerUs()
    {
        try
        {
            scanner = true;
            System.out.println("Сотрудник " + (Thread.currentThread().getId() - 11) + " начал работу со сканнером.");
            Thread.sleep(2000);
            System.out.println("Сотрудник " + (Thread.currentThread().getId() - 11) + " закончил работу со сканнером.");
            scanner = false;
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
