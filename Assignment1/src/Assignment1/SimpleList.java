/*
 *  Author: Jesus Aranda
 *  Class ID: 165
 *  Assignment 2
 */
package Assignment1;
import java.lang.Math;
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
			if (count < 10)
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
				count++;
				// Finally, copy the temp array into the list object.
				list = temporaryArray1.clone();
			}
			else if(count == list.length) // check to see if array is full
			{
				// calculate the percentage increase for new sized array.
				float newArraySize = (float) (count * 0.50);
				// round the new number down.
				int roundNewSize = (int) Math.floor(newArraySize);
				// set the global variable to the new size, so it can be used.
				//increasedArraySize = count + roundNewSize;
				int check = count + roundNewSize;
				// create a temporary array with 1 extra element.
				int[] temporaryArray2 = new int[check];
				// set first element of temp array to incoming integer.
				temporaryArray2[0] = num;
				// copy list into temporary array.
				System.arraycopy(list, 0, temporaryArray2, 1, count);
				// allocate new space for the array, increase the count.
				list = new int[count + roundNewSize];
				count++;
				// copy the temp array into list.
				list = temporaryArray2.clone();
			}
			else	// this else block is to fill up remaining spaces of array.
			{
				int[] temporaryArray3 = new int[count + 1];
				System.arraycopy(list, 0, temporaryArray3, 1, count);
				temporaryArray3[0] = num;
				count++;
				list = temporaryArray3.clone();
			}
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
			if (count > 1)
			{
				// check to see if the list is 25% empty.
				float check = (float) (list.length * 0.25);
				// round down the check.
				int roundDownCheck = (int) Math.floor(check);
				// calculate the empty spaces.
				int emptySpaces = list.length - count;
				if (emptySpaces > roundDownCheck)	// check to see if array is 25% empty.
				{
					// set the new decreased array size. copy original list.
					int newListSize = list.length - roundDownCheck;
					int[] tempList = new int[newListSize];
					System.arraycopy(list, 0, tempList, 0, newListSize);
					list = new int[newListSize];
					list = tempList.clone();
				}
			}
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
	
	/*
	 * The append function will append an incoming integer to the list. If the 
	 * list is full, then the function will allocate a 50% increase in the list
	 * size.
	 */
	public void append(int number)
	{
		// first check if list is full.
		if (count == list.length)
		{
			
			// calculate new simple list size.
			float arrayIncreaseBy = (float) (count * 0.50);
			// round the new number down.
			int roundArrayIncreaseBy = (int) Math.floor(arrayIncreaseBy);
			// set the global variable to the new size, so it can be used.
			int newArraySize = count + roundArrayIncreaseBy;
			int[] tempList = new int[newArraySize];
			// copy original list into tempList, and add new number at the end.
			System.arraycopy(list, 0, tempList, 0, count);
			tempList[count + 1] = number;
			// copy the tempList into original list.
			list = tempList.clone();
			count++;
		}
		else	// the list is not full.
		{
			// append the new number to the end of the list.
			list[count] = number;
			count++;
		}
	}
	/*
	 * The first function returns the first element int the list. If the 
	 * list is empty, then return -1;
	 */
	public int first()
	{
		int firstElement;
		if (count == 0)
		{
			firstElement = -1;
		}
		else
		{
			firstElement = list[0];
		}
		return firstElement;
	}
	
	/*
	 * The last function returns the last element in the list. If the list
	 * is empty, it will return -1.
	 */
	public int last()
	{
		int lastElement = 0;
		if (count == 0)
		{
			lastElement = -1;
		}
		else
		{
			for(int iterate = 0; iterate < count; iterate++)
			{
				lastElement = list[iterate];
			}
		}
		return lastElement;
	}
	
	/*
	 * The size function will return the number of possible locations in the 
	 * list. 
	 */
	public int size()
	{
		int listLength = list.length;
		int size = listLength - count;
		return size;
	}
}
