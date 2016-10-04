package producerConsumer;

import javax.realtime.PriorityParameters;
import javax.safetycritical.Mission;
import javax.safetycritical.Services;
import javax.safetycritical.StorageParameters;
import javax.scj.util.Const;

import devices.Console;

public class PCMission extends Mission
{
//	private final Buffer buffer;
  private volatile int buffer;

	public PCMission()
	{
		Console.println("PCMission");
		Services.setCeiling(this, 20);
//		buffer = new Buffer();
		 buffer = 0;
	}

	protected void initialize()
	{
		StorageParameters storageParameters = new StorageParameters(150 * 1000,
				
				Const.PRIVATE_MEM_DEFAULT, Const.IMMORTAL_MEM_DEFAULT,
				Const.MISSION_MEM_DEFAULT - 100 * 1000);

		new Producer(new PriorityParameters(10), storageParameters, this).register();

		new Consumer(new PriorityParameters(10), storageParameters, this).register();

		

		Console.println("FlatBufferMission init");
	}

//	public Buffer getBuffer()
//	{
//		return buffer;
//	}
	

  public boolean bufferEmpty(String name)
  {
    Console.println(name + " Checking Buffer Empty");
    return buffer == 0;
  }

  public synchronized void write(int update) throws InterruptedException
  {
    boolean bufferEmpty = bufferEmpty("Producer");
    while (!bufferEmpty)
    {
      Console.println("Producer Waiting on Buffer");

      this.wait();

      bufferEmpty = bufferEmpty("Producer");
    }

    Console.println("Producer writing" + update + " to Buffer");
    buffer = update;
    this.notify();
  }

  public synchronized int read() throws InterruptedException
  {
    boolean bufferEmpty = bufferEmpty("Consumer");
    while (bufferEmpty)
      Console.println("Consumer" + " Waiting on Buffer");
    {
      this.wait();

      bufferEmpty = bufferEmpty("Consumer");
    }

    int out = buffer;
    Console.println("Consumer reading " + out + " from Buffer");
    buffer = 0;
    this.notify();

    return out;
  }

	public boolean cleanUp()
	{
		Console.print("PCMission Cleanup");
		return false;
	}

	public long missionMemorySize()
	{
		return 1048576;
	}
}
