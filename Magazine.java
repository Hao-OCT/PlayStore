
// class magazine(subclass of reading)
public class Magazine extends Reading 
{
	// instance fields
	private String feature;

	// constructor
	public Magazine(String id, String name, double price, String publisher, String genre, int pageNumber,
			String feature) 
	{
		super(id, name, price, publisher, genre, pageNumber);
		this.feature = feature;
	}

	// overloading the constructor
	public Magazine(String id, String name, String publisher, String genre, int pageNumber, String feature) 
	{
		this(id, name, 0.0, publisher, genre, pageNumber, feature);
	}

	// override the String type variable ContentType
	public String getContentTyoe() 
	{
		return "Magazine";
	}

	// override the method of adding reviews
	public void addReviews(Comment newComment) 
	{
		super.addReviews(newComment);
		System.out.println(newComment.getUser().getName() + " added review \"" + newComment.getComment()
				+ "\" on Magazine " + super.getName());
	}
	
}
