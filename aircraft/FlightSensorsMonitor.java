/** Aircraft - Mode Change Example
 *
 * 	This class monitors the Aircraft's flight sensors --altitude, air speed, etc.
 *
 *   @author Matt Luckcuck <ml881@york.ac.uk>
 */
package aircraft;

import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.safetycritical.PeriodicEventHandler;
import javax.safetycritical.StorageParameters;

import devices.Console;

public class FlightSensorsMonitor extends PeriodicEventHandler
{
	MainMission controllingMission;

	/**
	 * Class Constructor
	 *
	 * @param priority
	 *            priority parameters
	 * @param periodic
	 *            periodic parameters
	 * @param storage
	 *            storage parameters
	 * @param size
	 *            private memory size
	 */
	public FlightSensorsMonitor(PriorityParameters priority,
			PeriodicParameters periodic, StorageParameters storage,
			String name, MainMission controllingMission)
	{
		super(priority, periodic, storage, null);
		this.controllingMission = controllingMission;
	}

	/**
	 * Called when the handler is fired
	 */
	@Override
	public void handleAsyncEvent()
	{
	  //Console.println("Checking Flight Sensors");

		// read air speed
		controllingMission.setAirSpeed(0);
		// read altitude
		controllingMission.setAltitude(0);
		// read heading
		controllingMission.setHeading(0);
	}

}
