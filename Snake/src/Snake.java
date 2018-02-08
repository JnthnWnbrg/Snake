
public class Snake
{
	SnakeJoint head;
	
	public Snake()
	{
		head = new SnakeJoint(0, 0, null, ">");
		head.follower = new SnakeJoint(0, 1, null, ">");
		head.follower.follower = new SnakeJoint
				(0, 2, null, ">");
	}
	
	public void occupySpace(String[][] jungle)
	{
		/*
		jungle[head.whichRow][head.whichColumn] = "@";
		
		for
		(
			SnakeJoint currentJoint = head.follower;
			currentJoint != null;
			currentJoint = currentJoint.follower
		)
		{
			jungle
				[currentJoint.whichRow]
				[currentJoint.whichColumn]
						= currentJoint.scaleOrientation;
		}
		*/
		
		
		for
		(
			SnakeJoint currentJoint = head;
			currentJoint != null;
			currentJoint = currentJoint.follower
		)
		{
			jungle
				[currentJoint.whichRow]
				[currentJoint.whichColumn]
						= currentJoint.scaleOrientation;
		}
	}
	
	public void moveDown()
	{
		//head.scaleOrientation = "^"; //mouth facing down
		head.pullBody();
		head.whichRow++;	
	}
	
	public void moveUp()
	{
		//head.scaleOrientation = "v";
		head.pullBody();
		head.whichRow--;	
	}
	
	public void moveRight()
	{
		//head.scaleOrientation = "<";
		head.pullBody();
		head.whichColumn++;	
	}
	
	public void moveLeft()
	{
		//head.scaleOrientation = ">";
		head.pullBody();
		head.whichColumn--;	
	}
	
	public void circle(String[][] jungle)
	{
		if
		(
				head.scaleOrientation == ">"
				 && head.whichColumn == 0
		)
		{
			head.scaleOrientation = "^";
		}
		
		if
		(
				head.scaleOrientation == "<"
				 && head.whichColumn == jungle[0].length-1
		)
		{
			head.scaleOrientation = "v";
		}
		
		if
		(
				head.scaleOrientation == "^"
				 && head.whichRow == jungle.length-1
		)
		{
			head.scaleOrientation = "<";
		}
		
		if
		(
				head.scaleOrientation == "v"
				 && head.whichRow == 0
		)
		{
			head.scaleOrientation = ">";
		}
	}
	
	public void move()
	{
		switch(head.scaleOrientation) {
		case ">":
			moveLeft();
			break;
		case "<":
			moveRight();
			break;
		case "^":
			moveDown();
			break;
		case "v":
			moveUp();
			break;
		default:
			System.out.println("IDK, it's " + 
					head.scaleOrientation);
	}
	}
}
