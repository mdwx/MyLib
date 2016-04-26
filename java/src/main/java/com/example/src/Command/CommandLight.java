package com.example.src.Command;

public class CommandLight implements Command{
	Lamp light;
	boolean LampState = false;
	
	public CommandLight(Lamp light){
		this.light = light;
	}

	public void excute() {
		// TODO Auto-generated method stub
		if(LampState){
			light.off();
		}
		else{
			light.on();
		}
		LampState = !LampState;
	}
	

}
