package producerConsumer;

import javax.safetycritical.Services;

import devices.Console;

public class Buffer
{
  private volatile int theBuffer;
  private int[] testArray = new int[10];

  public Buffer()
  {
    theBuffer = 0;
    Services.setCeiling(this, 20);
  }

  public boolean bufferEmpty(String name)
  {
    Console.println(name + " Checking Buffer Empty");
    return theBuffer == 0;
  }

  public synchronized void write(int update) throws InterruptedException
  {
    boolean bufferEmpty = bufferEmpty("Producer");
    while (!bufferEmpty)
    {
      Console.println("Producer Waiting on Buffer");

      this.wait();

      bufferEmpty = bufferEmpty("Producer");
    }

    Console.println("Producer writing" + update + " to Buffer");
    theBuffer = update;
    this.notify();
  }

  public synchronized int read() throws InterruptedException
  {
    boolean bufferEmpty = bufferEmpty("Consumer");
    while (bufferEmpty)
      Console.println("Consumer" + " Waiting on Buffer");
    {
      this.wait();

      bufferEmpty = bufferEmpty("Consumer");
    }

    int out = theBuffer;
    Console.println("Consumer reading " + out + " from Buffer");
    theBuffer = 0;
    this.notify();

    return out;
  }
}
