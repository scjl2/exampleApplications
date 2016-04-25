package producerConsumer;

import javax.realtime.PriorityParameters;
import javax.safetycritical.Mission;
import javax.safetycritical.MissionSequencer;
import javax.safetycritical.StorageParameters;

import devices.Console;

public class PCMissionSequencer extends MissionSequencer<Mission>
{
	private boolean returnedMission;

	public PCMissionSequencer(PriorityParameters priorityParameters,
			StorageParameters storageParameters)
	{
		super(priorityParameters, storageParameters, null);
		returnedMission = false;
	}

	protected Mission getNextMission()
	{
		Console.println("PCMissionSequencer");

		// As this sequencer only delivers one mission,
		// if it has not been returned yet then return it,
		// else return null which will terminate the sequencer

		if (!returnedMission)
		{
			Console.println("PCMissionSequencer returns mission");
			returnedMission = true;
			return new PCMission();
		}
		else
		{
			return null;
		}
	}

}
