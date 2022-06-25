//Brining in input & file functions.
import java.io.*;
import java.util.*;
import java.text.*; 

public class Puck extends Disk implements Comparable {
  private double weight;
  private boolean standard = false;
  private boolean youth = false;
  private int serialNum;
  public static int serialValue = 100000;

  /**
  * Defeault Constructor
  * pre: none
  * post: A Puck object created. 
  * - Radius initialized to 1.5. Thickness intialized to 1. Weight intialized to 1.0.
  */
  public Puck(){
    super(1.50, 1.00);
    setWeight(1.00); //Used setter to reduce redundancy.
    serialNum = serialValue;
    serialValue += 50;
  }

  /**
  * Secondary Constructor
  * pre: none
  * post: A Puck object created. 
  * - Radius initialized to 1.5. Thickness intialized to 1. Weight intialized to w.
  * @param weight       the double value of the sent in weight. 
  */
  public Puck(double weight){
    super(1.50, 1.00);
    setWeight(weight);
    serialNum = serialValue;
    serialValue += 50;
  }

  /**
  * Main Constructor
  * pre: none
  * post: A Puck object created. 
  * - Radius initialized to r. Thickness intialized to t. Weight intialized to w.
  * @param weight       the double value of the sent in weight.
  * @param radius       the double value of the sent in radius.
  * @param thickness    the double value of the sent in thickness.
  */
  public Puck(double weight, double radius, double thickness){
    super(radius, thickness);
    setWeight(weight);
    serialNum = serialValue;
    serialValue += 50;
  }

    //--------------------------------------

  /**
  * 'getWeight' Method: Returns the weight of the puck.
  * pre: none
  * post: The weight of the puck gets returned.
  * @return     double containing the weight of the object.
  */
  public double getWeight() {
    return(weight);
  }

  /**
  * 'getDivison' Method: Returns the divison of the puck.
  * pre: none
  * post: The division of the puck gets returned.
  * @return     String symbolizing the diviosn of the object.
  */
  public String getDivison() {
    setDivision();
    if(standard) return "Standard";
    else if(youth) return "Youth";
    else return "Non-Regulation";
  }

  /**
  * 'setWeight Method: Sets the weight of the puck.
  * pre: none
  * post: The weight of the puck is set.
  * - If weight is smaller than 0, setting the weight to 0.
  * @return     double containing the weight of the object.
  */
  public double setWeight(double weight) {
    return this.weight = (weight<0)? 0:weight;
  }
  
  /**
  * 'setDivision' Method: Sets the divison of the puck.
  * pre: none
  * post: The division of the puck is set.
  * - If the puck has a weight between 5.5 - 6, and is an 'official' puck, standard is true,
  * - If the puck has a weight between 4 - 4.5, and is an 'official' puck, youth is true,
  */
  private void setDivision(){
    standard = (this.weight >= 5.5 && this.weight <= 6 && super.getThickness()== 1 && super.getRadius() == 1.5)? true:false;
    youth = (this.weight >= 4 && this.weight <= 4.5 && super.getThickness() == 1 && super.getRadius() == 1.5)? true:false;
  }
  
    //--------------------------------------

  /**
  * 'equals' Method: Determines if the calling object is equal to another object.
  * pre: p is a Puck object.
  * post: true has been returned if objects have the same weight, radious & thickness. 
  * false has been returned otherwise.
  * @param test       a Puck object to which the calling object is compared to.
  * @return           true if the objects are the same, false if they are not.
  */
  public boolean equals(Puck test) {
    return (this.weight == test.weight && super.equals(test));
  }

  /**
  * 'toString' Method: Returns a String that represents the Puck object.
  * pre: none
  * post: A string representing the Puck object has been returned.
  * @return     formated String displaying all of the object's variables.
  */
  public String toString() {
    return String.format("Radius: %.2f\"\tThickness: %.2f\"\nWeight: %.2foz\nThis puck is a %s puck.\nSerial Number %d",super.getRadius(),super.getThickness(),this.weight,this.getDivison(),this.serialNum);
  }

      //--------------------------------------
  
  /**
  * 'compareTo Method: 
  * Determines if object d is smaller, the same, or larger than this Puck object.
  * pre: d is a Puck object
  * post: -1 has been returned if d has larger wieght than this Puck, 
  * 0 has been returned if they have the same wieght, 
  * and 1 has been returned if d has less wight then this Puck.
  * @param d        an object to which the calling object will be compared to.
  * @return         integer based on the above classification.
  */
  public int compareTo(Object d) {
    Puck test = (Puck) d;
    if(this.weight > test.getWeight()) return 1;
    else if(this.weight == test.getWeight()) return 0;
    return -1;
  }

  /**
  * 'menu' Method: Returns a Pucks array based on the user's entered values.
  * pre: none
  * post: An array of Pucks has been returned and the first and last pucks' 
  * info have been printed.
  * @param numPucks        integer containing how many elements there will
  *                        be in the Puck array.
  * @param type            Puck object to which element of the array will
  *                        be set to.
  * @return                Puck array containing 'numPucks' elements of
  *                        'type' Puck objects.
  */
  public static Puck[] menu(int numPucks, Puck type) {
    Puck[] puckArr = new Puck[numPucks];
    
    for (int i = 0; i < puckArr.length; i++) {
      puckArr[i] = type;
      if (i > 0) puckArr[i].serialNum += 50;

      if (i == (puckArr.length - 1) || i == 0)
        System.out.println(puckArr[i]);
    }
    return puckArr;
  }

  /**
  * 'shipPucks' Method: Determins the container size & price.
  * Pre: A Puck array is sent in.
  * Post: Returning the type of container(s) all the puckscan fit into 
  * as well as the cost of shipping those containers.
  * @param pucks     Puck array used to calculate which shipping containers
  *                  to use.
  * @return          String containing the shipping section of the invoice.
  */
  public static String shipPucks(Puck[] pucks) {
    int numPucksOrdered = pucks.length;
    int lCount = 0, mCount = 0, sCount = 0;
    double weight = 0.0;

    double lBoxVol = 10 * 18 * 10, mBoxVol = 8.2 * 6.3 *6.3, sBoxVol = 6 * 3.1 * 3.1;
    int nPuckLarge = (int) Math.floor(lBoxVol / pucks[0].volume());
    int nPuckMed = (int)Math.floor(mBoxVol / pucks[0].volume());
    int nPuckSmal = (int)Math.floor(sBoxVol / pucks[0].volume());

    int weightFit = (int) Math.floor(100/pucks[0].getWeight());

    do {
      weight = pucks[0].getWeight() * numPucksOrdered;

      if (nPuckSmal >= numPucksOrdered && weight <= 36) {
        sCount++;
        numPucksOrdered = 0;
      }
      else if (nPuckMed >= numPucksOrdered && weight <= 65) {
        mCount++;
        numPucksOrdered = 0;
      }
      else if (nPuckLarge >= numPucksOrdered && weight <= 100) {
        lCount++;
        numPucksOrdered = 0;
      }
      else {
        lCount++;
        if (nPuckLarge > weightFit) numPucksOrdered -= weightFit;
        else numPucksOrdered -= nPuckLarge;
      }
    } while (numPucksOrdered > 0);

    //Calculating cost:
    double cost = sCount * 5.00 + mCount * 8.00 + lCount * 10.00;
    double lCost = lCount * 10.00;
    double subTotal = (2.00 * pucks.length)* 1.13;
    double totAmount = subTotal + cost;
    String totSpace = String.format("%.2f", totAmount);
    
    String toReturn = "\nSHIPPING COST:";

    if (lCount > 0) {
      toReturn += "\n"+ lCount + "x" + "LARGE PKG";
      if (lCount > 1) {
        toReturn += "S";
        toReturn += String.format("%"+( 38 - (""+lCost).length() - (""+lCount).length() )+"s$%.2f", " ", lCost);
      }
      else toReturn += String.format("%"+( 38 - (""+lCost).length() )+"s$%.2f", " ", lCost);
    }
    if (mCount > 0)
      toReturn += String.format("%n%dxMEDIUM PKG%34s$%.2f",mCount,  " ", 8.00);
    
    if (sCount > 0)
      toReturn += String.format("%n%dxSMALL PKG%35s$%.2f", sCount, " ", 5.00);

    toReturn += String.format("\n\nTOTAL SHIPPING COST%"+( 30 - (""+cost).length() )+"s$%.2f", " ", cost);

    toReturn += String.format("%n%nTOTAL AMOUNT%"+( 38 - (""+totSpace).length() )+"s$%.2f", " ",totAmount);

    return toReturn;
  }

  /**
  * 'formatText' Method: Invoice File creator
  * pre: Pucks array
  * post: An invoice is created to the 'invoice.txt' file.
  * @param pucks     Puck array used for the invoice.
  */
  public static void formatText(Puck[] pucks) {
    try {
      FileWriter fw = new FileWriter("invoice.txt");
      PrintWriter pw = new PrintWriter(fw);
      Date date = new Date();
      double diam = pucks[0].getRadius()*2;
      double totWeight = pucks[0].getWeight()*pucks.length;
      double totCost = 2.00 * pucks.length;
      double subTotal = totCost + totCost * 0.13;
      String subSpace = String.format("%.2f", subTotal);

      String plural = "";
      
      pw.printf("* * * * * * * * * * * * * * * * * * * * * * * * * *%n");
      
      pw.printf("%21sINVOICE%n", " ");

      pw.printf("* * * * * * * * * * * * * * * * * * * * * * * * * *%n");
      
      pw.printf("PUCK, PUCK & BEYOND%1$15td-%1$tm-%1$tY  %1$tH:%1$tM%1$Tp%n",date);
      
      pw.printf("- - - - - - - - - - - - - - - - - - - - - - - - - -%n");

      if (pucks.length > 1) plural = "S";
      pw.printf("QTY %d x %S PUCK%s%n", pucks.length, pucks[0].getDivison(), plural);

      if (diam > 1) plural = "ES";
      pw.printf("PUCK DIMENSIONS: DIAM %.2f INCH%s x\n", diam,plural);
      if (pucks[0].getThickness() > 1) plural = "ES";
      pw.printf("%34s%.2f INCH%s THICK%n", " ", pucks[0].getThickness(),plural);
      pw.printf("$2.00 ea. @ %.2foz =>\n", pucks[0].getWeight());
      pw.printf("%12sTOTAL WEIGHT %.2foz%"+(21 - (""+totWeight).length() - (""+totCost).length() )+"s$%.2f%n%n", " ", totWeight, " ", totCost);

      pw.printf("= = = = = = = = = = = = = = = = = = = = = = = = = =%n%n");
      
      pw.printf("SUBTOTAL WITH TAX (13%%)%"+( 27-(""+subSpace).length() )+"s$%.2f", " ", subTotal);
      
      pw.println(shipPucks(pucks));

      pw.printf("- - - - - - - - - - - - - - - - - - - - - - - - - -%n%n");

      pw.printf("* * * * * * * * * * THANK YOU! * * * * * * * * * *");

      pw.close();
    }catch(IOException e){}
  }
}