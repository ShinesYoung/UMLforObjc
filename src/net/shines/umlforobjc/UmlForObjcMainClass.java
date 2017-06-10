package net.shines.umlforobjc;

import net.shines.umlforobjc.application.Application;

public class UmlForObjcMainClass 
{
	public static final String scanPath = "/Users/yangshansi/git_space/mobile-client";
	
	public static void main(String[] args) 
	{
//		File scanPath = new File("/Users/yangshansi/git_space/mobile-client/webApp");
//		List<File> aPathList = new ArrayList<File>();
//		DirectoryScanner scanner = new DirectoryScanner();
//		scanner.scanPath(scanPath, aPathList);
//		
//		File outputFile = new File("output/fileListInDisk.txt");
//		FileOutputer output = new FileOutputer();
//		output.outputFileList(outputFile, aPathList, PathType.RelativePath, false);
		
		Application app = new Application();
		app.start();
	}

}
