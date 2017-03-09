package producerConsumer;

import javax.realtime.PriorityParameters;
import javax.safetycritical.ManagedThread;
import javax.safetycritical.StorageParameters;

import devices.Console;

public class Producer extends ManagedThread
{
  private final PCMission pcMission;
  private final Buffer buffer;



  public Producer(PriorityParameters priority, StorageParameters storage,
      PCMission pcMission)
  {
    super(priority, storage, null);

    this.pcMission = pcMission;
    buffer = pcMission.getBuffer();

  }

  public void run()
  {
    //Console.println("Producer!");

    int i = 1;

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

      if ( i >= 5)
      {
        pcMission.requestTermination();
      }
    }
  }
}
