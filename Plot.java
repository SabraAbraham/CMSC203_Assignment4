
public class Plot {
	
	private int x, y , width, depth;
	
	public Plot()
	{
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	// copy constructor
	
	public Plot(Plot p)
	{
		this.x = p.x;
		this.y = p.y;
		this.width = p.width;
		this.depth = p.depth;
	}
	
	public Plot(int x, int y, int width, int depth)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
		
	}
	
	/*
	 * checks to see if plot being entered overlap any current property plotted
	 * */
	
	public boolean overlaps(Plot p)
	{
	
		return this.x < p.x + p.width && this.x + this.width > p.x && this.y + this.depth > p.y && this.y < p.y + p.depth;
	}

	/*
	 * checks if property plots wanted to be entered is within range
	 * */
	public boolean encompasses(Plot p)
	{
		
		boolean encompasses = false;
		
		if( (this.x + this.depth) >= p.x)
		{
			encompasses = true;
		}
		
		if( (this.y + this.width) >= p.y)
		{
		encompasses = true;
		}
		if(this.y >= (p.y + p.width))
		{
			encompasses = true;
		}
		if( (p.x + p.depth + p.width) <= this.y + this.width)
		{
	
		}
		if( (p.x + p.depth + p.width) > (this.x + this.depth + this.width)) //
		{
		encompasses = false;
		}
		
		
	if(p.x + p.depth >= this.x + this.depth + this.width && p.y + p.width <= this.x + this.depth + this.width) {
			encompasses = false;
		}
		
		if(this.x > p.x && this.x < p.x + p.depth ) 
		{
			encompasses = false;
		}
		
		if(this.x > p.x + p.depth)
		{
			encompasses = false;
		}
		
		
		
		return encompasses;
	}
	
	
	public void setX(int x) 
	{
		this.x = x;
	}
	public int getX() 
	{
		return x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	public int getY()
	{
		return y;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	public int getWidth()
	{
		return width;
	}
	
	public void setDepth(int depth)
	{
		this.depth = depth;
	}
	public int getDepth()
	{
		return depth;
	}
	
	public String toString()
	{
		return "Upper left: (" + getX() + "," + getY()
						+ "); Width: " + getWidth() + " Depth: " + getDepth();
	}
}
