package org.robockets.buttonmanger.buttons;

import org.robockets.buttonmanger.Button;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleButton extends Button {
	private boolean toggle = false;

	public ToggleButton(int joystickNumber, int buttonNumber, Command command) {
		super(joystickNumber, buttonNumber, command);
	}

	// Only runs if button is not pushed
	public void notPressed() {
		if (running) {
			stop();
		}
	}
	
	public void pressed() {
		if (!toggle && !running) {
			super.start();
		}
	}
	
	public void stop() {
		super.stop();
	}
}
