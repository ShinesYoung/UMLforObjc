package net.shines.umlforobjc.parser;

import java.io.File;
import java.util.List;

import net.shines.kitbox.file.FileUtils;

public class FileParser 
{
	public static int rangeOfX  = 4500;
	public static int rangeOfY  = 4500;
	
	private ObjcHeaderParser headerParser;
	private ObjcSourceParser sourceParser;
	
	
	public FileParser()
	{
		this.headerParser = new ObjcHeaderParser();
		this.sourceParser = new ObjcSourceParser();
	}
	
	public void parseFiles(List<File> fileList, ParseContext context)
	{
		if (fileList == null || context == null) {
			System.out.println("FileScanner : fileList or context is null.");
			return;
		}
		
		for (File aFile : fileList) 
		{
			if (aFile.exists() == false || aFile.isHidden() || aFile.isDirectory()) {
				continue;
			}
			this.parseFile(aFile, context);
		}
	}
	
	public void parseFile(File aFile, ParseContext context)
	{
		if (aFile.getName().endsWith(".h") == false &&
			aFile.getName().endsWith(".m") == false) 
		{
			return;
		}
		
		String fileContent = FileUtils.readStringFromFile(aFile);
		
		if (aFile.getName().endsWith(".h")) 
		{
			this.headerParser.parse(aFile.getName(), fileContent, context);
		}
		else if (aFile.getName().endsWith(".m")) 
		{
			this.sourceParser.parse(aFile.getName(), fileContent, context);
		}
	}
}
