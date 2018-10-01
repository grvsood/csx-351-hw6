
public class ForeignStockHolding extends StockHolding
{
	double conversionRate;
	
	//No Argument Constructor 
	public ForeignStockHolding()
	{
		// Calling of super class constructor
		super();
		conversionRate = 0.0;
	}
	
	// Constructor with arguments
	public ForeignStockHolding(double psp, double csp, int nos, String cn, double cr)
	{
		// Calling of super class constructor
		super(psp,csp,nos,cn);
		conversionRate = cr;
	}
	
	// Getters of the class to access the class instance variables
	public double getConversionRate()
	{
		return conversionRate;
	}

	//Overriding Super Class Function for making it more specific 
	public double costInDollars()
	{
		return Math.round(super.costInDollars()*getConversionRate());
	}

	//Overriding Super Class Function for making it more specific 
	public double valueInDollars()
	{
		return Math.round(super.valueInDollars()*getConversionRate());
	}
	
	// For Specifying the String Representation of class objects
	public String toString()
	{
		return "Comapany Name is: "+getCompanyName()+"\n Purchase Share Price is: "+getPurchaseSharePrice()+"\n Current Share Price is: "+getCurrentSharePrice()+"\n Number Of Shares are: "+getNumberOfShares()+"\n Conversio0n Rate is: "+getConversionRate()+"\n Cost In Dollars is: "+costInDollars()+"\n Value in Dollars is: "+valueInDollars()+"\n";
	}
}
