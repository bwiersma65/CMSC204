import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class CarQueue {

	private Queue<Integer> queue;
	private Random direction;
	
	public CarQueue()
	{
		queue = new ArrayDeque<Integer>();
		direction = new Random();
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
	}
	
	public void addToQueue()
	{
		class QueueRunnable implements Runnable
		{

			@Override
			public void run() {
				
				try 
				{
					while(true) {
						queue.add(direction.nextInt(4));
						Thread.sleep(200);
					}
				}
				catch (InterruptedException e)
				{
					
				}
				
			}
			
		}
		
		Runnable r = new QueueRunnable();
		Thread thr = new Thread(r);
		thr.start();
		
	}
	
	public Integer deleteQueue()
	{
		return queue.remove();
	}
}
