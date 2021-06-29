package ConcurrentTest;
import java.io.FileNotFoundException;

public class RunnableDemoT {
	private class RunnableImpl implements Runnable {
	  
    public void run()
    {
        System.out.println(Thread.currentThread().getName()
                         + ", executing run() method!");
        /**
         * Checked exception can't be thrown, Runnable must
         * handle checked exception itself.
         */
        try {
            throw new FileNotFoundException();
        }
        catch (FileNotFoundException e) {
            System.out.println("Must catch here!");
            e.printStackTrace();
        }

        int r = 1 / 0;
        /*
         * Below commented line is an example
         * of thrown RuntimeException.
         */
        // throw new NullPointerException();
    }
}
	  
    public static void main(String[] args)
    {
        System.out.println("Main thread is- " +
                          Thread.currentThread().getName());
        Thread t1 = new Thread(new RunnableDemoT().new RunnableImpl());
        t1.start();
    }
  
    
}
