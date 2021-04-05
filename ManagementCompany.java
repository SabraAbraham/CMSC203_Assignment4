import java.util.Arrays;

import javafx.scene.layout.Region;

public class ManagementCompany {
	private String name;
	private String taxID;
	private Property[] properties;
	private double mgmFeePer;
	private final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private Plot plot;
	
	public ManagementCompany()
	{
		name = "";
		taxID = "";
		mgmFeePer = 0;
		plot = new Plot(0,0,MGMT_WIDTH, MGMT_DEPTH);
		
		properties = new Property[MAX_PROPERTY];
		
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee) // constructor of 3 parameters
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		
		plot = new Plot(0,0,MGMT_WIDTH, MGMT_DEPTH);
		
		properties = new Property[MAX_PROPERTY];

	}
	// constructor of 7 parameters
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		
		plot = new Plot(x,y,width,depth);
		
		properties = new Property[MAX_PROPERTY];

	}
	
	// constructor with Management company object as parameter
	public ManagementCompany(ManagementCompany otherCompany)
	{
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.plot = otherCompany.plot;
		properties = new Property[MAX_PROPERTY];

	}
	
	
	//returns maximum properties allowed (length of array)
	public int getMAX_PROPERTY()
	{
		return MAX_PROPERTY;
	}
	
	/*
	 * checks if property array is full, if property being added is null,
	 * plots are not within the range, or if plot overlaps an already existing property
	 */
	public int addProperty(Property property) //
{
		
		
		if(property == null)
		{
			return -2;
		}
		
		if(!plot.encompasses(property.getPlot()))
		{
			return -3; 
			
		}                
	
		for(int i = 0; i < properties.length; i++)
		{
			if(properties[i] != null)
			{
				if(property.getPlot().overlaps(properties[i].getPlot()))
				{
					return -4;
				}
			}
				else
				{
					properties[i] = property;
					return  i;// adding property to array at index i
				}

		}
		return -1;
	}
	
	/*
	 * checks if property array is full, if property being added is null,
	 * plots are not within the range, or if plot overlaps an already existing property
	 * */
	public int addProperty(String name, String city, double rent, String owner)
	{
		
		Property add_property = new Property(name, city, rent, owner,0, 0, 1, 1);
		
		return addProperty(add_property);
	
	}
	
	/*
	 * checks if property array is full, if property being added is null,
	 * plots are not within the range, or if plot overlaps an already existing property
	 * */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth)
	{
		Property add_property = new Property(name, city, rent, owner, x, y, width, depth);
		
		return addProperty(add_property);
 
	}
	
	public double totalRent() // calculates all rents from each property in the array
	{
		double total = 0;
		
		for(int i = 0; i < properties.length; i++)
		{
			if(!(properties[i] == null))
				total += properties[i].getRentAmount(); // add each rent to total
		}

		return total;
	}
	
	public double maxRentProp() // finds the highest rent in the property array
	{
		double max = properties[0].getRentAmount();
		
		//repeat this for loop until max rent is found or property is null
		//if null exit this method
		for(int i = 0; i < properties.length; i++)
		{
			if(!(properties[i] == null))
				if(properties[i].getRentAmount() > max) //if rent amount is greater than current max
					max = properties[i].getRentAmount(); //then declare it as new max
		}
		return max;
	}
	
	public int maxRentPropertyIndex() // finds the highest rent in the property array and returns the index
	{
		double max = maxRentProp();
	
		int result = 0;
		
		for(int i = 0; i < properties.length; i++)
		{
			if(!(properties[i] == null))
				if(properties[i].getRentAmount() == max)
					result = i;
					
		}
		return result;
	}
	
	public void setTaxID(String taxID)
	{
		taxID = "";
	}
	public String getTaxID()
	{
		return taxID;
	}
	public void setName(String name)
	{
		name = "";
	}
	public String getName()
	{
		return name;
	}
	
	public String displayPropertyAtIndex(int i)
	{
	
		return properties[i].toString();
	}
	
	public String toString() //displays list of properties
	{
	
		return	"List of the properties for " + getName() + ", taxID: " + getTaxID()  
		+ "\n" + properties[0].toString() + "\n" + properties[1].toString()
				+ "\n" + properties[2].toString() + "\n" + properties[3].toString()
				+ "\n" + properties[4].toString() + "\n\n" + "Total management Fee: " + 
				(totalRent() * mgmFeePer) / 100;
		

	}

	public Plot getPlot() 
	{
		return plot;
	}
	
	
	
}


