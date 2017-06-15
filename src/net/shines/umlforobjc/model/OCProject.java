package net.shines.umlforobjc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.shines.umlforobjc.parser.ParseContext;

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
	
	public void config(ParseContext context)
	{
		this.elementMap.clear();
		this.elementMap.putAll(context.elementMap);
		this.relationMap.clear();
		this.relationMap.putAll(context.relationMap);
		
		this.elements.clear();
		this.elements.addAll(context.elementMap.values());
		this.relations.clear();
		this.relations.addAll(context.relationMap.values());
		
//		for (int row=0; row<50; row++ ) 
//		{
//			for (int col=0; col<50; col++) 
//			{
//				int eleIndex = row * 50  + col;
//				if (eleIndex < this.elements.size()) 
//				{
//					OCElement aEle = this.elements.get(eleIndex);
//					aEle.setCenterX(250 + col * 200);
//					aEle.setCenterY(250 + row * 200);
//				}
//			}
//		}
		
		HashMap<String, OCElement> arrivedMap = new HashMap<String, OCElement>();
		
		int deep = 0;
		OCElement appDelegate = this.elementMap.get("AppDelegate");
		deep = this.setElementsCenter(appDelegate, arrivedMap, deep);
		
		for (OCElement aEle : this.elements) 
		{
			if (arrivedMap.containsKey(aEle.getName()) ==false) {
				deep = this.setElementsCenter(aEle, arrivedMap, deep);
			}
		}
		
		System.out.println("deep = "+deep);
	}
	
	public int setElementsCenter(OCElement startEle, Map<String, OCElement> arrivedMap, int deep)
	{
		ArrayList<OCElement> currentElementBatch = new ArrayList<OCElement>();
		currentElementBatch.add(startEle);

		ArrayList<OCElement> nextElementBatch = new ArrayList<OCElement>();
		
		while (currentElementBatch.isEmpty() == false)
		{
			int offset = 0;
			for(int index=0; index<currentElementBatch.size(); index ++)
			{
				OCElement aEle = currentElementBatch.get(index);
				
				if (arrivedMap.containsKey(aEle.getName())) {
					offset +=1;
					continue;
				}
				
				aEle.setCenterX(250 + deep* 500);
				aEle.setCenterY(250 + (index-offset)* 200);
				arrivedMap.put(aEle.getName(), aEle);
				
				nextElementBatch.addAll(aEle.getOutElements());
			}
			
			currentElementBatch.clear();
			currentElementBatch.addAll(nextElementBatch);
			nextElementBatch.clear();
			deep += 1;
		}
		
		return deep;
	}
	
	public OCElement getElementByName(String name) {
		return this.elementMap.get(name);
	}
	
	public OCRelation getRelationByName(String name) {
		return this.relationMap.get(name);
	}

	public List<OCElement> getElements() {
		return elements;
	}
	public void setElements(List<OCElement> elements) {
		this.elements = elements;
	}

	public List<OCRelation> getRelations() {
		return relations;
	}
	public void setRelations(List<OCRelation> relations) {
		this.relations = relations;
	}
	
	
	
}
