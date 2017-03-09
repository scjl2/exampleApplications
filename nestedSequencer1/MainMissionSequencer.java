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

public class MainMissionSequencer extends MissionSequencer<Mission>
{

  /**
   * Has this single mission been returned?
   */
  private boolean returnedMission;

  /**
   * Class Constructor
   *
   * @param pp
   *          the PriorityParameters for the sequencer
   * @param sp
   *          the StorageParameters for the sequencer
   */
  public MainMissionSequencer(PriorityParameters pp, StorageParameters sp)
  {
    super(pp, sp, null);
    returnedMission = false;
  }

  /**
   * Returns the new mission
   */
  @Override
  protected Mission getNextMission()
  {
    // This returns the main mission once only
    if (returnedMission)
    {
      return null;
    }
    else
    {
      returnedMission = true;
      return new MainMission();
    }
  }
}
