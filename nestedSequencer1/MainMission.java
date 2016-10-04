/** Simple Nested Sequencer
 *
 *
 *   @author Matt Luckcuck <ml881@york.ac.uk>
 */
package nestedSequencer1;

import javax.realtime.PriorityParameters;
import javax.safetycritical.Mission;

import devices.Console;

public class MainMission extends Mission
{
	@Override
	protected void initialize()
	{
		Console.println("Main Mission: Init ");

		NestedMissionSequencer sPModeChanger = new NestedMissionSequencer(
				new PriorityParameters(5),
				MySafelet.storageParameters_nestedSequencer);

		Console.println("Main Mission: Nested Sequencers Init");

		sPModeChanger.register();

		Console.println("Main Mission: Nested Sequencer register");

		Console.println("Main Mission: Begin ");
	}

	/**
	 * Returns the required size of this Mission's private memory
	 */
	@Override
	public long missionMemorySize()
	{
		return 10000;
	}

}
