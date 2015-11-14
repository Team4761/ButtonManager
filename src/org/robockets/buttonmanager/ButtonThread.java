package org.robockets.buttonmanager;

/**
 * The thread that checks the buttons on repeat.
 * This thread must be started in teleopInit() or robotInit().
 */
public class ButtonThread implements Runnable {
	
	/**
	 * Inherited by Runnable.
	 */
	public void run() {
		while (true) {
			ButtonManager.checkButtons();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
