/** Simple Nested Sequencer
 *
 *
 *   @author Matt Luckcuck <ml881@york.ac.uk>
 */
package nestedSequencer1;

import javax.realtime.PriorityParameters;
import javax.safetycritical.Mission;

public class MainMission extends Mission
{
  @Override
  protected void initialize()
  {
    NestedMissionSequencer sPModeChanger = new NestedMissionSequencer(
        new PriorityParameters(5), MySafelet.storageParameters_nestedSequencer);
    sPModeChanger.register();
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
