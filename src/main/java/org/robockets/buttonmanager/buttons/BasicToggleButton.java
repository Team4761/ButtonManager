package org.robockets.buttonmanager.buttons;

import org.robockets.buttonmanager.Button;

import edu.wpi.first.wpilibj.command.Command;

/**
 * A basic toggle button that will run the execute method of a command
 * until the button is pressed again and then it will run the interrupted
 * method once.
 */
public class BasicToggleButton extends Button {
	private boolean toggle = false;
	private boolean notPressed = false; // Used to prevent the command running both start and stop when button is held down

	/**
	 * Class constructor
	 * @param joystickNumber The joystick port that the button will be bound to
	 * @param buttonNumber The button number that the button will be bound to
	 * @param command The command that the button will run when pressed
	 */
	public BasicToggleButton(int joystickNumber, int buttonNumber, Command command) {
		super(joystickNumber, buttonNumber, command);
	}

	/**
	 * Ran when the button is not pressed
	 */
	protected void notPressed() {
		notPressed = true;
		running = false;
	}

	/**
	 * Ran when the button is pressed
	 */
	protected void pressed() {
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
	
	/**
	 * Stops the command
	 */
	protected void stop() {	
		super.command.cancel();
	}
	
	/**
	 * Gets the toggle status of the button
	 * @return True means running "run" and false means running "interrupted"
	 */
	public boolean getToggleStatus() {
		return toggle;
	}
}
