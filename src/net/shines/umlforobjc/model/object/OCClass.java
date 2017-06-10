package net.shines.umlforobjc.model.object;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import net.shines.umlforobjc.model.OCElement;

public class OCClass extends OCElement
{

	@Override
	public void paint(Graphics g) 
	{
		if (g instanceof Graphics2D) 
		{
			float dash[] = {0.0f};
			BasicStroke stroke = new BasicStroke(1.0f);
			((Graphics2D) g).setStroke(stroke);
		}
		
		g.setColor(Color.BLACK);
		g.drawOval(this.getCenterX() - this.getRadius(), 
				   this.getCenterY() - this.getRadius(), 
				   this.getRadius()*2, this.getRadius()*2);
		
		int offsetOfName = this.getName().length() * 6/2;
		
		g.drawString(this.getName(), 
					 this.getCenterX() - offsetOfName, 
					 this.getCenterY());
	}
	
}
