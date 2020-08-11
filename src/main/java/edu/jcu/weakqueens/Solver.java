package edu.jcu.weakqueens;

/* Authors: Zakary Gray, Duy Nguyen, David Wallett
 * Date:    4/29/18
 * 
 * Project Euler #534 - Weak Queens implementation
 * 
 * Calculate the total number of board configs for an nxn board of n queens
 * wherein the queens can move w less spaces vertically and diagonally.
 * 
 * Algorithm and solver implementation */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solver {
  /* solve method */
  public static long solve(int n, int w, long a, int[] board) {
    double N = n;           /* convert to double for pow operation */
    boolean add = false;    /* determines whether or not to add to a */
    /* total number of possible board configurations */
    long numberOfIterations = (long) Math.pow(N, N);
    
    /* if, then all possible configurations are valid */
    if (n == (w + 1)) {
      a = numberOfIterations;
    } else {
      for (int index = 0; index < numberOfIterations; index++) {
        add = test(board, n, w);    /* run test function */
        
        /* increment a */
        if (add) {
          a++;
          add = false;
        }
        
        /* go to the next configuration of the board */
        board = iterateQueens(board);
      }
    }
    
    return a;
  }
  
  /* chooses pairs of queens to test */
  public static boolean test(int[] board, int n, int w) {
    boolean threatened = false;
    long numThreatened = 0L;  /* used as a switch later */
    
    for (int index = 0; index < board.length; index++) {
      /* choose each possible pair of queens */
      for (int j = index; j < board.length; j++) {
        if (index == j) {
          /* don't test the same queen against itself */
        } else {
          /* test two queens */
          threatened = threatened(board[index], board[j], index, j, n, w);
          if (threatened) {
            numThreatened++;
          } else {
          }
        }
      }
    }
    
    /* if numThreatened ever increases, at least one pair of queens is threatened */
    if (numThreatened != 0) {
      return false;
    } else {
      return true;
    }
  }

  public static boolean threatened(int x1, int x2, int y1, int y2, int n, int w) {
    /* if within vertical range... */
    if (Math.abs(y2 - y1) < (n - w)) {
      /* same column or diagonal */
      if ((Math.abs(x2 - x1) == 0) || (Math.abs(y2 - y1) == Math.abs(x2 - x1))) {
        return true;    /* threatened */
      }
      return false;     /* not threatened */
    } else {
      return false;     /* not threatened */
    }
  }

  public static int[] iterateQueens(int[] board) {
    boolean reset = false;

    /* check for a row position reset to 0 */
    /* if array is empty, return it */
    if (board.length == 0) {
      return board;
      /* if the first queen is at the last position of its row */
    } else if (board[0] == board.length - 1) {
      /* count how many distinct vertical positions of the queens
       * 1 distinct position means that all queens are at the end of their row
       * and their row positions will be reset to 0
       * using hashset */
      Set<Integer> set = new HashSet<Integer>();
      
      for (int i : board) {
        set.add(i);
      }
      
      reset = set.size() == 1;
    } else {
      reset = false;
    }

    /* if reset, return queen array with all 0 */
    if (reset) {
      Arrays.fill(board, 0);
    } else {
      /* iterate queens */
      for (int i = board.length - 1; i >= 0; i--) {
        if (board[i] >= board.length - 1) {
          board[i]++;
        } else {
          board[i]++;
          break;
        }
      }

      for (int i = board.length - 1; i >= 0; i--) {
        if (board[i] >= board.length) {
          board[i] = 0;
        }
      }
    }
    
    return board;
  }
}
