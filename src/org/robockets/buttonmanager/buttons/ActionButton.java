package org.robockets.buttonmanager.buttons;

import org.robockets.buttonmanager.Button;

import edu.wpi.first.wpilibj.command.Command;

/**
 * The basic press-to-run button
 */
public class ActionButton extends Button {
	private boolean killOnRelease = true;
	
	/**
	 * Class constructor
	 * @param joystickNumber The joystick port that the button will be bound to
	 * @param buttonNumber The button number that the button will be bound to
	 * @param command The command that the button will run when pressed
	 * @param killOnRelease true if the button should stop command execution when released
	 */
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
