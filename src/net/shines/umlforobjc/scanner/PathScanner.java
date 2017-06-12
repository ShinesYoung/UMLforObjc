package net.shines.umlforobjc.scanner;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import net.shines.umlforobjc.tree.TreeNode;

public class PathScanner 
{
	public void scanPath(File targetPath, List<File> aPathList, FileFilter filter)
	{
		if (targetPath == null || aPathList == null) { 
			return; 
		}
		
		List<File> stack = new ArrayList<File>();
		stack.add(targetPath);
		
		while (stack.size() > 0)
		{
			File aPath = stack.remove(stack.size() -1);
			
			if (aPath.isHidden()) // it's a leaf
			{
				continue;
			}
			else if (aPath.isDirectory())
			{
				if (aPath.getName().endsWith(".bundle")) {
					continue;
				}
				
				File[] children = aPath.listFiles(filter);
				for (File aChild : children) 
				{
					stack.add(aChild) ;
				}
			}
			else if (aPath.isFile()) 
			{
				aPathList.add(aPath);
			}
		}
	}
	
	
	
	public void scanPath(File aPath, TreeNode<File> aPathNode)
	{
		if (aPath == null || aPathNode == null) { 
			return; 
		}
		
		if (aPath.isFile()) // it's a leaf
		{
			aPathNode.setChildren(null);
			return ;
		}
		
		if (aPath.isDirectory())
		{
			String[] relationSubPathNameList = aPath.list();
			for (int index=0 ; index<relationSubPathNameList.length; index++)
			{
				String aSubPathName = aPath.getAbsolutePath() + "/" +relationSubPathNameList[index];
				//System.out.println("Find a subPath: " + aSubPathName);
				
				File aSubPath = new File(aSubPathName);
				if (aSubPath.exists()) 
				{
					TreeNode<File> aSubPathNode = new TreeNode<File>();
					aSubPathNode.setId(aSubPathName);
					aSubPathNode.setParent(aPathNode);
					aSubPathNode.setLevel(aPathNode.getLevel() + 1);
					aSubPathNode.setContent(aSubPath);
					
					aPathNode.getChildren().add(aSubPathNode);
					
					this.scanPath(aSubPath, aSubPathNode);
				}
			}
		}
		
		return;
	}
}
