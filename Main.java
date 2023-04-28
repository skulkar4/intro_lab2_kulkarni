import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      
      boolean[] chptList = new boolean[16]; // Valid chapters are 1-15. 1 means include, 0 exclude. Element 0 unused. 
      int includeChpt;
      boolean atLeastOne = false;
      int i, j;
      
      // Get the chapter selections
      for (i = 1; i <= 15; ++i) {
         includeChpt = scnr.nextInt(); 
         if (includeChpt==1) {
            chptList[i] = true;
         }
         else {
            chptList[i] = false;
         }
      }
      
      // Output the chapter selections, using ranges like 2-4 for ranges of 3-or-more
      for (i = 1; i <= 15; ++i) {  // Note: Loop body may advance i
         if (chptList[i]) { // Output this number
            System.out.print(i); // Output this number, followed either by "-X " for a range that goes to X, else just " ". 
            atLeastOne = true;
            if ( (i <= 13) &&  // Possible 3-or-more range
                 (chptList[i + 1] && chptList[i + 2] )) { // 3-or-more range found. Note: Short-circuit evaluation important
               // Find end of range
               j = i + 2; // Last 1 seen so far in the range
               while ( (j <= 14) && (chptList[j + 1]) ) { // Range continues...  Note: Short-circuit evaluation important
                  j += 1; // ...so extend the range
               }
               System.out.print("-" + j + " ");
               i = j; // Set i to end of range, so next for loop iteration will start at the next number
            }
            else {
               System.out.print(" "); // No 3-or-more range, so just output a space after the number
            } 
         }
      }
      if (!atLeastOne) { // No chapters were selected
         System.out.print("None ");
      }
      System.out.println();
   }
}
