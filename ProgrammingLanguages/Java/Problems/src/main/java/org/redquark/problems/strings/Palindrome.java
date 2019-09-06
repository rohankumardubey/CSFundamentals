package org.redquark.problems.strings;

import java.util.Scanner;

/**
 * @author Anirudh Sharma
 *
 */
public class Palindrome {

	/**
	 * Some good examples of Palindrome strings (case-insensitive)
	 * 
	 * 1. Never odd or even
	 * 2. A nut for a jar of Tuna
	 * 3. Al lets Della call Ed Stella.
	 * 4. Amore, Roma
	 * 5. Are we not pure? “No, sir!” Panama’s moody Noriega brags. “It is garbage!” Irony dooms a man—a prisoner up to new era.
	 * 6. Borrow or rob?
	 * 7. King, are you glad you are king?
	 * 8. Taco cat
	 * 9. Was it a car or a cat I saw?
	 * 10. Dennis, Nell, Edna, Leon, Nedra, Anita, Rolf, Nora, Alice, Carol, Leo, Jane, Reed, Dena, Dale, Basil, Rae, Penny, Lana, Dave, Denny, Lena, Ida, Bernadette, Ben, Ray, Lila, Nina, Jo, Ira, Mara, Sara, Mario, Jan, Ina, Lily, Arne, Bette, Dan, Reba, Diane, Lynn, Ed, Eva, Dana, Lynne, Pearl, Isabel, Ada, Ned, Dee, Rena, Joel, Lora, Cecil, Aaron, Flora, Tina, Arden, Noel, and Ellen sinned.
	 * 11. Ed, I saw Harpo Marx ram Oprah W. aside
	 * 12. Madam, in Eden, I’m Adam
	 * 13. Murder for a jar of red rum
	 * 14. Oozy rat in a sanitary zoo
	 * 15. Yo, banana boy
	 */
	
	
	public static void main(String[] args) {

		// Get a string from the user
		Scanner scanner = new Scanner(System.in);
		String sentence = scanner.nextLine();
		
		// Closing the connection
		scanner.close();
		
		// Trim all the white spaces and convert to lower case
		sentence = sentence.trim().toLowerCase();

		int length = sentence.length();
		boolean isPalindrome = false;

		for (int i = 0; i < length; i++) {
			if (sentence.charAt(i) == sentence.charAt(length - 1 - i)) {
				isPalindrome = true;
			} else {
				isPalindrome = false;
			}
		}

		if (isPalindrome) {
			System.out.println("Entered string is Palindrome");
		} else {
			System.out.println("Entered string is not Palindrome");
		}
	}

}
