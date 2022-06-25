/**
* Disk class.
*/
public class Disk extends Circle implements Comparable {
  private double thickness;
  
  /**
  * Main constructor
  * pre: none
  * post: A Disk object has been created with radius 'r' and thickness 't'.
  * - if 't' is bellow 0, setting the thickness to 0.
  * @param radius       the double value of the sent in radius. 
  * @param thickness    the double value of the sent in thickness. 
  */
  public Disk(double radius, double thickness) {
    super(radius);
    this.thickness = (thickness<0)? 0:thickness;
  }

  //-----------------------------------------
  
  /**
  * 'setThickness' Method: Changes the thickness of the disk.
  * pre: none
  * post: Thickness has been changed.
  * - 't' cannot be lower than 0, set thickness to 0 if it is.
  * @param newThickness    the double value of the new thickness. 
  */
  public void setThickness(double newThickness) {
    thickness = (newThickness<0)? 0:newThickness;
  }

  /**
  * 'getThickness' Method: Returns the thickness of the disk.
  * pre: none
  * post: The thickness of the disk has been returned.
  * @return     double containing the thickness of the object.
  */
  public double getThickness() {
    return(thickness);
  }

  /**
  * 'equals' Method: Determines if the object is equal to another Disk object.
  * pre: d is a Disk object.
  * post: true has been returned if objects have the same radius and thickness. 
  * false has been returned otherwise.
  * @param d          the object to which the calling object is compared to.
  * @return           false if objects are'nt equal, true if objects are equal.
  */
  public boolean equals(Object d) {
    Disk testObj = (Disk)d;
    return (super.equals(testObj) && testObj.getThickness() == this.thickness);
  }

  /**
  * 'toString' Method: Returns a String that represents the Disk object.
  * pre: none
  * post: A string representing the Disk object was returned.
  * @return           String displaying the object's varaibles.
  */
  public String toString() {
    return "The disk has radius " + super.getRadius() + " and thickness " + thickness + ".";
  }

  /**
  * 'compareTo' Method: 
  * Determines if object d is smaller, the same, or larger than calling object.
  * pre: d is a Disk object
  * post: -1 has been returned if d is larger than this Disk, 
  * 0 has been returned if they are the same size, 
  * and 1 has been returned if d is smaller then this Disk.
  * @param d          the object to which the calling object is compared to.
  * @return           integer based on the above catagories.
  */
  public int compareTo(Object d) {
    Disk test = (Disk)d;
    if(this.volume() == test.volume()) return (0);
    else if(this.volume() > test.volume()) return (1);
    return (-1);
  }

  //-----------------------------------------
  
  /**
  * 'volume' Method: Returns the volume of the disk.
  * pre: none
  * post: The volume of the disk (rounded to 2 decimal spaces) was returned.
  * @return           double representing the volume of the object.
  */
  public double volume() {
    return Math.round((super.area() * thickness)*100)/100.0;
  }
}