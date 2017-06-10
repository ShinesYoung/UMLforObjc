package net.shines.umlforobjc.model.object;

import java.awt.Color;
import java.awt.Graphics;

import net.shines.umlforobjc.model.OCElement;

public class OCClass extends OCElement
{

	@Override
	public void paint(Graphics g) 
	{
		g.setColor(Color.BLACK);
		g.drawOval(this.getCenterX() - this.getRadius()/2, this.getCenterY() -this.getRadius(), this.getRadius(), this.getRadius());
		g.drawString(this.getName(), this.getCenterX() , this.getCenterY());
	}
	
}
