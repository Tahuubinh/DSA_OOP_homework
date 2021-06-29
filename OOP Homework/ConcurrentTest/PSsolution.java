package ConcurrentTest;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

import com.sun.tools.javac.jvm.Items;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class PSsolution {
	// Initiate some constances
	private final static int BUFFER_SIZE = 10;
	final static Semaphore mutex = new Semaphore(1);
	final static Semaphore items = new Semaphore(0);
	final static Semaphore spaces = new Semaphore(BUFFER_SIZE);
	static long start; // main thread sets
	private final static CountDownLatch latch = new CountDownLatch(20*2 + 1);
	
	//shared buffer and locks
	public static Queue<String> buffer = new ArrayDeque<String>(BUFFER_SIZE);;
	public static Object mutex1 = new Object();
	
	///Producer thread
	private static class Producer extends Thread {
		private Thread thread;
		private int id;
		
		Producer(int id)
		{
			this.id = id;
			
			thread = new Thread(this, "Producer[" + id + "]");
		}
		
		public void run()
		{
			try {
				Random rand = new Random();
				
				// Make the random appearance
				Thread.sleep(rand.nextInt(100) + 10);
				// acquireUninterruptibly plays a role as wait
				spaces.acquireUninterruptibly();
				rand = new Random();
				Thread.sleep(rand.nextInt(100) + 10);
				
				mutex.acquireUninterruptibly();
				long t = (System.currentTimeMillis() - start);
				System.out.println("Producer[" + id + "]" + "-> producing @ t=" + t);
				String evenString = "product" + id;
				buffer.add(evenString);
				System.out.println("\t" + evenString + " has been added!");
				// release plays a role as signal
				mutex.release();
				
				rand = new Random();
				Thread.sleep(rand.nextInt(100) + 10);
				items.release();
				
				rand = new Random();
				Thread.sleep(rand.nextInt(100) + 10);
				latch.countDown();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	///Consumer thread
	private static class Consumer extends Thread
	{
		private Thread thread;
		private int id;
		
		Consumer(int id)
		{
			this.id = id;
			thread = new Thread(this, "Consumer[" + id + "]");
		}
		
		public void run()
		{
			
			try {
				Random rand = new Random();
				// Make the random appearance
				Thread.sleep(rand.nextInt(100) + 10);
				items.acquireUninterruptibly();
				rand = new Random();
				Thread.sleep(rand.nextInt(100) + 10);
				
				mutex.acquireUninterruptibly();
				long t = (System.currentTimeMillis() - start);
				System.out.println("Consumer[" + id + "]" + "-> producing @ t=" + t);
				buffer.remove();
				System.out.println("\tFIFO: One product has been removed!");
				mutex.release();
				
				rand = new Random();
				Thread.sleep(rand.nextInt(100) + 10);
				spaces.release();
				rand = new Random();
				Thread.sleep(rand.nextInt(100) + 10);
				latch.countDown();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) 
	{
		final int NUM_PRODUCERS = 20;
		final int NUM_CONSUMERS = 15;
		
		//start the timer (usecs)
		start = System.currentTimeMillis();
		
		// Consume this is the physical buffer
		buffer = new LinkedList<>();
		Producer[] producers = new Producer[NUM_PRODUCERS];
		Consumer[] consumers = new Consumer[NUM_CONSUMERS];
		
		//start the producers
		for(int i = 0; i < NUM_PRODUCERS; i++)
		{
			producers[i] = new Producer(i+1); 
			producers[i].start();
		}
		
		//start the consumers
		for(int i = 0; i < NUM_CONSUMERS; i++)
		{
			consumers[i] = new Consumer(i+1);
			consumers[i].start();
		}

		
		//wait for producers to finish
		for(int i = 0; i < NUM_PRODUCERS; i++)
		{
			try {
				producers[i].join(); 
			}
			catch (InterruptedException e) {
				e.printStackTrace(); 
			}
		}
		
		//wait for consumers to finish
		for(int i = 0; i < NUM_CONSUMERS; i++)
		{
			try { 
				consumers[i].join(); 
			}
			catch (InterruptedException e) {
				e.printStackTrace(); 
			}
		}
		
		// Gauge the time. Just for fun!
		long millis2 = System.currentTimeMillis();
		
		long elapsedTime = (millis2 - start);
		System.out.println("Simulation has finished. Runtime: " + elapsedTime + "ms");
	}
}
