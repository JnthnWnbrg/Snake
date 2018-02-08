
public class Driver 
{
	
	public static void main(String[] args) 
	{
		// [y][x]
		//int[][] jungle = { {1, 2, 3}, {4, 5, 6, 7}};
		String[][] jungle = new String[4][4];
		clearArray(jungle);
		printArray(jungle);
		
		Snake player = new Snake();
		player.occupySpace(jungle);
		printArray(jungle);
		
		while(true)
		{
			try {
				Thread.sleep(500);
				player.circle(jungle);
				player.occupySpace(jungle);
				printArray(jungle);
				Thread.sleep(500);
				player.move();
				clearArray(jungle);
				player.occupySpace(jungle);
				printArray(jungle);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void clearArray(String[][] array)
	{
		for
		(
				int whichRow = 0; 
				whichRow < array.length;
				whichRow++
		) 
		{
			for
			(
				int whichColumn = 0;
				whichColumn < array[whichRow].length;
				whichColumn++
			)
			{
				array[whichRow][whichColumn] = "+";
			}
		}
	}
	
	public static void printArray(String[][] array)
	{
		System.out.println("length is " + array.length);
		for
		(
				int whichRow = 0; 
				whichRow < array.length;
				whichRow++
		) 
		{
			for
			(
					int whichColumn = 0; 
					whichColumn < array[whichRow].length; 
					whichColumn++
			) 
			{
				System.out.print(array[whichRow][whichColumn]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
