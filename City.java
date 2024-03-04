import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

abstract class Helper {

    Map<String, String> Authentication = new HashMap<>();
    Scanner zen = new Scanner(System.in);

    protected static String username;
    protected static String password;
    protected static String repass;
	protected static long id;
	protected static int age;
    protected static String gender;
	protected static String occupation;
	protected static final boolean citizen = false;
    protected static final int length = 9;
    protected static double initial = 1000;
    protected static int choice;
    protected static String pahchan;
    protected static String choose;
    int take;

    // at the gate
	abstract String signUp();
	abstract String login();
    abstract String randomId(int length);
    abstract void alreadyCitizen(String username, String password);
    abstract void displayTourist();

    // in the city
    abstract void playGame();
    abstract void uniAddmission();
    abstract void Shopping();
    abstract double banking();

}

class Entry extends Helper {

    MCQs mcq = new MCQs();
    TicTacToe ttt = new TicTacToe();

    public Entry() {

        System.out.println("\n\n\t\t***Welcome*** ");
        while(true) {
            System.out.println("\nWho are you?\n");
            System.out.println("\t1. Citizen/  2. Tourist/  3.Exit/\n");
            System.out.println("How would you like to enter the city.");
            System.out.print("As a: ");
            choice = zen.nextInt();   

            switch(choice) {
                case 1:
                    System.out.println("Enter name equals to \"hamid\" and passcode equals to \"kalhoro\"");
                    alreadyCitizen("hamid", "kalhoro");
                    break;
                case 2:
                    System.out.println("\nA tourist will first give the details");
                    signUp();
                    login();
                    pahchan = randomId(length);
                    System.out.println("\n\t\t\t***Finally***\n\t\t\t/*Details are*\n"+"\t\tName is "+username+
                                        "\n\t\tPassword is "+password+"\n\t\tage is "+age+"\n\t\tgender is "+gender+
                        "\n\t\tOccupation is "+occupation+"\n\t\tRandom ID is " + pahchan+"\n");
                    break;
                case 3:
                    System.out.println("\n\t\tEXITING...");
                    System.exit(0);
            }

            do {
                System.out.println("\n\t***Some of the city points are***\n");
                System.out.println("1. Display Tourists List");
                System.out.println("2. Gaming");
                System.out.println("3. University");
                System.out.println("4. Store");
                System.out.println("5. Banking");
                System.out.println("6. Check Balance");
                System.out.println("7. Back");
                System.out.println("8. Exiting");
                System.out.print("\n\tWhere would you like to go: ");
                choice = zen.nextInt();
                
                switch(choice) {
                    case 1:
                        displayTourist();
                        break; 
                    case 2:
                        playGame();
                        break;
                    case 3:
                           uniAddmission(); 
                        break;
                    case 4:
                        Shopping();
                        break;
                    case 5:
                        banking();
                        break;
                    case 6:
                        System.out.println("the present amount is "+initial);
                        break;
                    case 8:
                        System.exit(0);
                        break;
                }
            } while(choice != 7);
        }
    }

    @Override
    String signUp() {
        System.out.println("\n\t***SIGN FORM***\n");
        System.out.print("Enter your name: ");
        username = zen.next();
        System.out.print("Enter your age(integer): ");
        age = zen.nextInt();
        System.out.print("Enter your Gender: ");
        gender = zen.next();
        System.out.print("Enter your occupation: ");
        occupation = zen.next();

        do {
            System.out.print("Enter your password: ");
            password = zen.next();
            System.out.print("Re-enter your password: ");
            repass = zen.next();
            if(!password.equals(repass)) {
                System.out.println("\n\tPassword did'nt match, Re-Enter please.\n");
            }
        } while(!password.equals(repass));

        Authentication.put(username, password);
        System.out.println("\t\nSigning in...\n\nSign-up completed, "+" Login and explore the city.\n");
        
        return "";
    }

    @Override
    String login() {
        System.out.println("\t***LOGIN FORM***\n");
        
        while(!false) {
            System.out.print("Enter your name: ");
            username = zen.next();
            System.out.print("Enter your password: ");
            password = zen.next();

            if(Authentication.containsKey(username) && Authentication.get(username).equals(password)) {
                System.out.println("Logging in...\n\n Login successful!, welcome to the city.");
                return "";
            } else {
                System.out.println("\nInvalid USERNAME or PASSWORD\n");
                System.out.println();
            }
        }
    }

    @Override
    String randomId(int length) {
        String random = "abcdefghijklmnopqrstuvwxyz0123456789!@#$%/";
        char[] newId = new char[length];
        for(int i=0; i<length; i++) {
            int rand = (int) (Math.random() * random.length());
            newId[i] = random.charAt(rand);
        }
        return new String(newId);
    }

    @Override
    void alreadyCitizen(String username, String password) {
        System.out.println("\n\tEnter your Information, please\n");
        String prevName;
        String prevPass;

        do {
            System.out.print("Enter your Name: ");
            prevName = zen.next();
            System.out.print("Enter your Passcode: ");
            prevPass = zen.next();

            if((prevName.equals(username) && prevPass.equals(password))) {
                System.out.println("\nWelcome back to the City, SIR.");
                break;
            } else {
                System.out.println("try again");
            }
        } while(!(prevName.equals(username) && prevPass.equals(password)));
        
    }

    @Override
    void displayTourist() {
            if(Authentication.isEmpty()) {
                System.out.println("There is no any tourist present in the city.\n");
            } else {
                System.out.println("\nList of Tourists\n");
                int i=1;
                for(java.util.Map.Entry<String, String> map : Authentication.entrySet()) {
                    String name = map.getKey();
                    String pass = map.getValue();
                    System.out.println(i+": Name is "+name+" and "+" Password is "+pass);
                    i++;
                }
            }
    }

    @Override
    void uniAddmission() {
        System.out.println("\n\t\tEntering in University\n");

        do {
            System.out.println("1. Software MCQ's");
            System.out.println("2. Canteen");
            System.out.println("3. back");
            System.out.println("4. exit\n");
            System.out.print("\tenter your choice: ");
            choice = zen.nextInt();

            switch (choice) {
                case 1:
                    mcq.mcqGame();
                    break;
                case 2:
                    do {
                        System.out.println("1. Drink or take");
                        System.out.println("2. Samosa: 30");
                        System.out.println("3. Peties: 30");
                        System.out.println("4. back");
                        System.out.println("5. exit\n");
                        System.out.print("What do you want: ");

                        choice=zen.nextInt();
                        
                        int size;

                        switch(choice) {
                            case 1:
                                System.out.println("1. water:60   2. tea:60   3.coffee:90 ");
                                System.out.print("select your desire: ");
                                choice=zen.nextInt();

                                if(choice == 1) {
                                    System.out.print("How much bottles do you want: ");
                                    size = zen.nextInt();
                                    initial-=size*60;
                                    System.out.println("Total is "+size*60);
                                    System.out.println("Now, your balance is "+initial);
                                } else if(choice == 2) {
                                    System.out.print("How much cups do you want: ");
                                    size = zen.nextInt();
                                    initial-=size*60;
                                    System.out.println("Total is "+size*60);
                                    System.out.println("Now, your balance is "+initial);
                                } else if(choice == 3) {
                                    System.out.print("How much cups do you want: ");
                                    size = zen.nextInt();
                                    initial-=size*90;
                                    System.out.println("Total is "+size*90);
                                    System.out.println("Now, your balance is "+initial);
                                }
                                break;
                            case 2:
                                System.out.print("How many samosas do you want: ");
                                size = zen.nextInt();
                                initial-=size*30;
                                System.out.println("Total is "+size*30);
                                System.out.println("Now, your balance is "+initial);
                                break;
                            case 3:
                                System.out.print("How many peties do you want: ");
                                size = zen.nextInt();
                                initial-=size*30;
                                System.out.println("Total is "+size*30);
                                System.out.println("Now, your balance is "+initial);
                                break;
                            case 5:
                                System.exit(0);
                        }
                    } while(choice != 4);
                    break;
                case 4:
                    System.exit(0);
            }
        } while(choice != 3);
            
    }

    @Override
    void Shopping() {
        do {
            System.out.println("***Groceries***");
            System.out.println("\t1. Rice: 150 per kg");
            System.out.println("\t2. Wheat: 250 per kg");
            System.out.println("\t3. Daal: 65 per kg");
            System.out.println("\t4. Shole: 200 per kg");
            System.out.println("\t5. Check your balance");
            System.out.println("\t6. Back");
            System.out.println("\t7. Exit");
            System.out.print("what is your choice: ");
            take = zen.nextInt();
            int kg;

            switch(take) {
                case 1: 
                    System.out.println("How much kg you want to buy: ");
                    kg = zen.nextInt();
                    initial-=(kg*150);
                    System.out.println("Total is "+kg*150);
                    System.out.println("Now, your balance is "+initial);
                    break;
                case 2:
                    System.out.println("How much kg you want to buy: ");
                    kg = zen.nextInt();
                    initial-=(kg*250);
                    System.out.println("Total is "+kg*250);
                    System.out.println("Now, your balance is"+initial);
                    break;
                case 3:
                    System.out.println("How much kg you want to buy: ");
                    kg = zen.nextInt();
                    initial-=(kg*65);
                    System.out.println("Total is "+kg*65);
                    System.out.println("Now, your balance is"+initial);
                    break;
                case 4:
                    System.out.println("How much kg you want to buy: ");
                    kg = zen.nextInt();
                    initial-=(kg*200);
                    System.out.println("Total is "+kg*200);
                    System.out.println("Now, your balance is"+initial);
                    break;
                case 5:
                    System.out.println(initial);
                    break;
                case 7:
                    System.exit(0); 
                    break;
                }
        } while(take != 6);
        

    }

    @Override
    void playGame() {
        System.out.println("\n\t\t***GAMING***\n");

        do {
        System.out.println("\t1. TicTacToe");
        System.out.println("\t2. Quizes Game");
        System.out.println("\t3. Back");
        System.out.println("\t4. Exit");
        System.out.print("\tWhere would you like to go:");
        choice = zen.nextInt();
        
            switch (choice) {
                case 1:
                    ttt.ticTacToeGame();
                    break;
                case 2:
                    mcq.mcqGame();
                    break;
                case 4:
                    System.exit(0);
            }
        } while(choice != 3);
        
    }

    @Override
    double banking() {
        double newAmount;
        
        while(!false) {
            System.out.println("\n\t***Welcome to Bank***\n");
            
            do {
                System.out.println("1. Deposite");
                System.out.println("2. With-draw");
                System.out.println("3. Check Amount");
                System.out.println("4. Back");
                System.out.println("5. Exit");
                System.out.print("\nEnter your choice, Sir: ");
                choice = zen.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter the amount, you want to deposit: ");
                        newAmount = zen.nextDouble();
                        initial+=newAmount;
                        System.out.println("You entered "+newAmount);
                        System.out.println("Now, the Total Amount is "+initial+"\n");
                        break;
                    case 2:
                        System.out.print("Enter the amount, you want to withdraw: ");
                        newAmount = zen.nextDouble();
                        initial-=newAmount;
                        System.out.println("You entered "+newAmount);
                        System.out.println("Now, the remaining amount is "+initial+"\n");
                        break;
                    case 3:
                        System.out.println("The Total amount present is "+initial+"\n");
                        break;
                    case 5:
                        System.exit(0);
                }
            } while(choice != 4);
            
        return initial;
        }
    }

}

class TicTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> cpuPositions = new ArrayList<>();

    public void ticTacToeGame() {
        
        Scanner zen = new Scanner(System.in);

        char[][] gameBoard = {{' ','|',' ','|',' '},
						      {'-','+','-','+','-'},
						      {' ','|',' ','|',' '},
						      {'-','+','-','+','-'},
						      {' ','|',' ','|',' '}};

            printGameBoard(gameBoard);
                          
            while(!false) {
                              
                System.out.print("Enter your placement(1-9):");
                int playerPos = zen.nextInt();
                              
                while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
                    System.out.print("Positions taken! Enter a valid position:");
                    playerPos = zen.nextInt();
                }
                              
                placePiece(gameBoard, playerPos, "player");
                              
                String result = checkWinner();
                if(result.length() > 0) {
                    System.out.println(result);
                    break;
                }
                              
                Random rand = new Random();
                int cpuPos = rand.nextInt(9)+1;
                              
                while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
                    cpuPos = rand.nextInt(9)+1;
                }
                              
                placePiece(gameBoard, cpuPos, "cpu");
                              
                printGameBoard(gameBoard);
                              
                result = checkWinner();

                if(result.length() > 0) {
                    System.out.println(result);
                    break;
                }
                              
            }

    }

    public static void printGameBoard(char[][] gameBoard) {

		for(char[] row : gameBoard) {
			for(char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	public static void placePiece(char[][] gameBoard, int pos, String user) {
		
		char symbol = 'X';
		
		if(user.equals("player")) {

			symbol = 'X';
			playerPositions.add(pos);
		} else if(user.equals("cpu")) {

			symbol = 'O';
			cpuPositions.add(pos);
		}
		
		switch(pos) {
			case 1:
				gameBoard[0][0] = symbol;
				break;
			case 2:
				gameBoard[0][2] = symbol;
				break;
			case 3:
				gameBoard[0][4] = symbol;
				break;
			case 4:
				gameBoard[2][0] = symbol;
				break;
			case 5:
				gameBoard[2][2] = symbol;
				break;
			case 6:
				gameBoard[2][4] = symbol;
				break;
			case 7:
				gameBoard[4][0] = symbol;
				break;
			case 8:
				gameBoard[4][2] = symbol;
				break;
			case 9:
				gameBoard[4][4] = symbol;
				break;
			default:
				System.out.println("enter the right position");
				break;
		}
	}
	
	public static String checkWinner() {
		
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List botRow = Arrays.asList(7,8,9);
		List firstCol = Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List lastCol = Arrays.asList(3,6,9);
		List cross1 = Arrays.asList(1,5,9);
		List cross2 = Arrays.asList(3,5,7);
		
		List<List> winning = new ArrayList<>();

		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(firstCol);
		winning.add(midCol);
		winning.add(lastCol);
		winning.add(cross1);
		winning.add(cross2);
		
		for(List l: winning) {
			if(playerPositions.containsAll(l)) {
				return "Congratulations, You Won!";
			} else if(cpuPositions.containsAll(l)){
				return "CPU wins";
			} else if(playerPositions.size() + cpuPositions.size() == 9) {
				return "CAT!";
			}
		}
		
		return "";
	}
}

class MCQs {
	public void mcqGame() {
		
		Scanner zen = new Scanner(System.in);
		
		String[] answers = {"a","a","b","a","a"};
		String[] responses = {"","","","",""};
		
		System.out.println("What is Java?");
		System.out.println("a) Java is a high-level programming language.\r\n"
			           	 + "b) Java is a type of coffee.\r\n"
				         + "c) Java is a database management system.\r\n"
				         + "d) Java is a web browser.\n");
		System.out.print("Enter your answer: ");
		responses[0] = zen.next();
		System.out.println();

		System.out.println("What is the main difference between JDK, JRE, and JVM?");
		System.out.println("a) JDK stands for Java Development Kit, JRE stands for Java Runtime Environment, and JVM stands for Java Virtual Machine.\r\n"
				         + "b) JDK is used for running Java programs, JRE is used for developing Java programs, and JVM is used for debugging Java programs.\r\n"
		       		     + "c) JDK, JRE, and JVM are all the same things.\r\n"
			         	 + "d) JDK is used for compiling Java programs, JRE is used for executing Java programs, and JVM is used for managing memory in Java programs.\n");
		System.out.print("Enter your answer: ");
		responses[1] = zen.next();
		System.out.println();

		System.out.println("What is a constructor in Java?");
		System.out.println("a) A constructor is a method used to destroy objects in Java.\r\n"
						 + "b) A constructor is a method used to initialize objects in Java.\r\n"
						 + "c) A constructor is a method used to execute Java bytecode.\r\n"
						 + "d) A constructor is a method used to define variables in Java.\n");
		System.out.print("Enter your answer: ");
		responses[2] = zen.next();
		System.out.println();

		System.out.println("What is the difference between an abstract class and an interface in Java?");
		System.out.println("a) An abstract class can have concrete methods whereas an interface cannot.\r\n"
			  	         + "b) An interface can have fields whereas an abstract class cannot.\r\n"
				         + "c) An abstract class can be instantiated whereas an interface cannot.\r\n"
				         + "d) An interface can extend multiple classes whereas an abstract class cannot.\n");
		System.out.print("Enter your answer: ");
		responses[3] = zen.next();
		System.out.println();

		System.out.println("What is the purpose of the 'static' keyword in Java?");
		System.out.println("a) It is used to make a variable or method belong to the class rather than to instances of the class.\r\n"
				         + "b) It is used to declare a variable constant in Java.\r\n"
				         + "c) It is used to specify that a method cannot be overridden.\r\n"
				         + "d) It is used to allocate memory to objects in Java.");
		System.out.print("Enter your answer: ");
		responses[4] = zen.next();
		System.out.println();
		
		int score = 0;
		
		for(int i=0; i<responses.length; i++) {
			if(responses[i].equalsIgnoreCase(answers[i])) {
				score++;
			}
		}
		
		System.out.println("Your Score is "+score+" out of 5.");

        if(score == 5) {
            System.out.println("\tWell done!");
        } else if(score == 4) {
            System.out.println("\tNot Bad!");
        } else if(score == 3) {
            System.out.println("\tAverage!");
        } else if(score == 2 || score == 1 || score == 0) {
            System.out.println("\tVery Bad!");
        }

	}

}

public class City {
    public static void main(String[] args) {
        Entry e = new Entry();
    }

}
