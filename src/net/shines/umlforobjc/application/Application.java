package net.shines.umlforobjc.application;

import java.util.ArrayList;
import java.util.Random;

import net.shines.umlforobjc.gui.MainFrame;
import net.shines.umlforobjc.model.OCElement;
import net.shines.umlforobjc.model.object.OCClass;

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
		
		OCClass aClass = new OCClass();
		aClass.setName("PointsSretachViewController");
		
		Random rand = new Random();
		aClass.setCenterX(200);
		aClass.setCenterY(200);
		aClass.setRadius(50);
		elements.add(aClass);
		
		
		this.mainFrame.paintUML(elements);
		
	}
}
