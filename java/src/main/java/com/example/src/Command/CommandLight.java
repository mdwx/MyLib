package com.example.src.Command;

public class CommandLight implements Command{
	Lamp light;
	public CommandLight(Lamp light){
		this.light = light;
	}

	public void excute() {
		// TODO Auto-generated method stub
		light.on();
	}
	@Override
	public void undo() {
		light.off();
	}
}
