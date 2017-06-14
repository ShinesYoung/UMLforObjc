package net.shines.umlforobjc.model.relation;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import net.shines.umlforobjc.model.OCRelation;

public class OCReference extends OCRelation
{

	@Override
	public void drawPath(Graphics g) 
	{
		g.setColor(Color.black);
		if (g instanceof Graphics2D) 
		{
			BasicStroke stroke = new BasicStroke(1.0f);
			((Graphics2D) g).setStroke(stroke);
		}
		
		double pow1 = Math.pow(this.getFrom().getCenterX() - this.getTo().getCenterX(), 2);
		double pow2 = Math.pow(this.getFrom().getCenterY() - this.getTo().getCenterY(), 2);
		this.setDistance(Math.sqrt(pow1 + pow2) );
		
		double fromX = this.getFrom().getCenterX() + 
				(this.getFrom().getRadius() / this.getDistance()) * (this.getTo().getCenterX() - this.getFrom().getCenterX());
		this.setFromX((int)fromX);
		
		double fromY = this.getFrom().getCenterY() + 
				(this.getFrom().getRadius() / this.getDistance()) * (this.getTo().getCenterY() - this.getFrom().getCenterY());
		this.setFromY((int)fromY);
		
		double toX = this.getTo().getCenterX() -
				(this.getTo().getRadius() / this.getDistance()) * (this.getTo().getCenterX() - this.getFrom().getCenterX());
		this.setToX((int)toX);
		
		double toY = this.getTo().getCenterY() -
				(this.getTo().getRadius() / this.getDistance()) * (this.getTo().getCenterY() - this.getFrom().getCenterY());
		this.setToY((int)toY);
		
		g.drawLine(this.getFromX(), this.getFromY(), this.getToX(), this.getToY());
	}

	@Override
	public void drawDirection(Graphics g)
	{
	}
	

}
