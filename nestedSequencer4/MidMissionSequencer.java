package nestedSequencer4;

import javax.realtime.PriorityParameters;
import javax.safetycritical.Mission;
import javax.safetycritical.MissionSequencer;
import javax.safetycritical.StorageParameters;
import javax.safetycritical.annotate.Level;
import javax.safetycritical.annotate.SCJAllowed;

import devices.Console;

class MidMissionSequencer extends MissionSequencer<Mission>
{
  private boolean notReleased = true;

  public MidMissionSequencer(PriorityParameters priority, StorageParameters storage,
      String name) throws IllegalStateException
  {
    super(priority, storage, null);
  }

  @Override
  @SCJAllowed(Level.SUPPORT)
  protected Mission getNextMission()
  {
    // Console.println(getName()+ " getNextMission");

    if (notReleased)
    {

      notReleased = false;
      return new MidMission();
    }
    else
    {
      return null;
    }
  }

}
