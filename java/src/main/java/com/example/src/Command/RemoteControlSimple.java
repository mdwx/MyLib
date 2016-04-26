package com.example.src.Command;

public class RemoteControlSimple {
	Command command[];
	
	public RemoteControlSimple(){};
	public RemoteControlSimple(int id){
		Command com = new CommandNothing();
		this.command = new Command[id];
		for(int i=0; i<id; i++){
			this.command[i] = com;
		}
		
	}
	
	public void setCommand(int id,Command command){
		this.command[id] = command;
	}
	
	public void buttonWasPressed(int id){
		command[id].excute();
	}
}
