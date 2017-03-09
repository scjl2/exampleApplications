/** Simple Nested Sequencer
 *
 *
 *   @author Matt Luckcuck <ml881@york.ac.uk>
 */
package nestedSequencer1;

import javax.realtime.PriorityParameters;
import javax.safetycritical.Mission;
import javax.safetycritical.MissionSequencer;
import javax.safetycritical.Safelet;
import javax.safetycritical.StorageParameters;
import javax.scj.util.Const;

public class MySafelet implements Safelet<Mission>
{

  // public static StorageParameters storageParametersSchedulable;
  public static StorageParameters storageParameters_topLevelSequencer;
  public static StorageParameters storageParameters_nestedSequencer;
  public static StorageParameters storageParameters_Schedulable;

  @Override
  public MissionSequencer<Mission> getSequencer()
  {
    storageParameters_topLevelSequencer = new StorageParameters(
        Const.OVERALL_BACKING_STORE_DEFAULT - 1000000, Const.PRIVATE_MEM_DEFAULT,
        10000 * 2, Const.MISSION_MEM_DEFAULT);

    return new MainMissionSequencer(new PriorityParameters(5),
        storageParameters_topLevelSequencer);
  }

  @Override
  public long immortalMemorySize()
  {
    return 100000;
  }

  @Override
  public void initializeApplication()
  {
    storageParameters_nestedSequencer = new StorageParameters(1000000, 100000, 10000, 0);

    storageParameters_Schedulable = new StorageParameters(1000000, 10000, 10000, 0);
  }
}
