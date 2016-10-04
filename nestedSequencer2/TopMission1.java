package nestedSequencer2;

import javax.realtime.PriorityParameters;
import javax.safetycritical.Mission;

public class TopMission1 extends Mission 
{

	@Override
	protected void initialize() 
	{
		devices.Console.println("TopMission1" + ":init");
		
		FirstMissionSequencer FirstSeq = new FirstMissionSequencer(new PriorityParameters(5), SafeletLauncher.storageParameters);
		FirstSeq.register();

		SecondMissionSequencer SecondSeq = new SecondMissionSequencer(new PriorityParameters(15), SafeletLauncher.storageParameters);
		SecondSeq.register();

		ThirdMissionSequencer ThirdSeq = new ThirdMissionSequencer(new PriorityParameters(10), SafeletLauncher.storageParameters);
		ThirdSeq.register();
	}

	@Override
	public long missionMemorySize() 
	{
		return 60000;
	}

}
