package net.shines.umlforobjc.gui;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import net.shines.umlforobjc.model.OCElement;

public class MainPanel extends JPanel
{
	private static final long serialVersionUID = 600676089770427676L;
	
	private List<OCElement> elements; 
	
	
	public MainPanel() 
	{
		super();
		this.elements = new ArrayList<OCElement>();
	}
	
	public List<OCElement> getElements() {
		return elements;
	}
	public void setElements(List<OCElement> elements) {
		this.elements = elements;
	}

	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		
		for (OCElement aEle : this.elements) 
		{
			aEle.paint(g);
		}
		
	}
}
