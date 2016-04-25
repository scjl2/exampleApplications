package producerConsumer;
import javax.safetycritical.Services;

import devices.Console;

public class Buffer
{
	private volatile int buffer;

	public Buffer()
	{
		buffer = 0;
		Services.setCeiling(this, 20);
	}

	public boolean bufferEmpty(String name)
	{
		Console.println(name + " Checking Buffer Empty");
		return buffer == 0;
	}

	public synchronized void write(int update) throws InterruptedException
	{
		boolean bufferEmpty = bufferEmpty("Producer");
		while (!bufferEmpty)
		{
			Console.println("Producer Waiting on Buffer");

			this.wait();

			bufferEmpty =  bufferEmpty("Producer");
		}

		Console.println("Producer writing" + update + " to Buffer");
		buffer = update;
		this.notify();
	}

	public synchronized int read() throws InterruptedException
	{
		boolean bufferEmpty = bufferEmpty("Consumer");
		while(bufferEmpty)
		Console.println("Consumer" + " Waiting on Buffer");
		{
			this.wait();

			bufferEmpty = bufferEmpty("Consumer");
		}

		int out = buffer;
		Console.println("Consumer reading " + out + " from Buffer");
		buffer = 0;
		this.notify();

		return out;
	}

	public synchronized void waitOnBuffer(String name)

	{
		Console.println(name + " Waiting on Buffer");
		try
		{
			this.wait();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
