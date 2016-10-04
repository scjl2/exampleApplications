package nestedSequencer2;

import javax.realtime.PriorityParameters;
import javax.safetycritical.Mission;
import javax.safetycritical.MissionSequencer;
import javax.safetycritical.StorageParameters;

public class SecondMissionSequencer extends MissionSequencer<Mission>
{

  private boolean done = false;

  public SecondMissionSequencer(PriorityParameters priority, StorageParameters storage)
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
      return new MyMission2();
    }
    else
    {
      return null;
    }
  }
}
