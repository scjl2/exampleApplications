package threeThreads;

import javax.realtime.PriorityParameters;
import javax.safetycritical.ManagedThread;
import javax.safetycritical.StorageParameters;

import devices.Console;

class MT3 extends ManagedThread
{
	
	public MT3(PriorityParameters pri, StorageParameters storage)
	{
		super(pri, storage, null);
		
	}


	  @Override
	  public void run()
	  {
	    Console.println("MT3 Release");
	  }	
}
