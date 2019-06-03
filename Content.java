import java.util.*;
//import the whole java.util package

public abstract class Content 
{
	// instance fields
	private String id;
	private String name;
	private int numberOfDownload;
	private double price;
	private ArrayList<Comment> review;

	// constructor
	public Content(String id, String name, double price) 
	{
		this.id = id;
		this.name = name;
		this.numberOfDownload = 0;
		this.price = 0;
		this.review = new ArrayList<Comment>();

	}

	// the method of returning the String type variable 'name'
	public String getName() 
	{
		return this.name;
	}

	// the method of returning the double type variable 'price'
	public double getPrice() 
	{
		return this.price;
	}

	// the method of returning the String type variable 'Content'
	public abstract String getContentTyoe();

	// the method of getGenre. 'null' is due to the Content do not have this variable
	public String getGenre() 
	{
		return null;
	}

	// the method of adding the number of download
	public void addNumberOfDownload() 
	{
		this.numberOfDownload += 1;
	}

	// the method of adding the reviews to the comment
	public void addReviews(Comment newComment) 
	{
		this.review.add(newComment);
	}

	// the method of printing all reviews
	public void printAllReview() 
	{
		System.out.println("The reviews of " + this.getClass().getSimpleName() + " " + this.getName() + " - ");
		for (int i = 0; i < this.review.size(); i++) 
		{
			System.out.println(this.review.get(i).getUser().getName() + " (" + this.review.get(i).getUser().getUserId()
					+ ") :" + this.review.get(i).getComment());
			this.review.get(i).showReply(0);
		}

	}

}


// abstract class reading (subclass of content)
abstract class Reading extends Content 
{
	// instance fields
	private String publisher;
	private String genre;
	private int pageNumber;

	// constructor
	public Reading(String id, String name, double price, String publisher, String genre, int pageNumber) 
	{
		super(id, name, price);
		this.publisher = publisher;
		this.genre = genre;
		this.pageNumber = pageNumber;
	}

	// the method of returning the String type variable genre
	public String getGenre() 
	{
		return this.genre;
	}
}