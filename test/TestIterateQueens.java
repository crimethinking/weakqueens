package edu.jcu.zgray_dnguyen_dwallett;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestIterateQueens {
  @Test
  public void testEmptyBoard() throws Exception {
    int[] testBoard = {};
    
    assertArrayEquals(Solver.iterateQueens(testBoard), testBoard);
  }
  
  @Test
  public void testResetBoard() throws Exception {
    int[] testBoard = {3, 3, 3, 3};
    int[] expectedBoard = {0, 0, 0, 0};
    
    assertArrayEquals(Solver.iterateQueens(testBoard), expectedBoard);
  }
  
  @Test
  public void testNormalBoard() throws Exception {
    int[] testBoard = {6, 2, 3, 5, 3, 4};
    int[] expectedBoard = {0, 2, 3, 5, 3, 5};
    
    assertArrayEquals(Solver.iterateQueens(testBoard), expectedBoard);
  }
  
  @Test
  public void testConsecutivePlacesBoard() throws Exception {
    int[] testBoard = {6, 2, 3, 5, 5, 5};
    int[] expectedBoard = {0, 2, 4, 0, 0, 0};
    
    assertArrayEquals(Solver.iterateQueens(testBoard), expectedBoard);
  }
}
