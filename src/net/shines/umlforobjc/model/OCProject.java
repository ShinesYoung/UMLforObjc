package net.shines.umlforobjc.model;

import java.util.ArrayList;
import java.util.List;

import net.shines.umlforobjc.model.object.OCClass;
import net.shines.umlforobjc.model.object.OCProtocol;
import net.shines.umlforobjc.model.relation.OCImplement;
import net.shines.umlforobjc.model.relation.OCInherit;
import net.shines.umlforobjc.model.relation.OCReference;

public class OCProject 
{
	private List<OCClass>    classList;
	private List<OCProtocol> protocolList;
	
	private List<OCImplement> implementList;
	private List<OCReference> referenceList;
	private List<OCInherit>   inheritList;
	
	public OCProject()
	{
		this.classList     = new ArrayList<OCClass>();
		this.protocolList  = new ArrayList<OCProtocol>();
		this.implementList = new ArrayList<OCImplement>();
		
		this.referenceList = new ArrayList<OCReference>();
		this.inheritList   = new ArrayList<OCInherit>();
	}
	
	public void addElement(OCElement aElement)
	{
		if (aElement instanceof OCClass) 
		{
			this.classList.add((OCClass)aElement);
		}
		else if (aElement instanceof OCProtocol) 
		{
			this.protocolList.add((OCProtocol)aElement);
		}
	}
	
	public void addRelation(OCRelation aRelation)
	{
		if (aRelation instanceof OCImplement) 
		{
			this.implementList.add((OCImplement)aRelation);
		}
		else if (aRelation instanceof OCReference) 
		{
			this.referenceList.add((OCReference)aRelation);
		}
		else if (aRelation instanceof OCInherit) 
		{
			this.inheritList.add((OCInherit)aRelation);
		}
	}
	
	public List<OCClass> getClassList() {
		return classList;
	}
	public void setClassList(List<OCClass> classList) {
		this.classList = classList;
	}

	public List<OCProtocol> getProtocolList() {
		return protocolList;
	}
	public void setProtocolList(List<OCProtocol> protocolList) {
		this.protocolList = protocolList;
	}

	public List<OCImplement> getImplementList() {
		return implementList;
	}
	public void setImplementList(List<OCImplement> implementList) {
		this.implementList = implementList;
	}

	public List<OCReference> getReferenceList() {
		return referenceList;
	}
	public void setReferenceList(List<OCReference> referenceList) {
		this.referenceList = referenceList;
	}

	public List<OCInherit> getInheritList() {
		return inheritList;
	}
	public void setInheritList(List<OCInherit> inheritList) {
		this.inheritList = inheritList;
	}
	
	
	
}
