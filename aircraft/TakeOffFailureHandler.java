/** Aircraft - Mode Change Example
 *
 * 	When fired, the TakeOffFailureHandler reads the current aircraft speed and
 * 	either aborts the take off (if the current speed is below a given threshold)
 * 	or warns the pilots that the failure has occurred and that they should continue
 * 	the take off and then land (if the current speed is below a given threshold).
 *
 *   @author Matt Luckcuck <ml881@york.ac.uk>
 */
package aircraft;

import javax.realtime.AperiodicParameters;
import javax.realtime.PriorityParameters;
import javax.safetycritical.AperiodicEventHandler;
import javax.safetycritical.StorageParameters;

public class TakeOffFailureHandler extends AperiodicEventHandler
{
	/**
	 * The controlling mission
	 */
	private final MainMission mainMission;
	private final TakeOffMission takeoffMission;

	private double threshold;

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
	 * @param launchMission
	 *            the controlling mission
	 */
	public TakeOffFailureHandler(PriorityParameters priority,
			AperiodicParameters release, StorageParameters storage,
			String name, MainMission mainMission, TakeOffMission takeoffMission, Double threshold)
	{
		super(priority, release, storage, null);
		this.takeoffMission = takeoffMission;
		this.mainMission = mainMission;
		this.threshold = threshold;


	}

	/**
	 * Called when the handler is fired. Checks if the take off should be aborted
	 */
	@Override
	public void handleAsyncEvent()
	{

//REFACTORING

		//double currentSpeed = takeoffMission.getControllingMission().getAirSpeed();

   //MainMission mission = takeoffMission.getControllingMission();

	double currentSpeed = mainMission.getAirSpeed();

		// in both cases this failure should be flagged somewhere
		if (currentSpeed < threshold)
		{
			System.out.println("Failure: Aborting");
			takeoffMission.abort();
			takeoffMission.requestTermination();
		} else
		{
			System.out.println("Failure: Continue and Land");
		}
	}

}
