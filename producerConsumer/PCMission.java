package producerConsumer;

import javax.realtime.PriorityParameters;
import javax.safetycritical.Mission;
import javax.safetycritical.Services;
import javax.safetycritical.StorageParameters;
import javax.scj.util.Const;

import devices.Console;

public class PCMission extends Mission
{
	private final Buffer buffer;

	public PCMission()
	{
		Console.println("PCMission");
		Services.setCeiling(this, 20);
		buffer = new Buffer();
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

	public Buffer getBuffer()
	{
		return buffer;
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
