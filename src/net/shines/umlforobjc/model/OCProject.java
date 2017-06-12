package net.shines.umlforobjc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OCProject 
{
	private List<OCElement> elements;
	private Map<String, OCElement> elementMap;
	
	private List<OCRelation> relations;
	private Map<String, OCRelation> relationMap;
	
	public OCProject()
	{
		this.elements  = new ArrayList<OCElement>();
		this.elementMap = new HashMap<String, OCElement>();
		
		this.relations = new ArrayList<OCRelation>();
		this.relationMap = new HashMap<String, OCRelation>();
	}
	
	public void addElement(OCElement aElement)
	{
		if (aElement == null) {
			return;
		}
		if (this.relationMap.containsKey(aElement.getName())) {
			return;
		}
		
		this.elements.add(aElement);
		this.elementMap.put(aElement.getName(), aElement);
	}
	
	public void addRelation(OCRelation aRelation)
	{
		if (aRelation == null) {
			return;
		}
		if (aRelation.getFrom() == null || aRelation.getTo() == null) {
			System.out.println("Relation miss From or To !, name="+aRelation.getName());
			return;
		}
		
		this.relations.add(aRelation);
		this.relationMap.put(aRelation.getName(), aRelation);
		
		
		
	}
	
	public OCElement getElementByName(String name) {
		return this.elementMap.get(name);
	}
	
	public OCRelation getRelationByName(String name) {
		return this.relationMap.get(name);
	}
	
	
	
}
