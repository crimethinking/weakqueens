package edu.jcu.zgray_dnguyen_dwallett;
 
/* Authors: Zakary Gray, Duy Nguyen, David Wallett
 * Date:    4/29/18
 * 
 * Project Euler #534 - Weak Queens implementation
 * 
 * Calculate the total number of board configs for an nxn board of n queens
 * wherein the queens can move w less spaces vertically and diagonally.
 * 
 * Main method */

public class WeakQueens {
  public static void main(String[] args) {
    /* get number of queens and weakness from user input */
    int n = Input.getNumQueens();
    int w = Input.getWeakness();
    
    /* rerun the program if weakness >= number of queens */
    if (w >= n) {
      main(args);
    }
    
    /* initialize board and variable to store number of solutions */
    int[] board = new int[n];
    long a = 0;
    
    System.out.println("\nRunning...");
    
    /* run solve method */
    a = Solver.solve(n, w, a, board);
    
    /* print out the number of configurations */
    System.out.println(n + " queen(s) with weakness " + w 
                         + " can be placed on a " + n 
                         + "x" + n + " board in " + a + " way(s).");
  }
}
