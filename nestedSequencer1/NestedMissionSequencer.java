/** Simple Nested Sequencer
 *
 *
 *   @author Matt Luckcuck <ml881@york.ac.uk>
 */
package nestedSequencer1;

import javax.realtime.PriorityParameters;
import javax.safetycritical.Mission;
import javax.safetycritical.MissionSequencer;
import javax.safetycritical.StorageParameters;

public class NestedMissionSequencer extends MissionSequencer<Mission>
{

  private boolean returnedMission = false;

  public NestedMissionSequencer(PriorityParameters priority, StorageParameters storage)
  {
    super(priority, storage, null);
  }

  @Override
  protected Mission getNextMission()
  {
    if (returnedMission)
    {
      return null;
    }
    else
    {
      returnedMission = true;
      return new NestedMission();
    }
  }
}
