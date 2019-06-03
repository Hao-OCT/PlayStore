
public class OS 
{
	// instance fields
	private String type;
	private int versionNumber;

	// constructor
	public OS(String type, int versionNumber) 
	{
		this.type = type;
		this.versionNumber = versionNumber;
	}

	// the method of returning String type variable type
	public String getType() 
	{
		return this.type;
	}

	// the method of returning integer type variable versionNumber
	public int getVersionNumber() 
	{
		return this.versionNumber;
	}

}
