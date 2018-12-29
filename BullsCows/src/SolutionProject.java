import java.util.Random;
import java.util.Scanner;

public class SolutionProject {
	private static final int MAX_ATTEMPTS = 20;
	private static final int MIN_NUMBER = 1023;
	private static final int MAX_NUMBER = 9876;
	

	public static void main(String[] args) {
		String numberToGuess;
		do {
			numberToGuess = generateRandom(MIN_NUMBER, MAX_NUMBER);
		} while (!checkRandomNumber(numberToGuess));		
		
		for (int attempt = 0; attempt < MAX_ATTEMPTS; attempt++) {
			System.out.print("Guess the 4 digit number: ");
			String tryToGuess;
			while (true) {
				tryToGuess = enterString();
				if (checkNumber(tryToGuess)) {
					break;
				} else {
					System.out.println("Invalid input, try again");
				}
			}
			String result = compareNumbers(numberToGuess, tryToGuess);
			if (result == "4 Bulls") {
				System.out.println("Success at attempt " + (attempt + 1));
				return;
			} else {
				System.out.println(result);
			}

		}
		System.out.println("Didn't guess it " + numberToGuess);
		return;
	}
		
	
	
	
	private static boolean isDuplicate(String str, char c) {
		boolean alreadyFound = false;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == c) {
				if (alreadyFound) {
					return true;
				}
				alreadyFound = true;
			}
		}
		return false;
		
	}
	private static boolean checkRandomNumber(String numberToGuess) {
		if (numberToGuess.charAt(0) == '0') {
			return false;
		}
			
			
		for (int i = 0; i < 4; i++) {
			if (isDuplicate(numberToGuess, numberToGuess.charAt(i))) {
				return false;
			}		
		}
		return true;
		
	}

	private static boolean checkNumber(String numberToGuess)  {
		if (numberToGuess.length() != 4) {
			return false;
		}
		if (numberToGuess.charAt(0) == '0') {
			return false;
		}
		
		for (int i = 0; i < 4; i++) {
			if (isDuplicate(numberToGuess, numberToGuess.charAt(i))) {
				return false;
			}		
		}
		return true;
	}

	private static String compareNumbers(String numberToGuess, String tryToGuess) {
		int bulls = 0;
		int cows = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (numberToGuess.charAt(i) == tryToGuess.charAt(j)) {
					if (i == j) {
						bulls++;
					} else {
						cows++;
					}
				}
			}
		}
		if (bulls == 4) {
			return "4 Bulls";
		} else {
			return (bulls + " Bulls ; " + cows + " Cows");
		}
	}

	private static String enterString() {
		Scanner console = new Scanner(System.in);
		String s = console.nextLine();
		
		return s;
	}

	

	private static String generateRandom(int min, int max) {
	    Random random = new Random();
	    return Integer.toString(random.ints(min,(max+1)).findFirst().getAsInt());
	}

}
