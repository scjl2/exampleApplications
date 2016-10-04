package threeThreads;

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

  private void thread1Action()
  {
    Console.println("MT1 Release");
  }

  @Override
  public void run()
  {
    thread1Action();
  }
}