# Task List:
###### Do not add aditional data or functunality unless grated premision to do so.
###### Testing Doc: [Google Doc] (https://docs.google.com/document/d/129G9cQFrtQVjPNFjubYaBIruZz1PlI_jlmPFAySZ7b4/edit?usp=sharing)  |  Cylinder Visualizer: [Visualizer] (https://www.matheretter.de/calc/cylinder)
---
1. [x] Copy all the `Circle` & `Disk` class details from exersize 118.
    - Dont modify the acess levels of the variables.
    - Improve methods for eficency and that they dont allow imposible dimentions.
    - Comment headers & code maintanance.


2. [x] `Puck` inherits the `Disk` class and `comparable interface`.

---

3. [x] `Puck` includes the memeber varaibles `weight`, `standard`, `youth` & `serialNum`.
    - Must be encapsualted.
    - `standard` & `youth`are `boolean` varaibles. They are set to `TRUE` or `FALSE` depending on the `weight` of puck object and whether the puck has 'Official' `radius` & `thickness`.
    - When both `booleans` are false, puck object is concidered "Non-Regulation".
    - When `standard` is `TRUE` it is concidered "Official Standard".
    - When `youth` is `TRUE` it is concidered "Official Youth".


o Official hockey pucks are always 1 inch thick and have a 3 inch diameter.
o An official standard puck weighs between 5.5 and 6 ounces (both inclusive)
o An official youth puck weighs between 4 and 4.5 ounces. (both inclusive)
o Any other puck would be a NON-REGULATION (unofficial) puck.

---

4. [x] Should include a static class variable `serialValue`.
    - Should be initialized to `100000`.
    - Each new `Puck` object should have a special serial number. Must always be `50` more than the previous object.

---

5. [x] Make a constructor with no parameters.
    - Intilizes `weight` to 1 oz, `radius` to 1.5 inch & `thickness` to 1 inch.


6. [x] Make a second constructor with `weight` parameter.
    - Intilizes `radius` to 1.5 inch & `thickness` to 1 inch.


7. [x] Make a third constructor with all the parameter (`wight`, `radius` & `thickness`.)


o Be sure that the constructors initialize other variables to appropriate values as necessary.
o Use inheritance appropriately.
o Avoid redundancy.


---

8. [x] Puck should contain the following memeber (instance) methods:
    - `getWeight()` : Returns the `weight` of the puck object.
    - `getDivision()` : Returns  a `String` stating which regulation the puck has. 
      - (Standart, Youth or Non-Regulation.)
    - `setWeight()` : Sets the `weight`of a puck object and updates related fields as well.
    - `setDivision()` : Sets division based on the puck's `weight` & whether they are 'Official'.
    - Comparable Interface `compareTo` : Both pucks are equal when their `weights` are the same.
    - `equals()` : Overrides the Disk `equals` method. Determine if 2 pucks are identical.
    - `toString()` : Overrides the Disk `toString` method. Outputs the following:

Radius: `1.50`"   Thickness: `1.00`"          <--1 Tab used between
Weight: `1.00`oz
This puck is a `Non-Regulation` puck.
Serial Number `100000`

---

Select the following from a Menu:

9. [x] Create a client code in `Main.java` to test the class.
    - Demonstrate Polymorphism – e.g. Attempt to create a Circle from a Puck.
    - ALL methods in your puck class should have associated tests created. This will involve multiple objects being created. Consider the use of an array of objects.

OR:

10. [x] Class method with invocation of `Puck.menu(N, type)`
    - `N` is the amount of pucks a user wishes to purchase. (int from `1 - 100`.)
    - `type` is the puck object.
    - (In the main method, you will need to ask the user for options in order to make the proper selection. (e.g. Ask for weight, etc.) (All inputs must be gathered within the main class).
    - `weight`: from 0.5 oz up to 10oz  |  `thickness` and `radius`: from 1"up to 5"
    - `menu` method returns selection as a puck array.
    - Have the method also print the first and last puck’s details using only the `toString()` method. Include the serial numbers for these pucks.

---

11. [x] Public class method `shipPucks()`.
    - 1 parameter : Puck array (`pucks`) (holding N of those Puck objects.)
      - N is an `int` from 1 - 100.
    - Prints the correct sized container(s) to the console & return the shipping cost for the pucks.
    - Any helper methods used should be in this class and `private`.


  - Contair choices are `large`, `medium` or `small`.
    - Large ($10.00/pkg) 100 oz* | 18”x10”x10”
    - Medium ($8.00/pkg) 65 oz* | 8.2”x6.3”x6.3”
    - Small ($5.00/pkg) 36 oz* | 6”x3.1”x3.1”
  - *indicates maximum allowable weight – Pucks are allowed to hit these dimension limits

---

12. [x] After the user uses the `menu` method, create an invoice (`invoice.txt`).
    - It should list the qauntity of pucks ordered and the total shipping cost formatted exactly as in `FormattedInvoice.txt`.