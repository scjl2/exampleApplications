package nestedSequencer3;

import javax.realtime.PriorityParameters;
import javax.safetycritical.ManagedThread;
import javax.safetycritical.StorageParameters;

import devices.Console;

class MT1 extends ManagedThread
{
	public MT1(PriorityParameters pri, StorageParameters storage)
	{
		super(pri, storage, null);
	}

	public void thread1Actions()
	{
	  Console.println("MT1 Release");
    Console.println("MT1 Performing Actions");
	}
	
	@Override
	public void run()
	{
	  thread1Actions();
	}
}