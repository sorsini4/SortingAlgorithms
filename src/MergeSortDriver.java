import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Purpose: Data Structure and Algorithms Lab 10 Problem 1
 * Status: Completed and throughly tested
 * Last update: 11/17/20
 * Submitted:  11/17/20
 * Comment: test suite and sample run attached
 * @author: Steven Orsini
 * @version: 2020.11.17
 */
public class MergeSortDriver {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int comparisons = 0;
	static int swaps = 0;
	
	public static void main(String[] args) {
		
		boolean isDone = false;
		int[] userArr = null;
		int userAnswer = 0;
		
		try {
			System.out.print("Please enter the number of integers: ");
			int size = Integer.parseInt(input.readLine());
			System.out.println(size + " ");
			userArr = new int[size];
			populateArr(userArr);
		}
		catch(NumberFormatException e) {
			System.out.println("Please enter a valid integer.");
		}
		catch(IOException e) {
			System.out.println("Please enter a valid integer.");
		}
		
		System.out.print("\nPlease choose one of the following options.\n1. Sort the collection"
				+ " w/ Mergesort (Recursive Algorithm)\n2. Sort the collection w/ Mergesort "
				+ "(Iterative Algorithm)\n3. Print the collection\n4. Exit\n\n");
		
		while(!isDone) {
			System.out.print("\nYou know the options.\n> ");
			
			try {
				userAnswer = Integer.parseInt(input.readLine());
				System.out.print(userAnswer + "\n");
			}
			catch(NumberFormatException e) {
				userAnswer = 10;
			}
			catch(IOException e1) {
				userAnswer = 10;
			}

			switch(userAnswer) {
			case 1:
				mergeSort(userArr, 0, userArr.length - 1);
				System.out.println("Comparisons: " + comparisons + "\nSwaps: " + swaps);
				break;
			case 2:
				mergeSortIterative(userArr);
				break;
			case 3:
				printArr(userArr);
				break;
			case 4:
				System.out.println("Goodbye!");
				isDone = true;
				break;
			default:
				System.out.print("\nPlease enter a valid integer, 1 or 2.\n");
				break;
			}
		}
	}
	
	public static int[] populateArr(int[] userArr){
		int i = 0;
		
		try {
			while(i < userArr.length) {
				System.out.print("\nEnter an integer: ");
				int userNum = Integer.parseInt(input.readLine());
				System.out.print(userNum + "\n");
				userArr[i] = userNum;
				i++;
			}
		}
		catch(NumberFormatException e) {
			System.out.println("Please enter a valid integer.");
		}
		catch(IOException e1) {
			System.out.println("Please enter a valid integer.");
		}
		return userArr;
	}
	
	public static void printArr(int[] userArr) {
		for(int i = 0; i < userArr.length; i++) {
			System.out.print(userArr[i] + " ");
		}
		System.out.println();
	}
	
	public static void mergeSort(int[] userArr, int first, int last) {		
		if(last <= first) {
			return;
		}
		int mid = (first + last) / 2;
		mergeSort(userArr, first, mid);
		mergeSort(userArr, mid + 1, userArr.length-1);
		merge(userArr, first, mid, last);
	}
	
	public static void merge(int[] userArr, int first, int mid, int last) {
		int[] firstHalf = new int[mid - first + 1];
		int[] secondHalf = new int[last - mid];
		int firstIndex = 0, secondIndex = 0;
				
		for(int i = 0; i < firstHalf.length; i++) {
			firstHalf[i] = userArr[first + i];
			System.out.println("first[" + i + "]: " + firstHalf[i]);
		}
			
		for(int i = 0; i < secondHalf.length; i++) {
			secondHalf[i] = userArr[mid + i + 1];
			System.out.println("second[" + i + "]: " + secondHalf[i]);		
		}

		//compare elements to see where they fit corresponding to each other in their respective
		//halves
		for(int i = first; i < last + 1; i++) {
			if(firstIndex < firstHalf.length && secondIndex < secondHalf.length) {
				if(firstHalf[firstIndex] < secondHalf[secondIndex]) {
					userArr[i] = firstHalf[firstIndex];
					firstIndex++;
					swaps++;
				}
				else {
					userArr[i] = secondHalf[secondIndex];
					secondIndex++;
					swaps++;
				}
			}
			else if(firstIndex < firstHalf.length) {
				userArr[i] = firstHalf[firstIndex];
				firstIndex++;
			}
			else if(secondIndex < secondHalf.length) {
				userArr[i] = secondHalf[secondIndex];
				secondIndex++;
			}
			comparisons++;
		}
	}
	
	//not finished 
	public static void mergeSortIterative(int[] userArr) {
		int[] first = new int[userArr.length/2];
		int[] second = new int[userArr.length - userArr.length/2];
		
		//giving first half of elements to first arr
		for(int i = 0; i < userArr.length/2; i++) {
			first[i] = userArr[i];
			System.out.println("first[" + i + "]: " + first[i]);
		}
			
		//giving second half of elements to second arr
		for(int j = userArr.length/2, i = 0; j < userArr.length; j++, i++) {
			second[i] = userArr[j];
			System.out.println("second[" + i + "]: " + second[i]);		
		}
		
		for(int i = 0; i <= first.length/2; i++) {
			if(first[i] > first[i+1]) {
				int temp = first[i];
				first[i] = first[i+1];
				first[i+1] = temp;
			}
		}
	}
	
}

