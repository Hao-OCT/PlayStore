import java.util.ArrayList;
//import the java.util.arraylist package

public class User 
{
	// instance fields
	private String userId;
	private String userName;
	private String userPhonNum;
	private double userBalance;
	private OS type;
	private Boolean premiumUser;
	private ArrayList<Content> boughtContent;
	private double discountRate;

	// constructor
	public User(String userId, String userName, String userPhonNum, double userBalance, OS type) 
	{
		this.userId = userId;
		this.userName = userName;
		this.userPhonNum = userPhonNum;
		this.userBalance = userBalance;
		this.type = type;
		this.premiumUser = false;
		this.boughtContent = new ArrayList<Content>();
		this.discountRate=0.0;
	}

	// overloading the constructor
	public User(String userId, String userName, String userPhonNum, OS type) 
	{
		this(userId, userName, userPhonNum, 0.0, type);
	}

	// the method of returning the useName
	public String getName() 
	{
		return this.userName;
	}

	// the method of returning the userID
	public String getUserId() 
	{
		return this.userId;
	}

	// the method of becoming premium user
	public void becomePremium() throws balanceException 
	{
		try 
		{
			if (this.userBalance >= 100) 
			{
				this.userBalance -= 100;
				this.premiumUser = true;
				this.discountRate=0.2;
				System.out.println(this.userName + " is now premium user!");
			} 
			else 
			{
				throw new balanceException();
			}
		} 
		catch (balanceException bE) 
		{
			System.out.println(this.userName + " cannot become premium user due to " + bE.getReasonMessage() + "! ");

		}

	}

	// the method of buying content
	public void buyContent(Content newContent) throws Exception 
	{
		try 
		{
			if (this.userBalance >= newContent.getPrice() * (1 - discountRate)) 
			{
				if (newContent instanceof Book) 
				{
					this.userBalance -= newContent.getPrice() * (1 - discountRate);
					newContent.addNumberOfDownload();
					this.boughtContent.add(newContent);
					System.out.println(this.userName + " bought " + newContent.getName());
				} 
				else if (newContent instanceof Magazine) 
				{
					this.userBalance -= newContent.getPrice() * (1 - discountRate);
					newContent.addNumberOfDownload();
					this.boughtContent.add(newContent);
					System.out.println(this.userName + " bought " + newContent.getName() + " "
							+ newContent.getClass().getSimpleName());
				} 
				else 
				{
					Game newGame = (Game) newContent;
					if (newGame.getOStype().getType().equals(this.type.getType())
							&& newGame.getOStype().getVersionNumber() <= this.type.getVersionNumber()) 
					{
						this.userBalance -= newContent.getPrice() * (1 - discountRate);
						newContent.addNumberOfDownload();
						this.boughtContent.add(newContent);
						System.out.println(this.userName + " bought " + newContent.getName());
					} 
					else 
					{
						throw new osException();
					}
				}
			} 
			else 
			{
				throw new balanceException();
			}
		} 
		catch (balanceException bE) 
		{
			System.out.println(this.userName + "cannot buy" + newContent.getName() + " "
					+ newContent.getClass().getSimpleName() + " due to " + bE.getReasonMessage() + ".");

		} 
		catch (osException oE) 
		{
			System.out.println(this.userName + " cannot buy " + newContent.getName() + " due to " + oE.getReasonMessage());
		}

	}

	// the method of showing contents that are bought
	public void showContentsBought() 
	{
		System.out.print("The contents bought by" + this.userName + " - ");
		for (int i = 0; i < boughtContent.size(); i++) 
		{
			System.out.print(" " + this.boughtContent.get(i).getName());
			if (i < boughtContent.size() - 1)
				System.out.print(", ");
		}
		System.out.println();

	}

}

// the negative balance exception
class balanceException extends Exception 
{
	String reasonMessage;

	public balanceException() 
	{
		this.reasonMessage = "insuffiecient fund";
	}

	public String getReasonMessage() 
	{
		return this.reasonMessage;
	}
}

// the OS mismatch exception
class osException extends Exception 
{
	String reasonMessage;

	public osException() 
	{
		this.reasonMessage = "OS mismatch";
	}

	public String getReasonMessage() 
	{
		return this.reasonMessage;
	}
}
