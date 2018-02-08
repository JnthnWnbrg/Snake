
public class SnakeJoint
{
	int whichRow;
	int whichColumn;
	
	SnakeJoint follower;
	String scaleOrientation;
	
	Boolean jointHasApple;
	
	public SnakeJoint
	(
		int newWhichRow, 
		int newWhichColumn, 
		SnakeJoint newFollower,
		String newScaleOrientation
	)
	{
		this.whichRow = newWhichRow;
		this.whichColumn = newWhichColumn;
		this.follower = newFollower;
		this.scaleOrientation = newScaleOrientation;
		
		this.jointHasApple = false;
	}
	
	public void pullBody()
	{
		if(follower == null)
		{
			if(this.jointHasApple)
			{
				follower = new SnakeJoint
						(
								this.whichRow, 
								this.whichColumn, 
								null, 
								this.scaleOrientation
						);
				this.jointHasApple = false;
			}
		} else
		{
			follower.pullBody(); //recursion
			
			follower.whichRow = this.whichRow;
			follower.whichColumn = this.whichColumn;
			follower.scaleOrientation = this.scaleOrientation;
			
			/*
			//pull down
			if (follower.whichRow < this.whichRow)
			{
				follower.scaleOrientation = "^";
				follower.whichRow = this.whichRow;
			}
			
			//pull up
			if (follower.whichRow > this.whichRow)
			{
				follower.scaleOrientation = "v";
				follower.whichRow = this.whichRow;
			}
			
			//pull right
			if (follower.whichColumn < this.whichColumn)
			{
				follower.scaleOrientation = "<";
				follower.whichColumn = this.whichColumn;
			}
			
			//pull left
			if (follower.whichColumn > this.whichColumn)
			{
				follower.scaleOrientation = ">";
				follower.whichColumn = this.whichColumn;
			}
			*/
		}
	}
}
