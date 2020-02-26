/*
 *  Author: Jesus Aranda
 *  Class ID: 165
 *  Assignment 1
 */
package Assignment1;

/*
 * The SimpleList class will instantiate an object of SimpleList. 
 * The class has two private instance variables; an integer array named
 * list, and an integer named count. List will hold 10 integers and
 * count will be initiated 0. After integers are added to list, count will
 * keep count of entries added. There are different methods in the class 
 * that will add, remove, search, return count and return toString.
 */
public class SimpleList {
	private int[] list;
	private int count;
	
	/*
	 * Create an Object of SimpleList, length 10 with initial count to 0.
	 */
	public SimpleList()
	{
		list = new int[10];
		count = 0;
	}
	
	/*
	 * This function will add numbers into the list and shift accordingly.
	 * It will also reflect the count of numbers in the list.
	 */
	public void add(int num)
	{
		// First condition, check to see if the list is empty.
		if(list[0] == 0)
		{
			// List is empty, add the first number into the list.
			list[0] = num;
			// Increment the count by one.
			count++;
		}
		else			// list is not empty.
		{
			// Create a temp array to handle the shifting of numbers.
			int[] temporaryArray1 = new int[list.length];
			/*
			 * Copy the contents of the original list from position 1
			 * to the end of the list and place it into the temp array.
			 */
			System.arraycopy(list, 0, temporaryArray1, 1, 9);
			// Set first element of temp array to the new added number.
			temporaryArray1[0] = num;
			// Increment count if count is below 10. 
			if (count < 10)
			{
				count++;
			}
			// Finally, copy the temp array into the list object.
			list = temporaryArray1.clone();
		}
	}
	
	/*
	 * The remove() function will remove a number in the list and 
	 * decrement the count.
	 */
	public void remove(int toRemove)
	{
		// Search for the position of the number to be deleted.
		int position = search(toRemove);
		if (position == -1)
		{
			// do nothing, number is not in list.
		}
		else
		{
			// Iterate through the list starting from position element.
			for(int loop = position; loop <= count - position; loop++)
			{
				// Copy the adjacent element into the previous element. 
				list[loop] = list[loop + 1];
			}
			// Decrement the count.
			count--;
		}
	}
	
	/*
	 * The count() method will return an integer representing how many 
	 * numbers are in the list.
	 */
	public int count()
	{
		return count;
	}
	
	/*
	 * The toString() method will create a string and return a string 
	 * that represents the list of numbers. Between each number a 
	 * space is placed for easy readout.
	 */
	public String toString()
	{
		// create the string.
		String str = "";
		// iterate through the list.
		for(int loop = 0; loop < list.length; loop++)
		{
			// logic to decided whether a space is placed or not.
			// regardless, numbers from the list are put into str.
			if (loop < list.length - 1)
			{
				str += list[loop] + " ";
			}
			else
			{
				str += list[loop];
			}
		}
		return str;
	}
	
	/*
	 * The search() method will take a number as input and search for
	 * the first occurrence in the list of integers. If the integer
	 * to be searched for is not in the list, then -1 will be returned.
	 */
	public int search(int toSearch)
	{
		// set the position to be -1 automatically.
		int position = -1;
		// iterate through the list to look for integer.
		for(int loop = 0; loop <= count; loop++)
		{
			// logic to find first occurrence in list.
			if(toSearch == list[loop])
			{
				// set position to the array position.
				position = loop;
				// break out of the loop. First, occurrence found.
				break;
			}
		}
		return position;
	}
}
