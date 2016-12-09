package structure;
import java.util.ArrayList;

//Data structure that corresponds to the Policy
public class Policy {
	
	private ArrayList<String> modules;
	private ArrayList<PoLClass> clazzes;
	private String construct;
	
	public Policy()
	{
		modules = new ArrayList<String>();
		clazzes = new ArrayList<PoLClass>();
	}
	
	public void addModule(String module)
	{
		modules.add(module);
	}

	public ArrayList<String> getModules() {
		return modules;
	}

	public void addClass(PoLClass clazz)
	{
		clazzes.add(clazz);
	}
	
	public void setModules(ArrayList<String> modules) {
		this.modules = modules;
	}

	public ArrayList<PoLClass> getClazz() {
		return clazzes;
	}

	public String getConstruct() {
		return construct;
	}

	public void setConstruct(String construct) {
		this.construct = construct;
	}
	
	
	
}
