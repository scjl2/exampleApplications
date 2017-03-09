package mission1;

import javax.realtime.AperiodicParameters;
import javax.realtime.PriorityParameters;
import javax.safetycritical.AperiodicEventHandler;
import javax.safetycritical.Mission;
import javax.safetycritical.StorageParameters;

class APEH extends AperiodicEventHandler
{
	private Mission controllingMission;

	public APEH(PriorityParameters priority, AperiodicParameters release,
			StorageParameters storage, String name, Mission controllingMission)
	{
		super(priority, release, storage, null);
		this.controllingMission = controllingMission;
	}

	@Override
	public void handleAsyncEvent()
	{
		controllingMission.requestTermination();
	}

}
