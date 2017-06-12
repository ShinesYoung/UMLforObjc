package net.shines.umlforobjc;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.shines.umlforobjc.output.TextOutputer;
import net.shines.umlforobjc.scanner.PathScanner;
import net.shines.umlforobjc.tree.TreeNode;

public class CodeScanner 
{
	private List<File> pathList;
	
	private Map<String, TreeNode<String>> classNodeMap;
	
	private List<TreeNode<String>> rootNodeList;
	private List<File> largeFileList;
	
	private PathScanner dirScanner = null;
	private FileScanner fileScanner = null;
	private TextOutputer outputer = null;
	
	
	public void scan(String strScanPath)
	{
		File rootPath = new File(strScanPath);
		if (rootPath.exists() == false) 
		{
			return;
		}
				
		this.pathList = new ArrayList<File>();
		this.dirScanner = new PathScanner();
		this.dirScanner.scanPath(rootPath, this.pathList, null);
		
		System.out.println("Directory scanning over.");
		
		ArrayList<File> headFileList = new ArrayList<File>();
		for (File aPath : this.pathList)
		{
			if (aPath.exists() == false || aPath.isDirectory() || aPath.isHidden()) {
				continue;
			}
			if (aPath.getName().endsWith(".h") == false) {
				continue;
			}
			
			//System.out.println(aPath.getAbsolutePath());
			headFileList.add(aPath);
		}
		
		System.out.println("header files count: " + headFileList.size());
		
		this.classNodeMap = new HashMap<String, TreeNode<String>>();
		
		TreeNode<String> vcClassNode = new TreeNode<String>();
		vcClassNode.setId("UIViewController");
		vcClassNode.setContent("UIViewController");
		vcClassNode.setParent(null);
		vcClassNode.setLevel(0);
		
		this.classNodeMap.put(vcClassNode.getContent(), vcClassNode);
		
		TreeNode<String> objectClassNode = new TreeNode<String>();
		objectClassNode.setId("NSObject");
		objectClassNode.setContent("NSObject");
		objectClassNode.setParent(null);
		objectClassNode.setLevel(0);
		
		this.classNodeMap.put(objectClassNode.getContent(), objectClassNode);
		
		TreeNode<String> vClassNode = new TreeNode<String>();
		vClassNode.setId("UIView");
		vClassNode.setContent("UIView");
		vClassNode.setParent(null);
		vClassNode.setLevel(0);
		
		this.classNodeMap.put(vClassNode.getContent(), vClassNode);
		
				
		this.fileScanner = new FileScanner();
		for (File aHeaderFile : headFileList)
		{
			this.fileScanner.scanFile(aHeaderFile, this.classNodeMap);
		}
		
		this.rootNodeList = new ArrayList<TreeNode<String>>();
		for (String aKey : this.classNodeMap.keySet())
		{
			TreeNode<String> aClassNode = this.classNodeMap.get(aKey);
			if (aClassNode.isRootNode()) 
			{
				this.rootNodeList.add(aClassNode);
			}
		}
		
		for (TreeNode<String> aRootNode : this.rootNodeList)
		{
			this.calcChildrenLevel(aRootNode);
		}
		
		System.out.println("file scanning over. classNode's size ="+this.classNodeMap.size());
		System.out.println("file scanning over. rootNode's size ="+this.rootNodeList.size());
		
	}
	
	public void output()
	{
		File outputFile = new File("output/largeResource.txt");
		this.outputer.outputList(outputFile, this.largeFileList);
	}
	
	public void calcChildrenLevel(TreeNode<String> aNode)
	{
		if (aNode.isLeafNode() == false) 
		{
			for (TreeNode<String> aChild : aNode.getChildren())
			{
				aChild.setLevel(aNode.getLevel() + 1);
				this.calcChildrenLevel(aChild);
			}
		}
	}
	
	
	public void scanLargeFile(String strScanPath)
	{
		File rootPath = new File(strScanPath);
		if (rootPath.exists() == false) 
		{
			return;
		}
				
		this.pathList = new ArrayList<File>();
		this.dirScanner = new PathScanner();
		this.dirScanner.scanPath(rootPath, this.pathList, null);
		
		System.out.println("Directory scanning over.");
		
		this.largeFileList = new ArrayList<File>();
		for (File aPath : this.pathList)
		{
			if (aPath.exists() == false || aPath.isDirectory() || aPath.isHidden()) {
				continue;
			}
			if (aPath.length() > 1024 * 300) 
			{
				this.largeFileList.add(aPath);
			}
			
		}
	}
}
