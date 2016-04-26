package com.example.src.Command;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lamp light = new Lamp();
		Command lightcommand = new CommandLight(light);
		
		Television television = new Television();
		Command televisioncommand = new CommandTelevision(television);
		
		RemoteControlSimple remotecontrol =new RemoteControlSimple(2);
		
		remotecontrol.setCommand(0, lightcommand);
		remotecontrol.setCommand(1, televisioncommand);
		remotecontrol.buttonWasPressed(0);
		remotecontrol.buttonWasPressed(1);
		remotecontrol.buttonWasPressed(0);
		remotecontrol.buttonWasPressed(1);
	}

}
