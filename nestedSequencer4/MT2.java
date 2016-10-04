package nestedSequencer4;

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

  public void thread2Action()
  {
    Console.println("MT2 Release");
  }

  @Override
  public void run()
  {
    thread2Action();
  }

}
