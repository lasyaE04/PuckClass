/*
* Assigment.
* 1. Lasya Erukulla
* 2. Taya Kostyleva
* Date: March 17, 2021 - March 22, 2021.
* Discription: Builds a Puck class that inherits the Disk class. Main code derives the input from the client needed to create the Puck object 
*/

//Brining in input.
import java.io.*;

class Main {
  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String answer = "";
    Puck test;
    int pAmount = 0;
    boolean valid = false;

    do {
      try {
        System.out.println("What would you like to do?");
        System.out.println("See Existing Tests (1) or Conduct a Test Yourself (2) ?");
        answer = br.readLine();

        if (!answer.equals("1") && !answer.equals("2")) {
          throw new IOException("Invalid input. Only exepting either 1 or 2.");
        }
        valid = true;
      } catch (IOException err) {
        System.out.println("Error reading input.");
      }
    } while(!valid);

    if (answer.equals("1")) {
      tests();
    }
    else {
      test = puckIn();
      pAmount = amountIn();

      Puck[] exPuck = Puck.menu(pAmount, test);
      System.out.println(Puck.shipPucks(exPuck));
      Puck.formatText(exPuck);
    }
  }

  /**
  * 'puckIn' Public Class Method.
  * Post: Gets the user's radius, thickness & weight varaibles.
  * - Radius & thickness cannot be smaller than 1 or bigger than 5.
  * - Weight cannot be smaller than 0.5 or bigger than 10.
  * - The entered characters must be integers.
  * @return      Puck Object
  */
  public static Puck puckIn() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    boolean valid = false;
    String enter[] = {"radius", "thickness", "weight"};
    double varIn[] = {0.0, 0.0, 0.0};

    do {
      System.out.println("Radius / Thickness Limit: 1 - 5 inches");
      System.out.println("Weight Limit: 0.5 - 10 ounces");
      for (int i = 0; i < varIn.length; i++) {
        try {
          System.out.println("Please enter a "+enter[i]+":");
          varIn[i] = Double.parseDouble(br.readLine());
          
          //IF statements didnt want to work with varIn[0]...
          if (i == 0 || i == 1) {
            if (varIn[i] < 1 || varIn[i] > 5)
              throw new NumberFormatException();
          }

          if (i == 2) {
            if (varIn[i] < 0.5 || varIn[i] > 10)
              throw new NumberFormatException();
          }
          valid = true;
        } catch (IOException err) {
          System.out.println("Error reading input.");
          i--;
        } catch (NumberFormatException err) {
          System.out.println("Error with number.");
          i--;
        }
      }
    }  while(!valid);
    return new Puck(varIn[2], varIn[0], varIn[1]);
  }

  /**
  * 'amountIn' Public Class Method.
  * Post: Gets the amount of pucks the user wishes to "buy".
  * - Amount must be an integer, no smaller than 1 or bigger than 100.
  * @return      integer
  */
  public static int amountIn() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int amount = 0;
    boolean valid = false;
    System.out.println("Amount of pucks must be between 1 and 100.");
    do {
      try {
        System.out.println("Enter the amount of pucks you wish to buy:");
        amount = Integer.parseInt(br.readLine());

        if (amount < 1 || amount > 100)
          throw new NumberFormatException();

        valid = true;
      } catch (IOException err) {
        System.out.println("Error reading input.");
      } catch (NumberFormatException err) {
        System.out.println("Error with number.");
      }
    } while (!valid);

    return amount;
  }

  /**
  * 'tests' Public Class Method.
  * Post: Outputs the tests conducted with the 'Puck' class.
  */
  public static void tests() {
    Puck[] puckArray = new Puck[5];
    //defaulted = 0, weighted = 1, normal = 2, divStandart = 3, divYouth = 4.
    puckArray[0] = new Puck();
    puckArray[1] = new Puck(7.0);
    puckArray[2] = new Puck(6.2, 4.3, 1.9);

    Circle c1 = new Puck(-8);
    Puck antiGraviti = (Puck)c1;

    Object o1 = new Puck(-5.4, -2, 0);
    Puck nonExist = (Puck)o1;

    Disk d1 = new Puck(4.3);
    Puck weightTester = (Puck)d1;

    puckArray[3] = new Puck(5.5);
    puckArray[4] = new Puck(3.9);

    //Constructors & toString:
    System.out.println("\f"+puckArray[0]);
    System.out.println("\f"+puckArray[1]);
    System.out.println("\f"+antiGraviti);
    System.out.println("\f"+puckArray[2]);
    System.out.println("\f"+nonExist);
    System.out.println("\f"+weightTester);

    //setWeight & getWeight:
    weightTester.setWeight(-5.9);
    System.out.println("\fNew Weight: "+weightTester.getWeight());
    weightTester.setWeight(5.9);
    System.out.println("New Weight: "+weightTester.getWeight());

    //getDivision & setDivision:
    System.out.println("\fPuck Division: "+puckArray[3].getDivison());
    puckArray[3].setWeight(5.7);
    System.out.println("Puck Division: "+puckArray[3].getDivison());
    puckArray[3].setWeight(6.1);
    System.out.println("Puck Division: "+puckArray[3].getDivison());
    puckArray[3].setWeight(6);
    System.out.println("Puck Division: "+puckArray[3].getDivison());

    System.out.println("\fPuck Division: "+puckArray[4].getDivison());
    puckArray[4].setWeight(4);
    System.out.println("Puck Division: "+puckArray[4].getDivison());
    puckArray[4].setWeight(4.2);
    System.out.println("Puck Division: "+puckArray[4].getDivison());
    puckArray[4].setWeight(4.6);
    System.out.println("Puck Division: "+puckArray[4].getDivison());
    puckArray[4].setWeight(4.5);
    System.out.println("Puck Division: "+puckArray[4].getDivison());

    //equals method:
    System.out.println("\fDoes defaulted & defaulted equal? "+puckArray[0].equals(puckArray[0]));
    antiGraviti.setWeight(7);
    System.out.println("Does antiGraviti & weighted equal? "+antiGraviti.equals(puckArray[1]));
    System.out.println("Does divYouth & divStandart equal? "+puckArray[4].equals(puckArray[3]));

    //compareTo:
    System.out.println("\fcompareTo antiGraviti & weighted: "+antiGraviti.compareTo(puckArray[1]));
    System.out.println("compareTo nonExist & defaulted: "+nonExist.compareTo(puckArray[0]));
    System.out.println("compareTo defaulted & nonExist: "+puckArray[0].compareTo(nonExist));
  }
}