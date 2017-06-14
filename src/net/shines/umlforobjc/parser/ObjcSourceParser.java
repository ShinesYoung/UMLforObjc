package net.shines.umlforobjc.parser;

import net.shines.umlforobjc.model.OCElement;
import net.shines.umlforobjc.model.OCRelation;
import net.shines.umlforobjc.model.object.OCClass;
import net.shines.umlforobjc.model.relation.OCReference;

public class ObjcSourceParser 
{
	public void parse(String fileName, String sourceContent, ParseContext context)
	{
		int posOfDot = fileName.indexOf(".");
		if (posOfDot >= 0) 
		{
			fileName = fileName.substring(0, posOfDot);
		}
		
		OCElement aFromEle = null;
		if (context.elementMap.containsKey(fileName)) { 
			aFromEle = context.elementMap.get(fileName);
		} else {
			aFromEle = new OCClass();
			aFromEle.setName(fileName);
			aFromEle.setRadius(50);
			context.elementMap.put(fileName, aFromEle);
		}
		
		String[] lines = sourceContent.split("\n");
		for (String aLine : lines) 
		{
			aLine = aLine.trim();
			
			if ("".equals(aLine)) {
				continue;
			}
			if (aLine.startsWith("//")) {
				continue;
			}
			if (aLine.startsWith("#import")) 
			{
				String aObjName = aLine.substring(7, aLine.length());
				aObjName = aObjName.trim();
				aObjName = aObjName.substring(1, aObjName.length() -1);
				if (aObjName.endsWith(".h")) {
					aObjName = aObjName.substring(0, aObjName.length() -2);
				}
				
				if ("UIKit/UIKit".equals(aObjName)) {
					continue;
				}
				if ("Foundation/Foundation".equals(aObjName)) {
					continue;
				}
				if ("Masonry/Masonry".equals(aObjName)) {
					continue;
				}
				if (aObjName.equals(aFromEle.getName())) {
					continue;
				}
				
				OCElement aToEle = null;
				if (context.elementMap.containsKey(aObjName)) {
					aToEle = context.elementMap.get(aObjName);
				} 
				else {
					aToEle = new OCClass();
					aToEle.setName(aObjName);
					aToEle.setRadius(50);
					context.elementMap.put(aObjName, aToEle);
				}
				
				String refName = "Ref:"+aFromEle.getName() + "->" +aToEle.getName();
				OCRelation aRel = null;
				if (context.relationMap.containsKey(refName)) {
					aRel = context.relationMap.get(refName);
				}
				else {
					aRel = new OCReference();
					aRel.setFrom(aFromEle);
					aRel.setTo(aToEle);
					aRel.setName(refName);
					
					context.relationMap.put(refName, aRel);
					System.out.println("New "+refName);
				}
			}
			if (aLine.startsWith("@end")) {
				break;
			}
		}
	}
	
}
