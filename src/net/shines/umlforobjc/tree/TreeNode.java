package net.shines.umlforobjc.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> 
{
	private TreeNode<T>       parent;
	private List<TreeNode<T>> children;
	private int               level;
	private String            id;
	private T                 content;
	
/***************************************************************************/
/**** Construction                                                      ****/
/***************************************************************************/
	
	public TreeNode()
	{
		this.children = new ArrayList<TreeNode<T>>();
	}
	
	
	
/***************************************************************************/
/**** Check Node Type                                                   ****/
/***************************************************************************/
	
	public boolean isLeafNode() 
	{
		return (this.children == null || this.children.size() == 0) ? 
				true : false;
	}
	public boolean isRootNode() 
	{
		return (this.parent == null) ? true : false;
	}
	
	
	
/***************************************************************************/
/**** Getter & Setter                                                   ****/
/***************************************************************************/
	
	public TreeNode<T> getParent() {
		return parent;
	}
	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}
	public List<TreeNode<T>> getChildren() {
		return children;
	}
	public void setChildren(List<TreeNode<T>> children) {
		this.children = children;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public T getContent() {
		return content;
	}
	public void setContent(T content) {
		this.content = content;
	}
	
	
}
