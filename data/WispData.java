package data;


public enum WispData 
{
	PALEWISP(18150,29384,29395),
	FLICKERINGWISP(18151,29385,29396),
	BRIGHTWISP(18153,29386,29397),
	GLOWINGWISP(18155,29387,29398),
	SPARKLINGWISP(18157,29388,29399),
	GLEAMINGWISP(18159,29389,29400);
	
	
	
	private int id;
	//private int enrichedId;
	private int itemId;
	private int enrichedItemId;

	
	private WispData(int id, int itemId, int enrichedItemId)
	{
		this.id = id;
		this.itemId = itemId;
		this.enrichedItemId = enrichedItemId;
	}
	
	public int getId()
	{
		return id;
	}
	
	public int[] getItemIds()
	{
		return new int[]{itemId,enrichedItemId};
	}

}
