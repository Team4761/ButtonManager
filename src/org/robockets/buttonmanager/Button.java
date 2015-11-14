package org.robockets.buttonmanager;

import edu.wpi.first.wpilibj.command.Command;

/**
 * The superclass of all other buttons.
 * This class should not be used to bind buttons.
 */
public class Button {
	protected int buttonNumber = 0, joystickNumber = 0;
	protected boolean running = false;
	
	protected Command command;
	
	public Button(int joystickNumber, int buttonNumber, Command command) {
		this.buttonNumber = buttonNumber;
		this.joystickNumber = joystickNumber;
		this.command = command;
	}
	
	protected void check() {
		if (ButtonManager.getButtonState(joystickNumber, buttonNumber)) {
			pressed();
		} else {
			notPressed();
		}
	}
	
	public boolean isRunning() {
		return running;
	}
	
	protected void notPressed() {
		running = false;
	}
	
	protected void pressed() {
		if (!running) {
			start();
		}
		
		running = true;
	}
	
	protected void start() {
		command.start(); // Should run over and over again
	}
	
	public void stop() {
		running = false;
		command.cancel();
	}
}
