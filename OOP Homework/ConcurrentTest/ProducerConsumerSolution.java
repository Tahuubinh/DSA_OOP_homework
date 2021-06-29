package ConcurrentTest;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerSolution {
	// Initiate some constances
	final static int iter_count = 5;
	final static int buffer_size = 3;
	private final int BUFFER_SIZE = 2;
	private final Semaphore mutex = new Semaphore(1);
	private final Semaphore items = new Semaphore(0);
	private final Semaphore spaces = new Semaphore(0);
	static long millis1; // main thread sets
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	
	//shared buffer and locks
	public static Queue<String> buffer;
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
			
				for(int i = 0; i < iter_count; i++)
				{
					String name = "P[" + id + "." + i + "]";
					System.out.println(name + "-> start");
					
					//acquire the buffer lock
					synchronized(mutex1)
					{
						//if the buffer is full, wait.
						while(buffer.size() >= buffer_size)
							mutex1.wait();
						
						long t = (System.currentTimeMillis() - millis1);
						System.out.println(name + "-> producing @ t=" + t);
						
						//produce - a string that is the producer id and the time
						String newString = name + " : " + t;
						buffer.add(newString);
						
						//notify the consumer that there is an element in the buffer
						mutex1.notify();
						
						Thread.sleep(rand.nextInt(100) + 10);
					}
					
					Thread.sleep(rand.nextInt(100) + 10);
				}
				
				
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
				
				for(int i = 0; i < iter_count; i++)
				{
					String name = "C[" + id + "." + i + "]";
					
					System.out.println(name + "-> start");
					
					//acquire the buffer lock
					synchronized(mutex1)
					{
						//if the buffer is empty, wait
						while(buffer.size() <= 0)
							mutex1.wait();
									
						long t = System.currentTimeMillis() - millis1;
						
						//consume - print out the consumed string
						System.out.println(name + "-> consuming: " + buffer.remove());
						
						//notify producer that there is room in the buffer
						mutex1.notify();
						
						Thread.sleep(rand.nextInt(100) + 10);
					}
					
					Thread.sleep(rand.nextInt(100) + 10);
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) 
	{
		final int NUM_PRODUCERS = 3;
		final int NUM_CONSUMERS = 3;
		
		//start the timer (usecs)
		millis1 = System.currentTimeMillis();
		
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
		
		long elapsedTime = (millis2 - millis1);
		System.out.println("Simulation has finished. Runtime: " + elapsedTime + "ms");
	}
}