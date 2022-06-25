/**
* Circle class.
*/
class Circle implements Comparable{
  private static final double PI = 3.14;
  private double radius;

  /**
  * Defualt Constructor.
  * pre: none
  * post: Circle object created. Radius initialized to 1.
  */
  public Circle() {
    radius = 1;
  }

  /**
  * Main Constructor.
  * pre: none
  * post: A Circle object created with radius r.
  * - If 'r' is smaller than 0, radius is set to 0 instead.
  * @param  r     the double value of the sent in radius.
  */
  public Circle(double r) {
    radius = (r<0)? 0:r;
  }

  //-----------------------------------------
  
  /**
  * 'setRadius' Method: Changes the radius of the circle.
  * pre: none
  * post: Radius was changed to sent in 'newRadius'.
  * - If 'newRadius' is smaller than 0, radius is set to 0 instead.
  * @param  newRadius     the double value of the new radius.
  */
  public void setRadius(double newRadius) {
    radius = (newRadius<0)? 0:newRadius; //default radius
  }
  
  /**
  * 'getRadius' Method: Returns the radius of the circle.
  * pre: none
  * post: The radius of the circle has been returned.
  * @return        double representing the object's radius.
  */
  public double getRadius() {
    return(radius);
  }

  /**
  * 'equals' Method: Determines if the object is equal to another Circle object.
  * pre: 'c' is a Circle object.
  * post: true has been returned if the objects have the same radius. 
  * false has been returned otherwise.
  * @param  c     The object to which the calling object is compared to.
  * @return       true if object equal, false if objects dont equal.
  */
  public boolean equals(Object c) {
    Circle testObj = (Circle)c;
    return (testObj.getRadius() == this.radius);
  }

  /**
  * 'toString' : Returns a String that represents the Circle object.
  * pre: none
  * post: A string representing the Circle object has been returned.
  * @return       String telling the radius of the Circle object.
  */
  public String toString() {
    return "Circle has radius " + radius;
  }

  //-----------------------------------------

  /**
  * 'area' Method: Calculates the area of the circle.
  * pre: none
  * post: The area of the circle (rounded to 2 decimal spaces) was returned.
  * @return       double containing the area of the Circle.
  */
  public double area() {
    return Math.round((PI*radius*radius)*100)/100.0;
  }

  /**
  * 'circumference' Method: Returns the circumference of the circle.
  * pre: none
  * post: The circumference of the circle (rounded to 2 decimal spaces) was returned.
  * @return       double containing the circumference of the Circle.
  */
  public double circumference() {
    return Math.round((2*PI*radius)*100)/100.0;
  }

  /**
  * 'compareTo' Method:
  * Determines if object c is smaller, the same, or larger than calling object.
  * pre: c is a Circle object
  * post: -1 has been returned if c is larger than this Circle,
  * 0 has been returned if they are the same size, 
  * and 1 has been returned if c is smaller then this Circle.
  * @param  c     The object to which the calling object is compared to.
  * @return       integer of -1, 0 or 1 based on above catagories.
  */
  public int compareTo(Object c) {
    Circle testCircle = (Circle)c;
    if (radius < testCircle.getRadius()) return(-1);
    else if (radius == testCircle.getRadius()) return(0);
    else return(1);
  }

  //-----------------------------------------

  /**
  * 'displayAreaFormula' Method: Displays the formula for the area of a circle.
  * pre: none
  * post: The formula for area of a circle has been displayed.
  */
  public static void displayAreaFormula() {
    System.out.println("The formula for the area of a circle is a=Pi*r*r");
  }
}