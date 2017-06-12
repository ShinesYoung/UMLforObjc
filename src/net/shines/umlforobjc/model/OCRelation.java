package net.shines.umlforobjc.model;

import java.awt.Graphics;

import net.shines.umlforobjc.gui.Paintable;

public abstract class OCRelation implements Paintable
{
	private String name;
	
	private OCElement from;
	private OCElement to;
	
	private int fromX;
	private int fromY;
	private int toX;
	private int toY;
	
	private double distance;
	
	public void paint(Graphics g)
	{
		this.drawPath(g);
		this.drawDirection(g);
	}
	
	public abstract void drawPath(Graphics g);
	public abstract void drawDirection(Graphics g); 
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public OCElement getFrom() {
		return from;
	}
	public void setFrom(OCElement from) {
		this.from = from;
	}
	public OCElement getTo() {
		return to;
	}
	public void setTo(OCElement to) {
		this.to = to;
	}
	public int getFromX() {
		return fromX;
	}
	public void setFromX(int fromX) {
		this.fromX = fromX;
	}
	public int getFromY() {
		return fromY;
	}
	public void setFromY(int fromY) {
		this.fromY = fromY;
	}
	public int getToX() {
		return toX;
	}
	public void setToX(int toX) {
		this.toX = toX;
	}
	public int getToY() {
		return toY;
	}
	public void setToY(int toY) {
		this.toY = toY;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	
	
}
