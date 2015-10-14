package org.robockets.buttonmanger.buttons;

import org.robockets.buttonmanger.Button;

import edu.wpi.first.wpilibj.command.Command;

public class ActionButton extends Button {
	
	public ActionButton(int joystickNumber, int buttonNumber, Command command) {
		super(joystickNumber, buttonNumber, command);
	}
	
	// Only runs if button is not pushed
	public boolean isFinished() {
		if (running) {
			stop();
			return true;
		}
		
		return false;
	}
}
