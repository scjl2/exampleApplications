/** Aircraft - Mode Change Example
 *
 *   This mission deals with the aircraft's take off phase
 *
 *   @author Matt Luckcuck <ml881@york.ac.uk>
 */
package aircraft;

import javax.realtime.AperiodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.RelativeTime;
import javax.safetycritical.PriorityScheduler;
import javax.safetycritical.StorageParameters;
import javax.scj.util.Const;
import javax.realtime.PeriodicParameters;
import javax.safetycritical.Mission;

public class TakeOffMission extends Mission //implements LandingGearUser
{
	final double SAFE_AIRSPEED_THRESHOLD = 10.00;
	final double TAKEOFF_ALTITUDE = 10.00;



	private MainMission controllingMission;

	private boolean abort = false;

	//int maxP = 5;//PriorityScheduler.instance().getMaxPriority();
	//Limitation: only literals as params for params
 
	/**
	 * Is the landing gear deployed?
	 */
	private boolean landingGearDeployed;

	public TakeOffMission(MainMission controllingMission)
	{
		this.controllingMission = controllingMission;
	}

	/**
	 * initialises the mission
	 */
	@Override
	protected void initialize()
	{


		StorageParameters storageParametersSchedulable = new StorageParameters(
				Const.PRIVATE_MEM_DEFAULT - 30 * 1000,
				Const.PRIVATE_MEM_DEFAULT - 30 * 1000,
				Const.IMMORTAL_MEM_DEFAULT - 50 * 1000,
				Const.MISSION_MEM_DEFAULT - 100 * 1000);

		// Load the schedulables for this mission

		LandingGearHandlerTakeOff landingGearHandler = new LandingGearHandlerTakeOff(
				new PriorityParameters(5), new AperiodicParameters(),
				storageParametersSchedulable, "Landing Gear Handler", this);

		landingGearHandler.register();



		TakeOffMonitor takeOffMonitor = new TakeOffMonitor(
				new PriorityParameters(5), new PeriodicParameters(
						new RelativeTime(0, 0), new RelativeTime(500, 0)),
				storageParametersSchedulable, controllingMission, this, TAKEOFF_ALTITUDE,
				landingGearHandler);

		takeOffMonitor.register();

		TakeOffFailureHandler takeOffFailureHandler = new TakeOffFailureHandler(
				new PriorityParameters(5), new AperiodicParameters(),
				storageParametersSchedulable, "Take Off Handler", controllingMission, this,
				SAFE_AIRSPEED_THRESHOLD);

		takeOffFailureHandler.register();

	}

	/**
	 * Returns the size of the mission's memory
	 */
	@Override
	public long missionMemorySize()
	{
		return Const.MISSION_MEM_DEFAULT;
	}

	public void abort()
	{
		abort = true;
	}

	public MainMission getControllingMission()
	{
		return controllingMission;
	}

	public void setControllingMission(MainMission controllingMission)
	{
		this.controllingMission = controllingMission;
	}


	public synchronized void deployLandingGear()
	{
		landingGearDeployed = true;
	}

	@Override
	public boolean cleanUp()
	{
		System.out.println("Take Off Mission Cleanup, Returning " + abort);
		return !abort;
	}


	public void stowLandingGear()
	{
		landingGearDeployed = false;
	}


	public boolean isLandingGearDeployed()
	{
		return landingGearDeployed;
	}
}
