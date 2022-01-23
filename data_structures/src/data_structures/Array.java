package data_structures;

import java.util.Arrays;

public class Array {

	private int intArray[];
	private String[] stringArray;
	
	/**
	 * Constructor
	 */
	public Array() {
		intArray = new int[5];
		intArray[0] = 1;
		intArray[1] = 2;
		intArray[2] = 3;
		intArray[3] = 4;
		intArray[4] = 5;

		stringArray = new String[5];
		stringArray[0] = "first";
		stringArray[1] = "second";
		stringArray[2] = "third";
		stringArray[3] = "fourth";
		stringArray[4] = "fifth";
	}
	
	/**
	 * Iterate over an integer array and a String array
	 */
	public void traverse() {
		System.out.println("Integer array elements");
		System.out.println("--------------------------------------------------------");
		for (int x = 0; x < this.intArray.length; x++) {
			System.out.println(String.format("Element at index %d is %s", x, intArray[x]));
		}

		System.out.println(" ");
		System.out.println("String array elements");
		System.out.println("--------------------------------------------------------");
		for (int x = 0; x < this.stringArray.length; x++) {
			System.out.println(String.format("Element at index %d is %s", x, stringArray[x]));
		}
	}
	
	/**
	 * Run a linear search to find a specific integer in an array; run two different binary searches
	 * to find specific Strings in an array
	 */
	public void search() {
		//linear search O(n)
		int intToFind = 5; 
		for (int x = 0; x < this.intArray.length; x++) {
			if (this.intArray[x] == intToFind) {
				System.out.println(String.format("Integer %d found in the array at index %d", intToFind, x));
				break;
			}
		}
		
		//binary search O(log n)
		Arrays.sort(this.stringArray);
		String stringToFind = "fifth";
		int stringFoundIndex = this.binarySearch(stringArray, stringToFind);
		System.out.println(String.format("String value '%s' found in custom binary search at index %d", stringToFind, stringFoundIndex));
		
		//binary search O(log n)
		Arrays.sort(this.stringArray);
		stringToFind = "third";
		stringFoundIndex = this.recursiveBinarySearch(stringArray, stringToFind, 0, stringArray.length - 1);
		System.out.println(String.format("String value '%s' found in recursive binary search at index %d", stringToFind, stringFoundIndex));
		
		//native binary search
		stringToFind = "second";
		stringFoundIndex = Arrays.binarySearch(this.stringArray, stringToFind);
		System.out.println(String.format("String value '%s' found in Java's binary search at index %d", stringToFind, stringFoundIndex));
	}
	
	
	/**
	 * Straight forward update of a value at a specific index in the intArray
	 */
	public void update() {
		int originalValue = this.intArray[0];
		this.intArray[0] = 25;
		System.out.println(String.format("intArray value updated at index 0 to %d", this.intArray[0]));
		this.intArray[0] = originalValue;
		System.out.println(String.format("intArray value reset at index 0 to %d", this.intArray[0]));
	}
	
	
	/**
	 * Remove the array element where the value = 3 by creating a new array that copies all of the 
	 * elements from the original array except the element where the value = 3
	 */
	public void delete() {
		int valueToRemove = 3;
		int[] newArray = new int[this.intArray.length - 1];

		for (int x = 0, newArrayIndex = 0; x < this.intArray.length; x++) {
		    if (this.intArray[x] != valueToRemove) {
		        newArray[newArrayIndex++] = this.intArray[x];
		    }
		}
		
		this.intArray = newArray;
		this.traverse();
	}
	

	/**
	 * Continually split the array in half until the stringToFind is found
	 */
    private int binarySearch(String[] stringArray, String stringToFind)
    {
        int left = 0;
        int right = stringArray.length - 1;
        
        while (left <= right) {
            int middle = left + (right - left) / 2;
 
            int result = stringToFind.compareTo(stringArray[middle]);
 
            // Check if x is present at the middle of the array
            if (result == 0)
                return middle;
 
            if (result > 0) {
                // It's somewhere in the right half of the remaining array
                left = middle + 1;
            } else {
                // It's somewhere in the left half of the remaining array
                right = middle - 1;
            }
        }
 
        // stringToFind was not found in the array
        return -1;
    }
    
    
    private int recursiveBinarySearch(String[] array, String stringToFind, int leftIndex, int rightIndex)
    {
        int middle = leftIndex + (rightIndex - leftIndex) / 2;

        // stringToFind was not found in the array
        if (rightIndex < leftIndex) {
        	return -1;
        }
 
        int result = stringToFind.compareTo(array[middle]);
 
        // Check if x is present at the middle of the array
        if (result == 0)
            return middle;
 
        if (result > 0) {
            // It's somewhere in the right half of the remaining array
        	return recursiveBinarySearch(array, stringToFind, middle + 1, rightIndex);
        } else {
            // It's somewhere in the left half of the remaining array
        	return recursiveBinarySearch(array, stringToFind, leftIndex, middle - 1);
        }
    }
}
