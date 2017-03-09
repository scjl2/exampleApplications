/** Aircraft - Mode Change Example
 *
 * 	This is the mode changer for the Aircraft application,
 * 	it controls which mode the application is in
 *
 *   @author Matt Luckcuck <ml881@york.ac.uk>
 */
package aircraft;

import javax.realtime.PriorityParameters;
import javax.safetycritical.MissionSequencer;
import javax.safetycritical.StorageParameters;
import javax.safetycritical.Mission;

import devices.Console;

public class ACModeChanger2 extends MissionSequencer<Mission>
{
	private MainMission controllingMission;

	public ACModeChanger2(PriorityParameters priority,
			StorageParameters storage, MainMission controllingMission)
	{
		super(priority, storage, null);
		this.controllingMission = controllingMission;
	}

	/**
	 * This variable represents the number of modes this ModeChanger has to deal
	 * with
	 */
	private int modesLeft = 3;

	/**
	 * Class constructor
	 *
	 * @param priority
	 *            the priority parameters for this mission sequencer
	 * @param storage
	 *            the storage parameters for this mission sequencer
	 */
	public ACModeChanger2(PriorityParameters priority, StorageParameters storage)
	{
		super(priority, storage, null);
	
	}

	@Override
	protected Mission getNextMission()
	{
		if (modesLeft == 3)
		{
			modesLeft--;

			return new TakeOffMission(controllingMission);
		} else if (modesLeft == 2)
		{
			modesLeft--;
			return new CruiseMission(controllingMission);
		} else if (modesLeft == 1)
		{
			modesLeft--;
			return new LandMission(controllingMission);
		} else
		{
			return null;
		}

	}

}
