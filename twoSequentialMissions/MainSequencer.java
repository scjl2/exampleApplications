package sequentialMissions;

import javax.realtime.PriorityParameters;
import javax.safetycritical.Mission;
import javax.safetycritical.MissionSequencer;
import javax.safetycritical.StorageParameters;
import javax.safetycritical.annotate.Level;
import javax.safetycritical.annotate.SCJAllowed;

import devices.Console;

class MainSequencer extends MissionSequencer<Mission>
{
	private int releases = 0;
	
	public MainSequencer(PriorityParameters priority, StorageParameters storage,
			String name) throws IllegalStateException
	{
		super(priority, storage, name);
	}

	@Override
	@SCJAllowed(Level.SUPPORT)
	protected Mission getNextMission()
	{
//		Console.println(getName()+  " getNextMission");
		
		if (releases == 0)
		{
			Mission mission = new MissionA();
		
			releases ++;
			return mission;
		}
		else if(releases == 1 )
		{
			Mission mission = new MissionB();
			
			releases ++ ;
			return mission;
		}
		else
		{
			return null;
		}
	}
	
}
