package net.shines.umlforobjc.application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.shines.umlforobjc.gui.MainFrame;
import net.shines.umlforobjc.model.OCProject;
import net.shines.umlforobjc.parser.FileParser;
import net.shines.umlforobjc.parser.ParseContext;
import net.shines.umlforobjc.scanner.PathScanner;
import net.shines.umlforobjc.scanner.TargetFileFilter;

public class Application 
{
	private MainFrame mainFrame;
	
	private PathScanner pathScanner;
	private FileParser fileParser;
	
	public Application() 
	{
		this.mainFrame = new MainFrame();
		this.pathScanner = new PathScanner(); 
		this.fileParser = new FileParser();
	}
	
	public void start()
	{
		this.mainFrame.setVisible(true);
		
		File targetPath = new File("/Users/yangshansi/git_space/mobile-client/webApp");
		List<File> pathList = new ArrayList<File>();
		this.pathScanner.scanPath(targetPath, pathList, new TargetFileFilter());
		
		ParseContext context = new ParseContext();
		this.fileParser.parseFiles(pathList, context);
		
		OCProject aProject = new OCProject();
		aProject.config(context);
		
		this.mainFrame.paintProject(aProject);
	}
	
	
	public static void main(String args[])
	{
		Application app = new Application();
		app.start();
	}
}
