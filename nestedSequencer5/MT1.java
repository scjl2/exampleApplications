package nestedSequencer5;

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

 

  @Override
  public void run()
  {
    Console.println("MT1 Release");
  }

}