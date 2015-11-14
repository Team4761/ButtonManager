package org.robockets.buttonmanager;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.Joystick;

/**
 * The main class that people will interact with
 * when creating buttons.
 * This class should only be used statically.
 * @author jakekinsella
 */
public class ButtonManager {
	private static ArrayList<Joystick> joysticks = new ArrayList<Joystick>();
	private static ArrayList<Button> boundButtons = new ArrayList<Button>();
	
	/**
	 * A static method to add a joystick for use with binding buttons to.
	 * All joysticks must be added through this method so that buttons can
	 * be bound.
	 * @param joystick a joystick object
	 */
	public static void addJoystick(Joystick joystick) {
		joysticks.add(joystick);
	}
	
	/**
	 * An overloaded static method for addJoystick.
	 * @param port the port of the new joystick
	 */
	public static void addJoystick(int port) {
		addJoystick(new Joystick(port));
	}
	
	/**
	 * A static method to get a specific joystick.
	 * @param number the port of the joystick
	 * @return a joystick object
	 */
	public static Joystick getJoystick(int number) {
		return joysticks.get(number);
	}
	
	/**
	 * A static method to get the state of a button
	 * @param joystick the joystick port that the button is on
	 * @param button the button number
	 * @return the state of the button
	 */
	public static boolean getButtonState(int joystick, int button) {
		return getJoystick(joystick).getRawButton(button);
	}
	
	/**
	 * A static method to bind a new button
	 * @param button an object with Button as a superclass
	 */
	public static void addButton(Button button) {
		boundButtons.add(button);
	}

	protected static void checkButtons() {
		for (int i = 0; i < boundButtons.size(); i++) {
			boundButtons.get(i).check();
		}
	}
}
