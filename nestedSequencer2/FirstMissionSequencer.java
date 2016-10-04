package nestedSequencer2;

import javax.realtime.PriorityParameters;
import javax.safetycritical.Mission;
import javax.safetycritical.MissionSequencer;
import javax.safetycritical.StorageParameters;

public class FirstMissionSequencer extends MissionSequencer<Mission>
{
  private boolean done = false;

  public FirstMissionSequencer(PriorityParameters priority, StorageParameters storage)
  {
    super(priority, storage, null);
  }

  @Override
  protected Mission getNextMission()
  {
    // devices.Console.println(getName() + ":getNextMission");
    if (done == false)
    {
      done = true;
      return new MyMission1();
    }
    else
    {
      return null;
    }
  }
}
