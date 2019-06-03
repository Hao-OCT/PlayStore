// class Game which is a subclass of Content
public class Game extends Content 
{
	// instance fields
	private Boolean isMultiPlayer;
	private OS type;

	// constructor
	public Game(String id, String name, double price, Boolean isMultiPlayer, OS type) 
	{
		super(id, name, price);
		this.isMultiPlayer = isMultiPlayer;
		this.type = type;

	}

	// overloading the constructor
	public Game(String id, String name, Boolean isMultiPlayer, OS type) 
	{
		this(id, name, 0.0, isMultiPlayer, type);

	}

	// override the method of returning the String type variable name
	public String getName() 
	{
		String name = super.getName() + " for " + type.getType();
		return name;
	}

	// the method of returning the OS type variable type
	public OS getOStype() 
	{
		return this.type;
	}

	// override the method of returning the String variable ContentType
	public String getContentTyoe() 
	{
		return "Game";
	}

	// override the method of adding reviews
	public void addReviews(Comment newComment) 
	{
		super.addReviews(newComment);
		System.out.println(newComment.getUser().getName() + " added review \"" + newComment.getComment() + "\" on Game "
				+ super.getName() + " for " + this.type.getType());
	}

}
