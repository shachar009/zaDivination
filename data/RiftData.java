package data;


public enum RiftData 
{
	RIFT(87306);
	
	//Every one of them is 87306
	//no need for this
	//delete later
	
	
	private int id;
	
	private RiftData(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return id;
	}

}
