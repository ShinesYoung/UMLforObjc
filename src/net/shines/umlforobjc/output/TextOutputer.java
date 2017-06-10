package net.shines.umlforobjc.output;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import net.shines.kitbox.file.FileUtils;
import net.shines.umlforobjc.tree.TreeNode;

public class TextOutputer extends BaseOutputer
{
	
	public enum PathType {
		AbsolutePath,
		RelativePath,
		FileName,
	}
	
	public void outputTreeList(File outputFile, List<TreeNode<String>> rootNodeList)
	{
		StringBuilder outputBuff = new StringBuilder();
		
		ArrayList<TreeNode<String>> stack = new ArrayList<TreeNode<String>>();
		
		for (TreeNode<String> aRootNode : rootNodeList) 
		{
			stack.add(aRootNode);
		}
		
		while (stack.size() > 0) 
		{
			int lastObjectIndex = stack.size() - 1;
			TreeNode<String> lastNode = stack.remove(lastObjectIndex);
			
			StringBuilder buff = new StringBuilder();
			
			if (lastNode.getLevel() == 0) {
				buff.append("\r\n");
			}
			
			for (int i=0; i<lastNode.getLevel(); i++)
			{
				if (i == lastNode.getLevel() -1) {
					buff.append("        +-------");
				} else {
					buff.append("                ");
				}
				
			}
			buff.append(lastNode.getContent());
			buff.append("\r\n");
			
			outputBuff.append(buff);
			System.out.print(buff);
			
			if (lastNode.isLeafNode() == false)
			{
				for (TreeNode<String> aChildNode: lastNode.getChildren())
				{
					stack.add(aChildNode);
				}
			}
		}
		
		String outputText = outputBuff.toString();
		
		FileUtils.writeToFile(outputFile, outputText);
	}
	
	public void outputList(File outputFile, List<File> fileList)
	{
		fileList.sort(new Comparator<File>() {

			@Override
			public int compare(File f1, File f2) 
			{
				return f1.getName().compareTo(f2.getName());
			}
		});
		
		StringBuilder outputBuff = new StringBuilder();
		
		for (File aFile : fileList) {
			outputBuff.append(aFile.getAbsolutePath())
					.append("(").append(aFile.length()/1024).append("k)").append("\r\n");
//			outputBuff.append(aFile.getName()).append("\r\n");
		}
		
		String outputContent = outputBuff.toString();;
		FileUtils.writeToFile(outputFile, outputContent);
	}
	
	
	
	
}
