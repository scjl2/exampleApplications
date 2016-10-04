package nestedSequencer2;

import javax.realtime.PriorityParameters;
import javax.safetycritical.Mission;
import javax.safetycritical.MissionSequencer;
import javax.safetycritical.StorageParameters;

public class ThirdMissionSequencer extends MissionSequencer<Mission>
{
  private boolean done = false;

  public ThirdMissionSequencer(PriorityParameters priority, StorageParameters storage)
  {
    super(priority, storage, null);

  }

  @Override
  protected Mission getNextMission()
  {

    if (done == false)
    {
      done = true;
      return new MyMission3();
    }
    else
    {
      return null;
    }
  }
}
