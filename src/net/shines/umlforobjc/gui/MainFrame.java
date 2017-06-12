package net.shines.umlforobjc.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JFrame;

import net.shines.umlforobjc.model.OCElement;
import net.shines.umlforobjc.model.OCProject;
import net.shines.umlforobjc.model.OCRelation;



public class MainFrame extends JFrame
{
	private static final long serialVersionUID = 438905636100189271L;
	
	private BorderLayout layout;
	private MainPanel mainPanel;
	
	public MainFrame()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int screenWidth  = (int)toolkit.getScreenSize().getWidth();
		int screenHeight = (int)toolkit.getScreenSize().getHeight();
		this.setSize(screenWidth, screenHeight);
		
		int x = (int)(screenWidth - this.getWidth())/2;
		int y = (int)(screenHeight - this.getHeight())/2;
		this.setLocation(x, y);
		
		this.setFont(new Font("Helvetica", Font.PLAIN, 14));
		this.setBackground(Color.WHITE);
		this.setTitle("UML");
		
		this.setLayout(this.getLayout());
		this.getContentPane().add(this.getMainPanel());
		
	}
	
	public BorderLayout getLayout()
	{
		if (this.layout == null) 
		{
			this.layout = new BorderLayout();
		}
		return this.layout;
	}
	
	public MainPanel getMainPanel()
	{
		if (this.mainPanel == null) 
		{
			this.mainPanel = new MainPanel();
			this.mainPanel.setBackground(Color.WHITE);
		}
		return this.mainPanel;
	}
	
	public void paintUML(List<OCElement> elements, List<OCRelation> relations)
	{
		this.getMainPanel().setElements(elements);
		this.getMainPanel().setRelations(relations);
	}
	
	public void paintProject(OCProject aProject)
	{
		
	}
	
}
