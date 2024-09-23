package coreservlets;

/** Simple utilities for random numbers and random colors.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, 
 *  Spring, Hibernate/JPA, and Java programming</a>.
 */

public class ColorUtils {
  // The official HTML color names.
  private static String[] colors = {
    "aqua", "black", "blue", "fuchsia", "gray", "green", "lime", "maroon",
    "navy", "olive", "purple", "red", "silver", "teal", "white", "yellow" };

  /** One of the official HTML color names, at random. */
  
  public static String randomColor() {
    return(RandomUtils.randomElement(colors));
  }
  
  private ColorUtils() {}  // Uninstantiatable class
  
  public static void main(String[] args) {
    for(int i=0; i<100; i++) {
      System.out.println("Random color: " + randomColor());
    }
  }
}
