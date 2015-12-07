package org.robockets.buttonmanager.joysticks;

public enum XboxOne {
	A(1),
	B(2),
	X(3),
	Y(4),
	RIGHT_BUMPER(6),
	LEFT_BUMPER(5),
	RIGHT_TRIGGER_AXIS(3),
	LEFT_TRIGGER_AXIS(2),
	LEFT_X_AXIS(0),
	LEFT_Y_AXIS(1),
	RIGHT_X_AXIS(4),
	RIGHT_Y_AXIS(5);
	
	private int buttonNumber = 0;
	XboxOne(int buttonNumber) {
        this.buttonNumber = buttonNumber;
    }

    public int getButtonNumber() {
        return this.buttonNumber;
    }
}
