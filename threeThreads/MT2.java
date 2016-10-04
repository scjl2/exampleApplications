package threeThreads;

import javax.realtime.PriorityParameters;
import javax.safetycritical.ManagedThread;
import javax.safetycritical.StorageParameters;

import devices.Console;

class MT2 extends ManagedThread
{
	
	public MT2(PriorityParameters pri, StorageParameters storage)
	{
		super(pri, storage, null);
		
	}
	
	 private void thread2Action()
	  {
	    Console.println("MT2 Release");
	  }

	  @Override
	  public void run()
	  {
	    thread2Action();
	  }	
}
