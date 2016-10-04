package producerConsumer;

import javax.realtime.PriorityParameters;
import javax.safetycritical.ManagedThread;
import javax.safetycritical.StorageParameters;

import devices.Console;

public class Producer extends ManagedThread
{
  private final PCMission pcMission, buffer;
//  private final Buffer buffer;
  
  private int i = 1;

  public Producer(PriorityParameters priority, StorageParameters storage,
      PCMission pcMission)
  {
    super(priority, storage, null);

    this.pcMission = pcMission;
//    buffer = pcMission.getBuffer();
    this.buffer=pcMission;
  }

  public void run()
  {
    Console.println("Producer!");

    while (!pcMission.terminationPending())
    {
      try
      {
        buffer.write(i);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }

      i++;

      boolean keepWriting = i >= 5;
      if (keepWriting)
      {
        pcMission.requestTermination();
      }
    }
  }
}
