package org.robockets.buttonmanger;

public class ButtonThread implements Runnable {
	private long startTime = 0;

	public void run() {
		while (true) {
			setTimeout();
			ButtonManager.checkButtons();
			waitUntilTimedOut();
		}
	}
	
	private void setTimeout() {
		startTime = System.nanoTime();
	}
	
	private void waitUntilTimedOut() {
		while (System.nanoTime() >= startTime + 1000000000) { // 1000000000ns should be 1s
			// Just wait
		}
	}
}
