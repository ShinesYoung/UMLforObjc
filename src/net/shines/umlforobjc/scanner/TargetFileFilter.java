package net.shines.umlforobjc.scanner;

import java.io.File;
import java.io.FileFilter;

public class TargetFileFilter implements FileFilter
{
	@Override
	public boolean accept(File aPath) 
	{
		if (aPath.exists() == false) {
			return false;
		}
		if (aPath.isHidden() == true) {
			return false;
		}
		if (aPath.isDirectory() == true) { 
			return true;
		}
		if (aPath.getName().endsWith(".h")) {
			return true;
		}
		if (aPath.getName().endsWith(".m")) {
			return true;
		}
		
		return false;
	}

}
