package nestedSequencer5;

import javax.realtime.AperiodicParameters;
import javax.realtime.PeriodicParameters;
import javax.realtime.RelativeTime;
import javax.safetycritical.Mission;
import javax.safetycritical.annotate.Level;
import javax.safetycritical.annotate.SCJAllowed;

import devices.Console;

class BottomMissionB extends Mission
{
  @Override
  @SCJAllowed(Level.SUPPORT)
  protected void initialize()
  {
    Console.println("MissionB initialize");

   
    APEH apeh = new APEH(MyApp.pri, new AperiodicParameters(new RelativeTime(5, 0), null), MyApp.storage, "APEH", this);
    apeh.register();

  
    PEH peh = new PEH(MyApp.pri, new PeriodicParameters(new RelativeTime(60, 0),
        new RelativeTime(5, 0)), MyApp.storage, "PEH", apeh);
    peh.register();
  }

  @Override
  @SCJAllowed(Level.SUPPORT)
  public long missionMemorySize()
  {
    return 1048576;
  }
}