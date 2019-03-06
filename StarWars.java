import java.util.*;
import javax.swing.*;
import java.net.*;

// * please note, that comments with stars at the beginning were used for debugging purposes and are not part of the program 
// ** two stars means that this is applicable with the console, but not the GUI's
public class StarWars {
	public static void main(String[] args) throws MalformedURLException {
		Scanner kb = new Scanner(System.in);

		// creating an array with the list of vocab from star wars 
		String starwarsvocab[] = {"BB8", "STARWARS", "DARTHVADER", "SKYWALKER", "R2D2", "JAKKU", "CHEWBACCA", "TAKODANA"}; 
		LinkedList<Integer> reference = new LinkedList<Integer>(); 

		String hanged = "HANGED!"; 
		boolean continueplaying = true; 
		// beginning a while loop for as long as the user wants to play HangMan
		while (continueplaying == true){

			URL displaypiclink = null; 
			try {
				displaypiclink = new URL("http://img.cinemablend.com/cb/7/1/f/e/c/5/71fec5ea42d09f6adc541433865dfe63a839053f606f6b69b3850ef01b4aea8a.jpg");
			} // end of try 
			catch (MalformedURLException e1) {
			} // end of catch 
			ImageIcon displaypic = new ImageIcon(displaypiclink); 

			JOptionPane.showMessageDialog(null, "Welcome to StarWars HangMan! :D","Hangman!", JOptionPane.INFORMATION_MESSAGE, displaypic);

			URL displaypiclink1 = null; 
			try {
				displaypiclink1 = new URL("http://icons.iconarchive.com/icons/iconarchive/red-orb-alphabet/24/Question-mark-icon.png");
			} // end of try 
			catch (MalformedURLException e1) {
			} // end of catch 
			ImageIcon displaypic1 = new ImageIcon(displaypiclink1);

			URL forcebewithyoulink = null; 
			try {
				forcebewithyoulink = new URL("http://shirtoid.com/wp-content/uploads/2013/06/May-The-Force-Be-With-You-sm.jpg");
			} // end of try 
			catch (MalformedURLException e1) {
			} // end of catch 
			ImageIcon forcebewithyou = new ImageIcon(forcebewithyoulink);

			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog(null, "Do you know how to play HangMan?", "Experience", dialogButton);
			if(dialogResult == 0) {
				// ** System.out.println("Yes option");
				JOptionPane.showMessageDialog(null, "Let's begin, may the force be with you :)", "Starting the game", JOptionPane.INFORMATION_MESSAGE, forcebewithyou);
			} // when the user says no, end of if  
			else {
				JOptionPane.showMessageDialog(null, "Start off by guessing a letter and enter it ;)", "Instructions", JOptionPane.INFORMATION_MESSAGE, displaypic1); 
				JOptionPane.showMessageDialog(null, "If the letter is in the word, then you are one step closer to guessing the word. ", "Instructions", JOptionPane.INFORMATION_MESSAGE, displaypic1);
				JOptionPane.showMessageDialog(null, "If it's not in the word, then you will be one step closer to getting HANGED!", "Instructions", JOptionPane.INFORMATION_MESSAGE, displaypic1);
				JOptionPane.showMessageDialog(null, "C'mon, let's play, may the force be with you :) ", "You can do this!", JOptionPane.INFORMATION_MESSAGE, forcebewithyou);
				// ** System.out.println("No Option");
			} // end of else, when the user says yes

			// generating a random number between 0 and 7 
			int randomnumber = (int)(Math.random()*8+0);
			// * System.out.println(randomnumber);
			// * System.out.println("The random word is " + starwarsvocab[randomnumber]);
			int vocablength = starwarsvocab[randomnumber].length(); 
			// * System.out.println("The length is " + vocablength);

			int maxguesses = 7 + vocablength; 
			char guessedletters[] = new char[maxguesses];

			// creating an array with the dashes 
			char answer[] = new char[vocablength]; 

			// now storing dashes (-) for each character of the answer 
			String messagetodisplay = ""; 
			for (int i = 0; i < vocablength; i++){
				answer[i] = '-'; 
				// ** System.out.print(answer[i] + " ");
				messagetodisplay = messagetodisplay + " - "; 
			} // end of for loop 

			URL jedilink = null; 
			try {
				jedilink = new URL("http://vignette4.wikia.nocookie.net/starwars/images/c/c3/Yoda_TPM_RotS.png/revision/latest?cb=20130810185858");
			} // end of try 
			catch (MalformedURLException e1) {
			} // end of catch 
			ImageIcon jedi = new ImageIcon(jedilink);

			URL darthvaderlink = null; 
			try {
				darthvaderlink = new URL("http://icons.iconarchive.com/icons/3xhumed/mega-games-pack-31/48/Star-Wars-KotR-II-The-Sith-Lords-2-icon.png");
			} // end of try 
			catch (MalformedURLException e1) {
			} // end of catch 
			ImageIcon darthvader = new ImageIcon(darthvaderlink); 

			JOptionPane.showMessageDialog(null, messagetodisplay, "Here is your word.. seek it wisely", JOptionPane.INFORMATION_MESSAGE, jedi);

			for (int i = 0; i < maxguesses; i++){
				// 32 means space
				guessedletters[i] = 32; 
			}

			// printing a new line in between, but this is only relevant if it's a console  
			System.out.println();

			boolean guessedright = false; 
			int chances = 0;  
			String alphanum = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; 

			while (!guessedright && chances < 7){

				// now asking the player to guess the character 
				// ** System.out.println("Guess the character!");
				String guessedletter = JOptionPane.showInputDialog("Guess the word! (Enter a letter or number)"); 
				// JOptionPane.showInputDialog(null,)

				// converting everything to uppercase to keep the program consistent 
				guessedletter =	guessedletter.toUpperCase();
				// initializing the guessed character 
				char guessedchar = ' ';

				// ** if (guessedletter.length() == 0){
				// ** continue; 
				// ** }

				// try catching the charAt(0) in case the user enters a space 
				try {
					guessedchar = guessedletter.charAt(0);
				} catch (java.lang.StringIndexOutOfBoundsException e) {
					// ** System.out.println("Invalid! Please try again!");
					JOptionPane.showMessageDialog(null, "Invalid! Please enter a valid character!", "Don't fail me again", JOptionPane.INFORMATION_MESSAGE, darthvader);
					continue; 
				} // end of catch

				// finding the length of the guess, as if it's more than one character it should be invalid. 
				int lengthofguess = guessedletter.length(); 				

				if (lengthofguess > 1){
					// ** System.out.println("You can only enter one letter at a time!");
					JOptionPane.showMessageDialog(null, "You can only enter one letter at a time!", "Don't fail me again", JOptionPane.INFORMATION_MESSAGE, darthvader);
				} // end of if lengthofguess > 1
				else {

					if (!alphanum.contains(guessedletter)){
						// System.out.println("Sorry, the guess character should be A-Z or 0-9!");
						JOptionPane.showMessageDialog(null, "Sorry, the guess character should be A-Z or 0-9!", "Don't fail me again", JOptionPane.INFORMATION_MESSAGE, darthvader);
					} // end of if guessedletter has the designated alphabet 

					else {

						boolean guessedonce = false; 
						int j = 0; 

						while (guessedletters[j] != 32 && guessedonce == false){
							if (guessedletters[j] == guessedletter.charAt(0)){
								System.out.println(guessedletters[j]);
								// * System.out.println("The guessed letter is " + guessedletter.charAt(0));
								// ** System.out.println("This letter has already been guessed. Try again!");
								JOptionPane.showMessageDialog(null, "This letter has already been guessed. Try again!", "Don't fail me again", JOptionPane.INFORMATION_MESSAGE, darthvader);
								guessedonce = true; 
							} // end of if guessedletters[j] == guessedletter.charAt(0) 
							j ++; 
						} // end of while guessedletters[j] != 32 && guessedonce == false 	

						if (guessedonce == false){
							guessedletters[j] = guessedchar; 
							// checking whether the user's guess matches a letter in the random word generated 
							if (starwarsvocab[randomnumber].contains(guessedletter)){
								// ** System.out.println("Yes, this word does contain " + guessedletter);
								JOptionPane.showMessageDialog(null, "Yes this word does contain " + guessedletter); 
								// next, using a for loop to go through the letters in the randomword 
								for (int i = 0; i < vocablength; i++){
									char vocab = starwarsvocab[randomnumber].charAt(i); 

									if (vocab == guessedchar){
										answer[i] = guessedchar; 
									} // end of if vocab == guessedchar 
								} // end of for loop to find positions of matched letters

								// creating a variable to store the number of dashes found 
								int num_dashes = 0; 

								messagetodisplay = ""; 
								for (int i = 0; i < vocablength; i++){
									if (answer[i] == '-'){
										num_dashes++; 
									} // end of if answer[i] == '-'
									// ** System.out.print(answer[i] + " ");
									messagetodisplay = messagetodisplay + Character.toString(answer[i]); 
								} // end of for loop to print out answer

								URL yaylink = null; 
								try {
									yaylink = new URL("http://www.awsm.com/img/2010/star_wars_day.jpg");
								} // end of try 
								catch (MalformedURLException e1) {
								} // end of catch 
								ImageIcon yay = new ImageIcon(yaylink);

								JOptionPane.showMessageDialog(null, messagetodisplay, "Yeah or nah?", JOptionPane.INFORMATION_MESSAGE, yay); 

								if (num_dashes == 0){
									guessedright = true; 
									// ** System.out.println("");
									// ** System.out.println("Congratulations! You guessed it correctly! :-)");
									JOptionPane.showMessageDialog(null, "Congratulations! You guessed it correctly! :-)", "WELL DONE!", JOptionPane.INFORMATION_MESSAGE, jedi);
								} // end of if num_dashes == 0
							} // end of if letter is present in starwarsvocab[randomnumber] 

							else {
								// ** System.out.println("Sorry, this word doesn't contain " + guessedletter);
								JOptionPane.showMessageDialog(null, "Sorry, this word doesn't contain " + guessedletter, "Don't fail me again", JOptionPane.INFORMATION_MESSAGE, darthvader);
								chances ++; 
								// ** System.out.println("Your current status is: " + hanged.substring(0, chances));
								JOptionPane.showMessageDialog(null, "Your current status is: " + hanged.substring(0, chances), "Don't fail me again", JOptionPane.INFORMATION_MESSAGE, darthvader);

								if (chances == 7){
									// ** System.out.println("Sorry, you have failed to guess the word {" + starwarsvocab[randomnumber] + "}. Better luck next time :(( ");
									JOptionPane.showMessageDialog(null, "Sorry, you have failed to guess the word {" + starwarsvocab[randomnumber] + "}. Better luck next time :(( ", "YOU HAVE FAILED ME", JOptionPane.INFORMATION_MESSAGE, darthvader);
								} // end of chances == 7
							} // end of else 
						} // end of if guessedonce == false
					} // end of else when lengthofguess isn't greater than one 
				} // end of when the character is present in alphanum 
			} // end of while guessedright 

			// ** System.out.println("");	

			String userreference = JOptionPane.showInputDialog("How much did you like this game? (On a scale of 1 - 10)"); 
			int userreferencenum = Integer.parseInt(userreference); 
			reference.add(userreferencenum); 
			JOptionPane.showMessageDialog(null, "Okay, thank you! :)");

			// ** System.out.println("Would you like to play again? Y/N");
			String userresponse = JOptionPane.showInputDialog(null, "Would you like to play again? Y/N"); 
			// ** String userresponse = kb.nextLine(); 

			if (userresponse.equalsIgnoreCase("N")){
				continueplaying = false; 
				// ** System.out.println("Okay, adios!");

				URL url = new URL("https://media.giphy.com/media/3oYRjqJaq6Eow/giphy.gif");
				Icon icon = new ImageIcon(url);
				JLabel label = new JLabel(icon);

				JFrame f = new JFrame("Okay, adios!");
				f.getContentPane().add(label);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.pack();
				f.setLocationRelativeTo(null);
				f.setVisible(true);

			} // end of if 
		} // end of while continueplaying 
	} // end of main 
} // end of class 
