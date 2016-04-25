package producerConsumer;

import javax.safetycritical.LaunchLevel2;

import devices.Console;

//Application entry point, runs the Safelet
public class PCSafeletLauncher
{
	public static void main(String[] args)
	{
		Console.println("PCSafeletLauncher ");

		new LaunchLevel2(new PCSafelet());

		Console.println("PCSafeletLauncher Finished");
	}
}
