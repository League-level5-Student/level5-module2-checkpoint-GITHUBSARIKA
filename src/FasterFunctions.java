
public class FasterFunctions implements Runnable {
	public static void main(String[] args) {
		float totalTime = 0;
		long startTime = System.currentTimeMillis();
		Thread threadOne=new Thread(()-> {
			SlowFunctions.slowSortLargeArray();
		});
		Thread threadTwo=new Thread(()-> {
			SlowFunctions.ackermann(3, 10);
		});
		Thread threadThree=new Thread(()-> {
			SlowFunctions.millionsOfSqrts();
		});
		System.out.println("Threads are starting...");
		threadOne.start();
		threadTwo.start();
		threadThree.start();
		try {
			threadOne.join();
			threadTwo.join();
			threadThree.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//1. Go to Run > Run Configurations
		// *      2. Click on the tab that reads "(x)= Arguments"
		 //*      3. In the box labeled "VM arguments:", add this: -Xss64m 
		
		
		float endTime = (float)((double)System.currentTimeMillis() - (double)startTime) / 1000.0f;
		totalTime += endTime;
		System.out.println("Total Time: " + totalTime);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
