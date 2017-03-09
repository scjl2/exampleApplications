/** Aircraft - Mode Change Example
 *
 * 	This class monitors the Aircraft's environment -- Oxygen levels, cabin pressure, fuel levels etc.
 *
 *   @author Matt Luckcuck <ml881@york.ac.uk>
 */
package aircraft;

import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.safetycritical.PeriodicEventHandler;
import javax.safetycritical.StorageParameters;

import devices.Console;

public class EnvironmentMonitor extends PeriodicEventHandler
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
	public EnvironmentMonitor(PriorityParameters priority,
			PeriodicParameters periodic,
			StorageParameters storage,
			String name,
			MainMission controllingMission)
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
	  //Console.println("Checking Environment");

		// read cabin pressure from sensors
		controllingMission.setCabinPressure(0);

		// read emergency Oxygen Levels
		controllingMission.setEmergencyOxygen(0);

		// read remaining fuel
		controllingMission.setFuelRemaining(0);

	}

}
