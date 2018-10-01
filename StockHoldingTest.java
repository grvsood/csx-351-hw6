import java.util.Scanner;
public class StockHoldingTest {
	
	//Sorting of Stocks According to their Company Names
	// Sorting Technique used is Bubble Sort
	public static void sort_By_Names(StockHolding array[])
	{
		for(int i=0;i<array.length-1;i++)
		{
			for(int j=0;j<array.length-1;j++)
			{
				if(array[j].getCompanyName().compareTo(array[j+1].getCompanyName())>0)
				{
					StockHolding temp;
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}

	//Sorting of Stocks According to their Company Names in Reverse Order
	// Sorting Technique used is Bubble Sort
	public static void reversesort_By_Names(StockHolding array[])
	{
		for(int i=0;i<array.length-1;i++)
		{
			for(int j=0;j<array.length-1;j++)
			{
				if(array[j].getCompanyName().compareTo(array[j+1].getCompanyName())<0)
				{
					StockHolding temp;
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	
	//Sorting of Stocks According to their Current Share Prices
	// Sorting Technique used is Bubble Sort
	public static void sort_By_Current_Share_Price(StockHolding array[])
	{
		for(int i=0;i<array.length-1;i++)
		{
			for(int j=0;j<array.length-1;j++)
			{
				if(array[j].currentSharePrice>array[j+1].currentSharePrice)
				{
					StockHolding temp;
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
				else if(array[j].currentSharePrice==array[j+1].currentSharePrice)
				{
					if(array[j].numberOfShares>array[j+1].numberOfShares)
					{
						StockHolding temp;
						temp = array[j];
						array[j] = array[j+1];
						array[j+1] = temp;
					}
					else if(array[j].numberOfShares==array[j+1].numberOfShares)
					{
						if(array[j].purchaseSharePrice>array[j+1].purchaseSharePrice)
						{
							StockHolding temp;
							temp = array[j];
							array[j] = array[j+1];
							array[j+1] = temp;
						}
					}
				}
			}
		}
	}
	
	//Calculating the Most Profitable and Least Profitable Stocks 
	// Returning the particular Value depending upon the integer 't'
	public static StockHolding profitable_Stock(StockHolding array[],int t)
	{
		double max_profit=0;
		double min_profit=10000000;
		double d=0;
		int j=0,k=0;
		for(int i=0;i<array.length;i++)
		{
			d=array[i].currentSharePrice-array[i].purchaseSharePrice;
			if(max_profit<d)
			{
				max_profit=d;
				j=i;
			}
			else if(max_profit==d)
			{
				if(array[i].numberOfShares>array[j].numberOfShares)
				{
					max_profit=d;
					j=i;
				}
			}
			if(min_profit>d)
			{
				min_profit=d;
				k=i;
			}
			else if(min_profit==d)
			{
				if(array[i].numberOfShares<array[j].numberOfShares)
				{
					min_profit=d;
					j=i;
				}
			}
		}
		if(t==0)
		{
			return array[k];
		}
		else
		{
			return array[j];
		}
	}
	
	public static void main(String[] args)
	{
		//Creating an Array of StockHolding Class of size 5
		StockHolding[] array = new StockHolding[5];
		
		array[0] = new StockHolding(2000.0,5000.0,5,"Reliance Jio");
		
		array[1] = new StockHolding(3000.0,8000.0,3,"HDFC Bank");
		
		array[2] = new StockHolding(5000.0,10000.0,4,"Vedanta");
		
		//Implementing Dynamic Polymorphism  by assigning the reference of Stock Holding to the object of Foreign Stock Holding
		ForeignStockHolding obj1 = new ForeignStockHolding(2482.50,5482.70,2,"Vistara",0.94);
		
		ForeignStockHolding obj2 = new ForeignStockHolding(8734,6120.70,3,"Tata",0.94);
		
		array[3] = obj1;
		
		array[4] = obj2;
		
		System.out.println("Display after Sort\n");
		
		sort_By_Names(array);
		
		//Using For Each Loop to access the array and Printing it in Increasing order of their Company Names
		for(StockHolding access : array)
		{
			System.out.printf("%s",access);
		}
		
		System.out.println("\n Display after Reverse Sort\n");
		
		reversesort_By_Names(array);

		//Using For Each Loop to access the array and Printing it in Decreasing order of their Company Names
		for(StockHolding access : array)
		{
			System.out.printf("%s",access);
		}
		
		int n;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of Stocks you want to Enter(Maximum=8): ");
		n = in.nextInt();
		
		StockHolding[] a = new StockHolding[n];
		
		int type;
		//For asking the type of the object from the User
		System.out.println("1 for Stock Holding Type");
		System.out.println("2 for Foreign Stock Holding Type");
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the type Of the Stock here: ");
			type = in.nextInt();
			double psp;
			double csp;
			int nos;
			String cn;
			double cr;
			System.out.println("Enter the Purchase Share Price here: ");
			psp=in.nextDouble();
			System.out.println("Enter the Current Share Price here: ");
			csp=in.nextDouble();
			System.out.println("Enter the Number Of Shares here: ");
			nos=in.nextInt();
			System.out.println("Enter the Company Name here: ");
			cn=in.next();
			if(type==1)
			{
				a[i] = new StockHolding(psp,csp,nos,cn);
			}
			else if(type == 2)
			{
				System.out.println("Enter the Conversion Rate here: ");
				cr=in.nextDouble();
				a[i] = new ForeignStockHolding(psp,csp,nos,cn,cr);
			}
			
		}
		sort_By_Current_Share_Price(a);
		System.out.printf("Stock Information With The Lowest Value is: %s\n", a[0]);
		System.out.printf("Stock Information With The Highest Value is: %s\n", a[n-1]);
		StockHolding most_Profitable_Stock = profitable_Stock(a,1);
		System.out.printf("Most Profitable Stock is: %s\n",most_Profitable_Stock);
		StockHolding least_Profitable_Stock = profitable_Stock(a,0);
		System.out.printf("Least Profitable Stock is: %s\n",least_Profitable_Stock);
		System.out.println("Stocks From Lowest To Highest Value are: \n");
		for(StockHolding access:a)
		{
			System.out.printf("%s\n", access);
		}
		sort_By_Names(a);
		System.out.println("Stocks Sorted By Company Name are: \n");
		for(StockHolding access:a)
		{
			System.out.printf("%s\n", access);
		}
		in.close();
	}
}
