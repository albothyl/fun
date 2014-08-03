package org.common.other;

public class mazeVO {
	private int gpsX;
	private int gpsY;
	private int direction;
	private int correct;
	
	public int getGpsX() {
		return gpsX;
	}
	public void setGpsX(int gpsX) {
		this.gpsX = gpsX;
	}
	public int getGpsY() {
		return gpsY;
	}
	public void setGpsY(int gpsY) {
		this.gpsY = gpsY;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public int getCorrect() {
		return correct;
	}
	public void setCorrect(int correct) {
		this.correct = correct;
	}
	
	@Override
	public String toString() {
		return "mazeVO [gpsX=" + gpsX + ", gpsY=" + gpsY + ", direction="
				+ direction + ", correct=" + correct + "]";
	}
	
}
