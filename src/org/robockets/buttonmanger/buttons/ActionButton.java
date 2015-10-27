package org.robockets.buttonmanger.buttons;

import org.robockets.buttonmanger.Button;

import edu.wpi.first.wpilibj.command.Command;

public class ActionButton extends Button {
	private boolean killOnRelease = true;
	
	public ActionButton(int joystickNumber, int buttonNumber, Command command, boolean killOnRelease) {
		super(joystickNumber, buttonNumber, command);
		this.killOnRelease = killOnRelease;
	}
	
	protected void notPressed() {
		command.cancel();
	}
	
	
}
