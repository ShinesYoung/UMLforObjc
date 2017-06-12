package net.shines.umlforobjc.application;

import java.util.ArrayList;

import net.shines.umlforobjc.gui.MainFrame;
import net.shines.umlforobjc.model.OCElement;
import net.shines.umlforobjc.model.OCRelation;
import net.shines.umlforobjc.model.object.OCClass;
import net.shines.umlforobjc.model.object.OCProtocol;
import net.shines.umlforobjc.model.relation.OCReference;

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
		ArrayList<OCRelation> relations = new ArrayList<OCRelation>();
		
		OCClass c1 = new OCClass();
		c1.setName("RootViewController");
		c1.setCenterX(400);
		c1.setCenterY(100);
		c1.setRadius(50);
		elements.add(c1);
		
		OCClass c2 = new OCClass();
		c2.setName("PointsSretachViewController");
		c2.setCenterX(100);
		c2.setCenterY(600);
		c2.setRadius(50);
		elements.add(c2);

		OCReference r1 = new OCReference();
		r1.setFrom(c2);
		r1.setTo(c1);
		r1.setName("Ref:"+r1.getFrom().getName()+"->"+r1.getTo().getName());
		relations.add(r1);
		
		OCProtocol aP = new OCProtocol();
		aP.setName("UITableViewDelegate");
		aP.setCenterX(500);
		aP.setCenterY(500);
		aP.setRadius(50);
		elements.add(aP);
		
		OCClass c3 = new OCClass();
		c3.setName("AnotherVC3");
		c3.setCenterX(100);
		c3.setCenterY(100);
		c3.setRadius(50);
		elements.add(c3);
		
		OCClass c4 = new OCClass();
		c4.setName("AnotherVC4");
		c4.setCenterX(700);
		c4.setCenterY(600);
		c4.setRadius(50);
		elements.add(c4);
		
		OCReference r2 = new OCReference();
		r2.setFrom(c4);
		r2.setTo(c3);
		r2.setName("Ref:"+r2.getFrom().getName()+"->"+r2.getTo().getName());
		relations.add(r2);
		
		
		this.mainFrame.paintUML(elements, relations);
		
	}
	
	
	public static void main(String args[])
	{
		Application app = new Application();
		app.start();
	}
}
