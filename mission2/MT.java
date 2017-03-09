package mission2;

import javax.realtime.PriorityParameters;
import javax.safetycritical.ManagedThread;
import javax.safetycritical.StorageParameters;

class MT extends ManagedThread
{
	private MissionA controllingMission;

	public MT(PriorityParameters pri, StorageParameters storage, MissionA controllingMission)
	{
		super(pri, storage, null);
		this.controllingMission = controllingMission;
	}

	@Override
	public void run()
	{
		controllingMission.systemAction();
	}
}
