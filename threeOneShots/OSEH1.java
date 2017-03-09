package threeOneShots;

import javax.realtime.AperiodicParameters;
import javax.realtime.HighResolutionTime;
import javax.realtime.PriorityParameters;
import javax.safetycritical.Mission;
import javax.safetycritical.OneShotEventHandler;
import javax.safetycritical.StorageParameters;

class OSEH1 extends OneShotEventHandler
{
	Mission controllingMission;

	public OSEH1(PriorityParameters pri, HighResolutionTime start,
			AperiodicParameters aParams, StorageParameters storage, Mission controllingMission)
	{
		super(pri, start, aParams, storage, null);

		this.controllingMission = controllingMission;
	}

	@Override
	public void handleAsyncEvent()
	{
		controllingMission.requestTermination();
	}
}
