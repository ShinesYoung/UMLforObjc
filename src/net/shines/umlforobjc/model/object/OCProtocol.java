package net.shines.umlforobjc.model.object;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import net.shines.umlforobjc.model.OCElement;

public class OCProtocol extends OCElement
{

	@Override
	public void paint(Graphics g) 
	{
		if (g instanceof Graphics2D) 
		{
			float dash[] = {5.0f};
			BasicStroke stroke = new BasicStroke(1.0f,
				BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10.0f,dash,0.0f);
			((Graphics2D) g).setStroke(stroke);
		}
		
		g.setColor(Color.GRAY);
		
		g.drawOval(this.getCenterX() - this.getRadius(), 
				   this.getCenterY() - this.getRadius(), 
				   this.getRadius()*2, this.getRadius()*2);
		
		int offsetOfName = (int)(this.getName().length() * (6)/2.0);
		
		g.drawString(this.getName(), 
					 this.getCenterX() - offsetOfName, 
					 this.getCenterY());
	}
	

}
