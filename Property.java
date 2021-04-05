
public class Property {
	
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot; 
	
	
	public Property()
	{
		city = "";
		owner = "";
		propertyName = "";
		rentAmount = 0;
		plot = new Plot();
	}
	
	public Property(Property p)
	{
		// copy constructor
		// creates new object using info of the object passed to it
		this.propertyName = p.propertyName;
		this.city = p.city;
		this.rentAmount = p.rentAmount;
		this.owner = p.owner;
	
		plot = new Plot();
		
		
	}
	public Property(String propertyName, String city, double rentAmount, String owner)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		
		plot = new Plot();
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		
		plot = new Plot(x,y,width,depth);
		
	}
	
	
	
	public String getCity()
	{
		return city;
	}
	public String getOwner()
	{
		return owner;
	}
	public String getPropertyName()
	{
		return propertyName;
	}
	public double getRentAmount()
	{
		return rentAmount;
	}
	
	
	public void setCity(String city)
	{
		this.city = city;
	}
	public void setOwner(String owner)
	{
		this.owner = owner;
	}
	public void setPropertyName(String propertyName)
	{
		this.propertyName = propertyName;
	}
	
	public void setRentAmount(double rentAmount)
	{
		this.rentAmount= rentAmount;
	}

	public Plot getPlot()
	{
		return plot;
		
	}
	
	public String toString()
	{
		return "Property Name: " + getPropertyName() + "\nCity: " 
				+ getCity() + "\nRent Amount: " + getRentAmount() + "\nOwner: " 
				+ getOwner(); 
		// display x, y, width, depth?
		
	}

}
