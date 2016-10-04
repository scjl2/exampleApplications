package nestedSequencer5;

import javax.realtime.AperiodicParameters;
import javax.realtime.RelativeTime;
import javax.safetycritical.Mission;
import javax.safetycritical.annotate.Level;
import javax.safetycritical.annotate.SCJAllowed;

import devices.Console;

class BottomMissionA extends Mission
{
  @Override
  @SCJAllowed(Level.SUPPORT)
  protected void initialize()
  {
    Console.println("MissionA initialize");

    OSEH oneShot = new OSEH(MyApp.pri, new RelativeTime(60, 0), new AperiodicParameters(new RelativeTime(100, 0), null), MyApp.storage,
        this);
    oneShot.register();

    MT2 thread2 = new MT2(MyApp.pri, MyApp.storage);
    thread2.register();

  }

  @Override
  @SCJAllowed(Level.SUPPORT)
  public long missionMemorySize()
  {
    return 1048576;
  }
}