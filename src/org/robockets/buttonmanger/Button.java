package org.robockets.buttonmanger;

import edu.wpi.first.wpilibj.command.Command;

public class Button {
	protected int buttonNumber = 0, joystickNumber = 0;
	protected boolean running = false;
	
	private Command command;
	
	public Button(int joystickNumber, int buttonNumber, Command command) {
		this.buttonNumber = buttonNumber;
		this.joystickNumber = joystickNumber;
		this.command = command;
		
	}
	
	protected void check() {
		if (ButtonManager.getButtonState(joystickNumber, buttonNumber)) {
			run();
		} else {
			isFinished();
		}
	}
	
	public boolean isRunning() {
		return running;
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void run() {
		running = true;
		command.start();
	}
	
	protected void stop() {
		running = false;
		command.cancel();
	}
}
