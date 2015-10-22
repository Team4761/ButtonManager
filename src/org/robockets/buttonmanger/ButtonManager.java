package org.robockets.buttonmanger;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.Joystick;

public class ButtonManager {
	public static ArrayList<Joystick> joysticks = new ArrayList<Joystick>();
	public static ArrayList<Button> boundButtons = new ArrayList<Button>();
	
	public static void addJoystick(int port) {
		joysticks.add(new Joystick(port));
	}
	
	public static Joystick getJoystick(int number) {
		return joysticks.get(number);
	}
	
	public static boolean getButtonState(int joystick, int button) {
		return getJoystick(joystick).getRawButton(button);
	}
	
	public static void addButton(Button button) {
		boundButtons.add(button);
	}
	
	public static void checkButtons() {
		for (int i = 0; i < boundButtons.size(); i++) {
			boundButtons.get(i).check();
		}
	}
}
