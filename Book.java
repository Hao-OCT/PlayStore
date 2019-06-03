// book class(subclass of reading)
public class Book extends Reading 
{
	// instance fields
	private String authors[];

	// the constructor
	public Book(String id, String name, double price, String publisher, String genre, int pageNumber,
			String[] authors) 
	{
		super(id, name, price, publisher, genre, pageNumber);
		this.authors = authors;
	}

	// overloading the constructor(set the price to 0 if no price entered)
	public Book(String id, String name, String publisher, String genre, int pageNumber, String[] authors) 
	{
		this(id, name, 0.0, publisher, genre, pageNumber, authors);
	}

	// override the method of returning the String type variable ContentType
	public String getContentTyoe() 
	{
		return "Book";
	}

	// override the method of adding reviews
	public void addReviews(Comment newComment) 
	{
		super.addReviews(newComment);
		System.out.println(newComment.getUser().getName() + " added review \"" + newComment.getComment()
				+ "\" on Boook " + super.getName());
	}

}
