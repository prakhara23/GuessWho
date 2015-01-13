import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class cpu {

	public static void main(String[] args) {
		
	JFrame frame = new JFrame();
	boolean ask = false;
	int index; 
	String trait; 
		
		ArrayList<String[]> chars = new ArrayList<String[]>();
		String[] answer = new String[10];
		declare(chars);
		
		int quesnum = 1;
		
		// The computer asks the following questions in order depending on the answer given by player.
		while (ask == false) {
			
			if (quesnum == 1) {
				
				index = quesnum;
				String value = ""; 
				int n = JOptionPane.showConfirmDialog(frame,
					    "Is you character a male?",
					    "Question 1",
					    JOptionPane.YES_NO_OPTION);
				if ( n == 1) {
					value = "Male";
					check(index, value, chars);
					answer[0]="Female";
				} else {
					value = "Female";
					check(index, value, chars);
					answer[0]="Male";
				}
				quesnum = 2;
			} 
			
			if (quesnum == 2) {
				
				if (answer[0].equals("Female")) {
					
					index = 5;
					trait = "Is your character wearing a hat?";
					trait (chars, frame, answer, index, trait);
				}
				if (answer[0].equals("Male")) {
				
					index = quesnum;
					String value = ""; 
					int n = JOptionPane.showConfirmDialog(frame,
						    "Is you character dark skinned?",
						    "Question 1",
						    JOptionPane.YES_NO_OPTION);
					if ( n == 1) {
						value = "Dark";
						check(index, value, chars);
						answer[1]="Light";
					} else {
						value = "Light";
						check(index, value, chars);
						answer[1]="Dark";
					}
				}	
				quesnum = 3;
				if (chars.size()<2) { break;}
			}
			
			if (quesnum == 3) {
				
				if (answer[0].equals("Female")) {
					
					index = 6;
					trait = "Is your character wearing glasses?";
					trait (chars, frame, answer, index, trait);
				}
				if (answer[0].equals("Male")) {
				
					index = 4;
					trait = "Is your character bald?";
					trait (chars, frame, answer, index, trait);
				}	
				quesnum = 4;
				if (chars.size()<2) { break;}
			}
			if (quesnum == 4) {
				
				if (answer[0].equals("Female")) {
					
					index = 7;
					trait = "Is your character wearing earrings?";
					trait (chars, frame, answer, index, trait);
				}
				if (answer[0].equals("Male") &&  answer[1].equals("Dark")  &&  answer[4].equals("No")) {
				
					index = 8;
					trait = "Does your character have a mustache?";
					trait (chars, frame, answer, index, trait);
				}	
				if (answer[0].equals("Male") &&  answer[1].equals("Light")) {
				
					index = 6;
					trait = "Is your character wearing glasses?";
					trait (chars, frame, answer, index, trait);
				}	
				quesnum = 5;
				if (chars.size()<2) { break;}
			}
			
			if (quesnum == 5) {
				
				if (answer[0].equals("Female") && answer[7].equals("Yes")) {
					
					String hair = "Red";
					hair (chars, frame, answer, hair);
				}
				if (answer[0].equals("Female") && answer[7].equals("No")) {
					
					String hair = "Blonde";
					hair (chars, frame, answer, hair);
				}
				if (answer[0].equals("Male") &&  answer[4].equals("Yes")) {
					
					String hair = "Black";
					hair (chars, frame, answer, hair);
				}	
				if (answer[0].equals("Male") &&  answer[4].equals("No")) {
					
					index = 9;
					trait = "Does your chacter have a beard?";
					trait (chars, frame, answer, index, trait);
				}	
				quesnum = 6;
				if (chars.size()<2) { break;}
			}
			
			if (quesnum == 6) {
				
				index = 8;
				trait = "Does your character have a mustache?";
				trait (chars, frame, answer, index, trait);
				quesnum = 7;
				if (chars.size()<2) { break;}
			}	
			
			if (quesnum == 7) {
				
				index = 5;
				trait = "Is your character wearing a hat?";
				trait (chars, frame, answer, index, trait);
				quesnum = 8;
				if (chars.size()<2) { break;}
			}	
			
			if (quesnum == 8) {
				
				String hair =  null;
				if (answer[5].equals("Yes")) { 
					hair = "Brown";
				}
				if (answer[5].equals("No")) { 
					hair = "Red";
				}
				hair (chars, frame, answer, hair);
				if (chars.size()<2) { break;}
			}
		}
		
		//Once all questions have been asked, computer guesses the player's character.
		ask = question(chars, ask);
		ask(frame, chars, ask);
		for (int i=0; i<chars.size(); i++) {
			System.out.println(chars.get(i)[0]);
			
		}
	}
	
	// Following method creates the array with all the character's and their characteristics.
	public static void declare (ArrayList<String[]> chars) {
		
		chars.clear();
		//                        Name      Gender      Skin     Hair       Bald   Hat    Glass  Earr   Mous   Beard
		chars.add( new String [] {"Alice", 	"Female", 	"Light", "Red", 	"No",  "No",  "No",  "Yes", "No",  "No"});
		chars.add( new String [] {"Anita", 	"Female", 	"Light", "Blonde", 	"No",  "No",  "No",  "No",  "No",  "No"});
		chars.add( new String [] {"Anne",  	"Female", 	"Light", "Black", 	"No",  "No",  "No",  "Yes", "No",  "No"});
		chars.add( new String [] {"Art",	"Male", 	"Dark",  "Black", 	"No",  "No",  "No",  "No",  "Yes", "No"});
		chars.add( new String [] {"Bill", 	"Male", 	"Dark",  "Black", 	"Yes", "No",  "No",  "No",  "Yes", "Yes"});
		chars.add( new String [] {"Bob",	"Male", 	"Light", "Brown", 	"No",  "No",  "No",  "No",  "No",  "No"});
		chars.add( new String [] {"Brian", 	"Male", 	"Light", "Brown", 	"No",  "Yes", "No",  "No",  "No",  "No"});
		chars.add( new String [] {"Carol", 	"Female", 	"Light", "Red", 	"No",  "Yes", "Yes", "Yes", "No",  "No"});
		chars.add( new String [] {"David", 	"Male", 	"Light", "Blonde",	"No",  "No",  "No",  "No",  "No",  "Yes"});
		chars.add( new String [] {"Eric", 	"Male", 	"Light", "Blonde", 	"No",  "Yes", "No",  "No",  "No",  "No"});
		chars.add( new String [] {"Frank", 	"Male", 	"Light", "Red", 	"No",  "No",  "No",  "No",  "No",  "No"});
		chars.add( new String [] {"Henry", 	"Male", 	"Light", "Red", 	"Yes", "No",  "No",  "No",  "No",  "No"});
		chars.add( new String [] {"Jill", 	"Female", 	"Light", "Blonde", 	"No",  "No",  "Yes", "Yes", "No",  "No"});
		chars.add( new String [] {"Mike", 	"Male", 	"Light", "Brown", 	"No",  "No",  "No",  "No",  "Yes", "No"});
		chars.add( new String [] {"Paul", 	"Male", 	"Light", "White", 	"No",  "No",  "Yes", "No",  "No",  "No"});
		chars.add( new String [] {"Phil", 	"Male", 	"Dark",  "Black", 	"No",  "No",  "No",  "No",  "No",  "Yes"});
		chars.add( new String [] {"Sam", 	"Male", 	"Light", "White", 	"Yes", "No",  "Yes", "No",  "No",  "No"});
		chars.add( new String [] {"Susan", 	"Female", 	"Light", "White", 	"No",  "No",  "No",  "No",  "No",  "No"});
		chars.add( new String [] {"Tom", 	"Male", 	"Light", "Black", 	"Yes", "No",  "Yes", "No",  "No",  "No"});
		
	}
		
	public static void trait (ArrayList<String[]> chars, JFrame frame, String[] answer, int index, String trait) {
		
		String value="";
		int n = JOptionPane.showConfirmDialog(frame,
			    trait,
			    "Question 2",
			    JOptionPane.YES_NO_OPTION);
		if ( n == 1) {
			value = "Yes";
			check(index, value, chars);
			answer[index]="No";
		} else {
			value = "No";
			check(index, value, chars);
			answer[index]="Yes";
		}
		System.out.println(chars.size());
	}
	

	public static void hair (ArrayList<String[]> chars, JFrame frame, String[] answer, String hair) {
		
		int index = 3;
		String value = hair;
		int n = JOptionPane.showConfirmDialog(frame,
			    "Does your character have " + hair + " hair?",
			    "Question 2",
			    JOptionPane.YES_NO_OPTION);
		if ( n == 1) {
			value = hair;
			check(index, value, chars);
			
		} else {
			for (int i=0; i<chars.size(); i++) {
				if (!(chars.get(i))[index].equals(value)) {
					chars.set(i, null);
				}
			}
			chars.removeAll(Collections.singleton(null));
		}
		System.out.println(chars.size());
	}
	
	//Check method determines if the asked for trait is present in characters.
	public static void check (int index, String value, ArrayList<String[]> chars) {
		
		for (int i=0; i<chars.size(); i++) {
			if ((chars.get(i))[index].equals(value)) {
				chars.set(i, null);
			}
		}
		chars.removeAll(Collections.singleton(null));
	}
	
	//Question determines in the computer should identify the player's character or not.
	public static boolean question (ArrayList<String[]> chars, boolean ask) {
		
		if (chars.size() == 1 || chars.size() == 0) 
			ask = true;
		else 
			ask = false;
		return ask;
	}
	
	//Computer guesses player's character and ask method determines who wins.
	public static void ask(JFrame frame, ArrayList<String[]> chars, boolean ask) {
		
		if (ask == true) {
			boolean correct = false; 
			int n = 100;
			String character = null;
			String verdict = null;
			if (chars.size() == 1) { 
				character = chars.get(0)[0];
				correct = true; 
			} else if (chars.size() == 0) {
				correct = false; 
				verdict = "None of the caracters \nmatch the description given.";
			}
						
			if (correct == true) {
				n = JOptionPane.showConfirmDialog(frame,
						"Are you " + character + "?",
						"Answer",
						JOptionPane.YES_NO_OPTION);
			}	
			if (n == 1) {
				
				JOptionPane.showMessageDialog(frame,
					    "You Win! The CPU guessed wrong.");
				
			} else {
				if (correct == true) {
					verdict = "You Lose! The CPU guessed correct."; 
				}
				JOptionPane.showMessageDialog(frame,
					    verdict,
					    "Game Lost",
					    JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

}
