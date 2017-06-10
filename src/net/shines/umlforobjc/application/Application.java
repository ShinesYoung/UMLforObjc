package net.shines.umlforobjc.application;

import java.util.ArrayList;
import java.util.Random;

import net.shines.umlforobjc.gui.MainFrame;
import net.shines.umlforobjc.model.OCElement;
import net.shines.umlforobjc.model.object.OCClass;
import net.shines.umlforobjc.model.object.OCProtocol;

public class Application 
{
	private MainFrame mainFrame;
	
	public Application() 
	{
		if (this.mainFrame == null) 
		{
			this.mainFrame = new MainFrame();
		}
	}
	
	public void start()
	{
		this.mainFrame.setVisible(true);
		
		ArrayList<OCElement> elements = new ArrayList<OCElement>();
		
		OCClass c1 = new OCClass();
		c1.setName("RootViewController");
		c1.setCenterX(400);
		c1.setCenterY(100);
		c1.setRadius(50);
		elements.add(c1);
		
		
		OCProtocol aP = new OCProtocol();
		aP.setName("UITableViewDelegate");
		aP.setCenterX(500);
		aP.setCenterY(500);
		aP.setRadius(50);
		elements.add(aP);
		
		OCClass aClass = new OCClass();
		aClass.setName("PointsSretachViewController");
		aClass.setCenterX(100);
		aClass.setCenterY(100);
		aClass.setRadius(50);
		elements.add(aClass);
		
		this.mainFrame.paintUML(elements);
		
	}
}
