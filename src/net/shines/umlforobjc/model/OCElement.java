package net.shines.umlforobjc.model;

import java.util.ArrayList;

import net.shines.umlforobjc.gui.Paintable;

public abstract class OCElement implements Paintable, Comparable<OCElement>
{
	private String name;
	
	private int centerX;
	private int centerY;
	private int radius;
	
	private int inDegree = 0;
	private int outDegree = 0;
	
	private ArrayList<OCElement> outElements;
	
	public OCElement() 
	{
		this.inDegree = 0;
		this.outDegree = 0;
		this.outElements = new ArrayList<OCElement>();
	}
	
	public void addOutElement(OCElement aOutEle)
	{
		this.outElements.add(aOutEle);
	}
	
	
	@Override
	public int compareTo(OCElement other) 
	{
		int selfDegreeSum = this.inDegree + this.outDegree;
		int otherDegreeSum = other.getInDegree() + other.getOutDegree();
		return (selfDegreeSum > otherDegreeSum) ? 1 : -1;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCenterX() {
		return centerX;
	}
	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}
	
	public int getCenterY() {
		return centerY;
	}
	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}
	
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public int getInDegree() {
		return inDegree;
	}
	public void setInDegree(int inDegree) {
		this.inDegree = inDegree;
	}
	
	public int getOutDegree() {
		return outDegree;
	}
	public void setOutDegree(int outDegree) {
		this.outDegree = outDegree;
	}

	public ArrayList<OCElement> getOutElements() {
		return outElements;
	}

	
}
