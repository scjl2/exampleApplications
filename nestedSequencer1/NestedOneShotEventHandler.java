package nestedSequencer1;

import javax.safetycritical.OneShotEventHandler;
import javax.safetycritical.StorageParameters;
import javax.realtime.AperiodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.HighResolutionTime;

public class NestedOneShotEventHandler extends OneShotEventHandler
{
  public NestedOneShotEventHandler(PriorityParameters priority, HighResolutionTime time,
      AperiodicParameters release, StorageParameters storage)
  {
    super(priority, time, release, storage, null);
  }

  @Override
  public void handleAsyncEvent()
  {
  }
}
