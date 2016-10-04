package nestedSequencer3;

import javax.realtime.PriorityParameters;
import javax.safetycritical.Mission;
import javax.safetycritical.MissionSequencer;
import javax.safetycritical.StorageParameters;
import javax.safetycritical.annotate.Level;
import javax.safetycritical.annotate.SCJAllowed;

import devices.Console;

class NestedMissionSequencer extends MissionSequencer<Mission>
{
  private int releases = 0;

  public NestedMissionSequencer(PriorityParameters priority, StorageParameters storage,
      String name) throws IllegalStateException
  {
    super(priority, storage, null);
  }

  @Override
  @SCJAllowed(Level.SUPPORT)
  protected Mission getNextMission()
  {
    // Console.println(getName() + " getNextMission");

    if (releases == 0)
    {
      releases++;

      return new NestedMissionA();
    }
    else if (releases == 1)
    {
      releases++;

      return new NestedMissionB();
    }
    else
    {
      return null;
    }

  }

}
