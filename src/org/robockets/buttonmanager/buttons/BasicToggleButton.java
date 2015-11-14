package org.robockets.buttonmanager.buttons;

import org.robockets.buttonmanager.Button;

import edu.wpi.first.wpilibj.command.Command;

public class BasicToggleButton extends Button {
	private boolean toggle = false;
	private boolean notPressed = false; // Used to prevent the command running both start and stop when button is held down 

	/**
	 * The command should have some code to run in the run method and other code to run in the interrupted method
	 */
	public BasicToggleButton(int joystickNumber, int buttonNumber, Command command) {
		super(joystickNumber, buttonNumber, command);
	}

	// Only runs if button is not pushed
	public void notPressed() {
		notPressed = true;
		running = false;
	}
	
	public void pressed() {
		running = true;
		
		if (running && notPressed) {
			if (!toggle) {
				toggle = true;
				super.start();
			} else {
				toggle = false;
				stop();
			}
		}
		
		notPressed = false;
	}
	
	public void stop() {	
		super.command.cancel();
	}
	
	// True means running "run" and false means running "interrupted"
	public boolean getToggleStatus() {
		return toggle;
	}
}
