
public class FasterFunctions implements Runnable {
	public static void main(String[] args) {
		float totalTime = 0;
		long startTime = System.currentTimeMillis();
		Thread threadOne=new Thread(()-> {
			SlowFunctions.slowSortLargeArray();
		});
		Thread threadTwo=new Thread(()-> {
			SlowFunctions.ackermann(3, 14);
		});
		Thread threadThree=new Thread(()-> {
			SlowFunctions.millionsOfSqrts();
		});
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
		
		
		
		
		float endTime = (float)((double)System.currentTimeMillis() - (double)startTime) / 1000.0f;
		totalTime += endTime;
		System.out.println("Total Time: " + totalTime);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
