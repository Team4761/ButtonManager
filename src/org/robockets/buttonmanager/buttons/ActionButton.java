package org.robockets.buttonmanager.buttons;

import org.robockets.buttonmanager.Button;

import edu.wpi.first.wpilibj.command.Command;

public class ActionButton extends Button {
	private boolean killOnRelease = true;
	
	public ActionButton(int joystickNumber, int buttonNumber, Command command, boolean killOnRelease) {
		super(joystickNumber, buttonNumber, command);
		this.killOnRelease = killOnRelease;
	}
	
	protected void notPressed() {
		if (killOnRelease) {
			stop();
		}
	}
}
