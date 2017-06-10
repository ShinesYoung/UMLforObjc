package net.shines.umlforobjc.model.object;

import java.awt.Color;
import java.awt.Graphics;

import net.shines.umlforobjc.model.OCElement;

public class OCProtocol extends OCElement
{

	@Override
	public void paint(Graphics g) 
	{
		g.setColor(Color.LIGHT_GRAY);
		g.drawOval(this.getCenterX(), this.getCenterY(), this.getRadius(), this.getRadius());
		g.drawString(this.getName(), this.getCenterX(), this.getCenterY());
	}
	

}
