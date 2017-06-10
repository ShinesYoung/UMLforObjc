package net.shines.umlforobjc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.shines.umlforobjc.tree.TreeNode;



public class FileScanner 
{
	public void scanFile(File aFile, Map<String, TreeNode<String>> classNodeMap)
	{
		if (aFile == null || aFile.exists() == false || aFile.isDirectory() || aFile.isHidden())
		{
			return;
		}
		if (classNodeMap == null)
		{
			return;
		}
		
		String declareLine = null;
		try {
			declareLine = this.scanContent(aFile);
			if (declareLine == null) {
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// parse the super class & sub class name from declared Line
		List<String> classNamePair = this.parserDeclareLine(declareLine);
		if (classNamePair == null || classNamePair.size() == 0) {
			return;
		}
		String subClassName   = classNamePair.get(0);
		String superClassName = classNamePair.get(1);
		
//		System.out.println(subClassName + ":"+ superClassName + " <--- "  +  declareLine);
		
		
		TreeNode<String> subClassNode = null;
		if (classNodeMap.containsKey(subClassName) == false) 
		{
			subClassNode = new TreeNode<String>();
			subClassNode.setContent(subClassName);
			subClassNode.setId(subClassName);
			
			classNodeMap.put(subClassNode.getContent(), subClassNode);
		}
		else 
		{
			subClassNode = classNodeMap.get(subClassName);
		}
		
		TreeNode<String> superClassNode = null;
		if (classNodeMap.containsKey(superClassName) == false) 
		{
			superClassNode = new TreeNode<String>();
			superClassNode.setContent(superClassName);
			superClassNode.setId(superClassName);
			
			classNodeMap.put(superClassNode.getContent(), superClassNode);
		}
		else 
		{
			superClassNode = classNodeMap.get(superClassName);
		}
		
		// check the subClassNode 's parent
		if (subClassNode.getParent() != null && subClassNode.getParent() != superClassNode) 
		{
			System.out.println("UnExpected Suitation, Sub Node: " + subClassName 
							+ ", Sub Node's Parent: " + subClassNode.getParent().getContent() );
			return;
		}
		else 
		{
			subClassNode.setParent(superClassNode);
		}
		
		// check the superClassNode 's children
		if (superClassNode.getChildren().contains(subClassNode) == false)
		{
			superClassNode.getChildren().add(subClassNode);
		}
		
	}
	
	public String scanContent(File aFile) throws IOException
	{
		FileInputStream fis = new FileInputStream(aFile);
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
		
		String targetLine = null;
		while (reader.ready())
		{
			String aLine = reader.readLine();
			if (aLine.startsWith("@interface")) 
			{
				targetLine = aLine;
				break;
			}
		}
		
		reader.close();
		fis.close();
		return targetLine;
	}
	
	public List<String> parserDeclareLine(String declareLine)
	{
		/**
		 * 有几种情况
		 * 1. @interface subClassName : superClassName
		 * 2. @interface subClassName : superClassName <Protocol1, Protocol2, ...>
		 * 3. @interface superClassName (category)
		 * 4. @interface superClassName (category) <Protocol1, Protocol2, ...>
		 * 
		 * 可总结为两阶段
		 * 1. 是否实现Protocol?
		 * 2. 是继承? 还是分类?
		 */
		String classNamePart = null;
		
		// 去除多余的 大括号
		int posOfBigBracket = declareLine.indexOf("{");
		if (posOfBigBracket > 0) {
			classNamePart = declareLine.substring(0, posOfBigBracket);
		} else {
			classNamePart = declareLine;
		}
		
		// 去除 Protocol 声明
		int beginOfProtocol = classNamePart.indexOf("<");
		if (beginOfProtocol > 0) {
			classNamePart = classNamePart.substring(0, beginOfProtocol);
		}
		
		// 去除 @interface 前缀
		classNamePart = classNamePart.substring(11);
		
		
		// 判断继承 和 分类
		ArrayList<String> classNamePair = new ArrayList<String>();
		int posOfColon = classNamePart.indexOf(":");
		if (posOfColon > 0) 
		{
			String[] classNameArray = classNamePart.split(":", 2);
			classNamePair.add(classNameArray[0].trim());	// add sub class
			classNamePair.add(classNameArray[1].trim());	// add super class
		}
		else 
		{
			int posOfLeftBracket  = classNamePart.indexOf("(");
			int posOfRightBracket = classNamePart.indexOf(")");
			if (posOfLeftBracket > 0 && posOfRightBracket > posOfLeftBracket)
			{
				classNamePair.add(classNamePart.substring(0, posOfRightBracket+1).trim());	// add sub class
				classNamePair.add(classNamePart.substring(0, posOfLeftBracket).trim());	// add super class
			}
			else 
			{
				System.out.println(">>>> UnExpected patter : " + declareLine);
			}
		}
		
		return classNamePair;
	}
}
