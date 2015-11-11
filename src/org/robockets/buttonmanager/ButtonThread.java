package org.robockets.buttonmanager;

public class ButtonThread implements Runnable {
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
