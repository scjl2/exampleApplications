package producerConsumer;

import javax.realtime.PriorityParameters;
import javax.safetycritical.Mission;
import javax.safetycritical.MissionSequencer;
import javax.safetycritical.Safelet;
import javax.safetycritical.StorageParameters;
import javax.safetycritical.annotate.Level;
import javax.scj.util.Const;

import devices.Console;

public class PCSafelet implements Safelet<Mission>
{

	public Level getLevel()
	{
		return Level.LEVEL_2;
	}

	public MissionSequencer<Mission> getSequencer()
	{
		Console.println("PCSafelet");
		// Create and return the main mission sequencer
		StorageParameters storageParameters = new StorageParameters(
				Const.OVERALL_BACKING_STORE_DEFAULT - 2000000,
			
				Const.PRIVATE_MEM_DEFAULT, 10000 * 2, Const.MISSION_MEM_DEFAULT);

		return new PCMissionSequencer(new PriorityParameters(5),
				storageParameters);
	}

	@Override
	public long immortalMemorySize()
	{
		return Const.IMMORTAL_MEM_DEFAULT;
	}

	@Override
	public void initializeApplication()
	{
	}
}
