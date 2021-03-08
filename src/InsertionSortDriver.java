import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertionSortDriver {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int comparisons = 0, swaps = 0;
	
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
		
		while(!isDone) {
            System.out.println("1. Sort the numbers (Insertion Sort)\n2. Print the numbers\n3. Exit");
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
				insertionSort(userArr);
				break;
			case 2:
				printArr(userArr);
				break;
			case 3:
				System.out.println("Goodbye!");
				isDone = true;
				break;
			default:
				System.out.print("\nPlease enter a valid integer, 1 or 2.\n");
				break;
			}
		}
	}
	
	public static int[] populateArr(int[] userArr) {
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
		System.out.println("\nYour current array is: ");
		for(int i = 0; i < userArr.length; i++) {
			System.out.print(userArr[i] + " ");
		}
		System.out.println();
	}
	
	public static void insertionSort(int[] userArr) {
		int candidateKey, size = userArr.length;
		for(int i = 1; i < size; i++) {
			int j = i - 1;
			candidateKey = userArr[i];
			while(j > -1 && userArr[j] > candidateKey) {
				comparisons++;
				swaps++;
				userArr[j+1] = userArr[j];
				j--;
			}
			userArr[j+1] = candidateKey;
		}
		System.out.println("Comparisons: " + comparisons + "\t Swaps: "  + swaps);
	}
}
