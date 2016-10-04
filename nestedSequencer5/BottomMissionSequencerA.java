package nestedSequencer5;

import javax.realtime.PriorityParameters;
import javax.safetycritical.Mission;
import javax.safetycritical.MissionSequencer;
import javax.safetycritical.StorageParameters;
import javax.safetycritical.annotate.Level;
import javax.safetycritical.annotate.SCJAllowed;

import devices.Console;

class BottomMissionSequencerA extends MissionSequencer<Mission>
{
  private boolean notReleased = true;

  public BottomMissionSequencerA(PriorityParameters priority, StorageParameters storage,
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
      return new BottomMissionA();
    }
    else
    {
      return null;
    }
  }

}
