import java.lang.Math;
public class StockHolding {
	double purchaseSharePrice;
	double currentSharePrice;
	int numberOfShares;
	String companyName;
	
	// No Argument Constructor
	public StockHolding()
	{
		purchaseSharePrice = 0.0;
		currentSharePrice = 0.0;
		numberOfShares = 0;
		companyName = null;
	}

	// Constructor with arguments
	public StockHolding(double psp, double csp, int nos, String cn)
	{
		purchaseSharePrice = psp;
		currentSharePrice = csp;
		numberOfShares = nos;
		companyName = cn;
	}

	//getters for the class instance variables
	public double getPurchaseSharePrice()
	{
		return purchaseSharePrice;
	}
	
	public double getCurrentSharePrice()
	{
		return currentSharePrice;
	}
	
	public int getNumberOfShares()
	{
		return numberOfShares;
	}
	
	public String getCompanyName()
	{
		return companyName;
	}
	
	//Setters of the class for class instance variables
	public void setPurchaseSharePrice(double psp)
	{
		purchaseSharePrice = psp;
	}
	
	public void setCurrentSharePrice(double csp)
	{
		currentSharePrice = csp;
	}
	
	public void setNumberOfShares(int nos)
	{
		numberOfShares = nos;
	}
	
	public void setCompanyName(String cn)
	{
		companyName = cn;
	}
	
	//Calculating Cost in Dolllars
	public double costInDollars()
	{
		return Math.round(purchaseSharePrice*numberOfShares);
	}

	//Calculating Value in Dolllars
	public double valueInDollars()
	{
		return Math.round(currentSharePrice*numberOfShares);
	}
	
	//To Specify the String Representation of class objects
	public String toString()
	{
		return "Comapany Name is: "+getCompanyName()+"\n Purchase Share Price is: "+getPurchaseSharePrice()+"\n Current Share Price is: "+getCurrentSharePrice()+"\n Number Of Shares are: "+getNumberOfShares()+"\n Cost In Dollars is: "+costInDollars()+"\n Value in Dollars is: "+valueInDollars()+"\n";
	}
}
