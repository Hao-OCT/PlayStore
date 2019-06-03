import java.util.*;
//import the whole java.util package

public class Comment 
{
	// instance fields
	private User user;
	private String comment;
	private ArrayList<Comment> reply;

	// constructor
	public Comment(User user, String comment) 
	{
		this.user = user;
		this.comment = comment;
		this.reply = new ArrayList<Comment>();

	}

	// the method of returning the 'user' object which is in the User type
	public User getUser() 
	{
		return this.user;
	}

	// the method of returning the String variable 'comment'
	public String getComment() 
	{
		return this.comment;
	}

	// the method of adding reply to the comment
	public void addReply(Comment newReply) 
	{
		this.reply.add(newReply);
		System.out.println(this.user.getName() + " replies \"" + newReply.getComment() + "\"");
	}

	// the method of showing reply about the comment
	public void showReply(int times) 
	{
		if (this.reply.isEmpty()) 
		{
		}

		else 
		{
			for (int j = 0; j <= times; j++)
				System.out.print("	");
			for (int i = 0; i < this.reply.size(); i++) 
			{
				System.out.println(this.reply.get(i).getUser().getName() + " ("
						+ this.reply.get(i).getUser().getUserId() + ") " + " : " + this.reply.get(i).getComment());
				this.reply.get(i).showReply(times + 1);
			}
		}

	}
}
