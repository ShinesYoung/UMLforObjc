package net.shines.umlforobjc.gui;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import net.shines.umlforobjc.model.OCElement;
import net.shines.umlforobjc.model.OCRelation;

public class MainPanel extends JPanel
{
	private static final long serialVersionUID = 600676089770427676L;
	
	private List<OCElement> elements;
	private List<OCRelation> relations;
	
	
	public MainPanel() 
	{
		super();
		this.elements  = new ArrayList<OCElement>();
		this.relations = new ArrayList<OCRelation>();
	}
	
	public List<OCElement> getElements() {
		return elements;
	}
	public void setElements(List<OCElement> elements) {
		this.elements = elements;
	}
	public List<OCRelation> getRelations() {
		return relations;
	}
	public void setRelations(List<OCRelation> relations) {
		this.relations = relations;
	}

	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		
		for (OCElement aEle : this.elements) 
		{
			aEle.paint(g);
		}
		
		for (OCRelation aRel : this.relations) 
		{
			aRel.paint(g);
		}
		
	}
}
