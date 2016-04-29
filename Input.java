package edu.jcu.zgray_dnguyen_dwallett;

/* Authors: Zakary Gray, Duy Nguyen, David Wallett
 * Date:    4/29/18
 * 
 * Project Euler #534 - Weak Queens implementation
 * 
 * Calculate the total number of board configs for an nxn board of n queens
 * wherein the queens can move w less spaces vertically and diagonally.
 * 
 * Input handlers */

import java.util.Scanner;

public class Input {
  /* get number of queens from user */
  @SuppressWarnings("resource")
  public static int getNumQueens() {
    Scanner reader = new Scanner(System.in);
    System.out.println("\nEnter a board size/number of queens: ");
    int n = reader.nextInt();
    
    return n;
  }

  /* get weakness from user */
  @SuppressWarnings("resource")
  public static int getWeakness() {
    Scanner reader = new Scanner(System.in);
    System.out.println("Enter a weakness for the queens: ");
    int w = reader.nextInt();
    
    return w;
  }
}
