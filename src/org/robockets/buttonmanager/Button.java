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
	
	/**
	 * Class constructor.
	 * @param joystickNumber The joystick port that the button will be bound to
	 * @param buttonNumber The button number that the button will be bound to
	 * @param command The command that the button will run when pressed
	 */
	
	public Button(int joystickNumber, int buttonNumber, Command command) {
		this.buttonNumber = buttonNumber;
		this.joystickNumber = joystickNumber;
		this.command = command;
	}
	
	/**
	 * A method that is called by ButtonManager's check method.
	 * Checks if button is pressed and executes based on that result.
	 */
	protected void check() {
		if (ButtonManager.getButtonState(joystickNumber, buttonNumber)) {
			pressed();
		} else {
			notPressed();
		}
	}
	
	/**
	 * Check if button is executing
	 * @return the state of the execution
	 */
	public boolean isRunning() {
		return running;
	}
	
	/**
	 * Ran when the button is notPressed
	 */
	protected void notPressed() {
		running = false;
	}
	
	/**
	 * Ran when the button is pressed
	 */
	protected void pressed() {
		if (!running) {
			start();
		}
		
		running = true;
	}
	
	/**
	 * Starts the command.
	 * The command automatically ends its execution when isFinished() returns true
	 */
	protected void start() {
		command.start(); // Should run over and over again
	}
	
	/**
	 * Stops the command.
	 */
	protected void stop() {
		running = false;
		command.cancel();
	}
}
