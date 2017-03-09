package mission1;

import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.safetycritical.AperiodicEventHandler;
import javax.safetycritical.PeriodicEventHandler;
import javax.safetycritical.StorageParameters;

class PEH extends PeriodicEventHandler
{
	private AperiodicEventHandler apeh;

	public PEH(PriorityParameters priority, PeriodicParameters release,
			StorageParameters storage, String name, AperiodicEventHandler apeh)
	{
		super(priority, release, storage, null);
		this.apeh=apeh;
	}

	@Override
	public void handleAsyncEvent()
	{
		apeh.release();
	}
}
