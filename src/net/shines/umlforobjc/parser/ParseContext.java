package net.shines.umlforobjc.parser;

import java.util.HashMap;

import net.shines.umlforobjc.model.OCElement;
import net.shines.umlforobjc.model.OCRelation;

public class ParseContext 
{
	public HashMap<String, OCElement> elementMap;
	
	public HashMap<String, OCRelation> relationMap;
	
	public ParseContext() 
	{
		this.elementMap = new HashMap<String, OCElement>();
		this.relationMap = new HashMap<String, OCRelation>();
	}
}
