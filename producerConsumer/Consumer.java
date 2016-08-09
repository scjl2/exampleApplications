package producerConsumer;

import javax.realtime.PriorityParameters;
import javax.safetycritical.ManagedThread;
import javax.safetycritical.StorageParameters;

import devices.Console;

public class Consumer extends ManagedThread
{
  private final PCMission pcMission;
  private final Buffer buffer;

  public Consumer(PriorityParameters priority, StorageParameters storage,
      PCMission pcMission)
  {
    super(priority, storage, null);

    this.pcMission = pcMission;
    buffer = pcMission.getBuffer();
  }

  public void run()
  {
    Console.println("Consumer!");

    while (!pcMission.terminationPending())
    {
      int result = 999;
      try
      {
        result = buffer.read();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      Console.println("Consumer Read " + result + " from Buffer");

    }
  }
}
