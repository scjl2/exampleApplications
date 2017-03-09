package threeThreads;

import javax.realtime.PriorityParameters;
import javax.safetycritical.Mission;
import javax.safetycritical.MissionSequencer;
import javax.safetycritical.StorageParameters;
import javax.safetycritical.annotate.Level;
import javax.safetycritical.annotate.SCJAllowed;

class MainSequencer extends MissionSequencer<Mission>
{
  private boolean notReleased = true;

  public MainSequencer(PriorityParameters priority, StorageParameters storage, String name)
      throws IllegalStateException
  {
    super(priority, storage, null);
  }

  @Override
  @SCJAllowed(Level.SUPPORT)
  protected Mission getNextMission()
  {
    if (notReleased)
    {
      notReleased = false;
      return new MissionA();
    }
    else
    {
      return null;
    }
  }
}
