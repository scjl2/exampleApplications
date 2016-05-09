/** Aircraft - Mode Change Example
 *
 *  Monitors the Aircraft's distance from the ground
 *
 *   @author Matt Luckcuck <ml881@york.ac.uk>
 */
package aircraft;

import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.safetycritical.PeriodicEventHandler;
import javax.safetycritical.StorageParameters;

//Handler for monitoring the conditions which must be true for the craft to start landing
public class GroundDistanceMonitor extends PeriodicEventHandler
{
	/**
	 * The controlling mission of this handler
	 */
	private final MainMission mainMission;

	private final double readingOnGround;

	/**
	 * Class Constructor
	 *
	 * @param priorityParameters
	 *            the priority parameters for this handler
	 * @param periodicParameters
	 *            the periodic parameters for this handler
	 * @param storageConfigurationParameters
	 *            the storage parameters for this handler
	 * @param size
	 *            the size of the private memory for this handler
	 * @param landMission
	 *            the controlling mission of this mission
	 */
	public GroundDistanceMonitor(PriorityParameters priority,
			PeriodicParameters periodic, StorageParameters storage,
			MainMission mainMission)
	{
		super(priority, periodic, storage, null);

		this.mainMission = mainMission;
		this.readingOnGround = mainMission.ALTITUDE_READING_ON_GROUND;
	}

	/**
	 * Called when the handler is fired
	 */
	@Override
	public void handleAsyncEvent()
	{
		System.out.println("Checking Ground Distance");
		// read this value from sensors
		double distance = mainMission.getAltitude();

		if (distance == readingOnGround)
		{
			System.out.println("Aircraft Landed, Terminating Mission");
			mainMission.requestTermination();
		}
	}

}
