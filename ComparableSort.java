/** Class with a utility method for sorting a Comparable array
	using the bubble sort algorithm.
	
	The information inside the < > brackets can be interpreted
	as "When we create an instance of this class, we'll tell Java
	we want that instance to sort objects of a specific class 
	(referred to here as SomeType) AND that class must be one 
	that implements Comparable."

	@author Andrew McAllister
*/
public class ComparableSort <SomeType extends Comparable<SomeType>>
{  
  	/*	NOTE: This class defines no instance variables and no 
  		constructor but it still must be instantiated. This is so 
  		a type can be specified for "SomeType". Creating an object 
  		of this class will make use of the default constructor  
  		provided by Java's Object class.
  		AND ... since this class creates an object, in this case
  		the bubbleSort() method is not static.
  	*/

  	/** Sorts a Comparable array using the bubble sort algorithm
        @param array The array of Comparable objects to sort. This 
        			 array is presumed to be full.
	*/
	public void bubbleSort(SomeType[] array)
	{	SomeType temp;
		
		// The value of pass goes from 1 to N-1
		for (int pass=1; pass<array.length; pass++)
		{	// Compare a series of adjacent pairs
			for (int i=0; i<array.length-pass; i++)
				if (array[i].compareTo(array[i+1]) > 0)
				{	// Swap array[i] with array[i+1]
					temp       = array[i];
					array[i]   = array[i+1];
					array[i+1] = temp;
				} // end if
		} // end outer for loop
  	} // end bubbleSort()
  	
}  // end class