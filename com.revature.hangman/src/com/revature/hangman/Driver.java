package com.revature.hangman;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myScanner = new Scanner(System.in);
		
		int bodyParts = 6;                                      // Every time on wrong guess a bodyPart gets decremented.
		System.out.println("Enter word to be guessed: ");
		
		// Asking for the userInput		
		String mysteryWord = myScanner.nextLine();
		//	Make an array list of all the correctly guessed Letters
		ArrayList<String> correctlyGuessedLetters = new ArrayList<String>();
		//	To print the current guessed state copy the value of -
		//	- mysteryWord to originalWord
		String originalWord = mysteryWord;
		while(bodyParts>0) {
			
			// Guessing part of the game
			// ask 	player for a letter they think is the mystery word
			System.out.println("Guess a letter in the word: "); 
			// Get the letter from the user		
			String guessedLetter = myScanner.nextLine();
			
			// Checking whether mysterWord contains the guessed letter		
			if (mysteryWord.contains(guessedLetter)) {
				System.out.println("the word contains "+ guessedLetter);
				// Remove all the correctly guessedLetter
//				System.out.println(mysteryWord);
				mysteryWord = mysteryWord.replaceAll(guessedLetter, ""); //this replaces the letter with empty String
//				System.out.println(mysteryWord);
				//Add the guessedLetter to correctlyGuessed array
				correctlyGuessedLetters.add(guessedLetter);
				System.out.println(correctlyGuessedLetters);
				
			}else {
				System.out.println("The word doesn't contain "+ guessedLetter);
			//Decrement the bodyPart
				bodyParts--;
				System.out.println("Remaining body parts: "+ bodyParts);
			}
			
			System.out.println("How's the guessing is going");
			for(Character letter:originalWord.toCharArray()) {
				if(correctlyGuessedLetters.contains(letter.toString())) {
					System.out.println(letter);
				}else {
					System.out.println("#");
				}
			}
			if(mysteryWord.length()==0) {
				System.out.println("Congratulations you guessed all the letters in the mysteryWord ");
				break;
			}
		}
		// After the while loop ends (i.e bodyParts ==0) || guessed all the correct letters (i.e mysteryWord.length==0)
		if(bodyParts==0) {
			System.out.println("Better luck next time");
		}
		
	}
		
}
		
		
		

