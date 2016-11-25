// Data structure that corresponds to Policy Class
package structure;

import java.util.ArrayList;

public class PoLClass {
	
	private String className;
	private ArrayList<String> fields;
	
	public PoLClass()
	{
		fields = new ArrayList<String>();
	}
	
	public void addField(String name)
	{
		fields.add(name);
	}
	
	public void setClassName(String className)
	{
		this.className = className;
	}
	
	public String getClassName()
	{
		return className;
	}
	
	public ArrayList<String> getFields()
	{
		return fields;
	}
}
