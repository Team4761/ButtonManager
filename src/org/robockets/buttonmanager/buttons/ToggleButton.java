package org.robockets.buttonmanager.buttons;

import org.robockets.buttonmanager.Button;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleButton extends Button {
	private boolean toggle = false;

	/**
	 * The command should have some code to run in the run method and other code to run in the interrupted method
	 */
	public ToggleButton(int joystickNumber, int buttonNumber, Command command) {
		super(joystickNumber, buttonNumber, command);
	}

	// Only runs if button is not pushed
	public void notPressed() {
		running = false;
	}
	
	public void pressed() {
		if (!running) {
			if (!toggle) {
				toggle = true;
				super.start();
			} else {
				toggle = false;
				super.stop();
			}
		}
	}
	
	public void stop() {
		super.stop();
	}
	
	// True means running "run" and false means running "interrupted"
	public boolean getToggleStatus() {
		return toggle;
	}
}
