package edu.jcu.weakqueens;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSuite {
  long a;
  int x1;
  int x2;
  int y1;
  int y2;
  boolean test;

  @Test
  public void test3_2() {
    int[] board = new int[3];
    a = Solver.solve(3, 2, 0, board);
    assertEquals(27, a);
  }

  @Test
  public void test3_1() {
    int[] board = new int[3];
    a = Solver.solve(3, 1, 0, board);
    assertEquals(2, a);
  }

  @Test
  public void test3_0() {
    int[] board = new int[3];
    a = Solver.solve(3, 0, 0, board);
    assertEquals(0, a);
  }

  @Test
  public void testThreatened1() {
    test = Solver.threatened(0, 1, 0, 3, 4, 0);
    assertFalse(test);
  }

  @Test
  public void testThreatened2() {
    test = Solver.threatened(0, 2, 0, 2, 4, 1);
    assertTrue(test);
  }

  @Test
  public void testThreatened3() {
    test = Solver.threatened(3, 1, 3, 1, 5, 1);
    assertTrue(test);
  }

  @Test
  public void testThreatened4() {
    test = Solver.threatened(3, 1, 3, 1, 5, 2);
    assertTrue(test);
  }

  @Test
  public void testThreatened5() {
    test = Solver.threatened(3, 1, 3, 1, 5, 3);
    assertFalse(test);
  }

  @Test
  public void testIterateEmptyBoard() {
    int[] testBoard = {};

    assertArrayEquals(Solver.iterateQueens(testBoard), testBoard);
  }

  @Test
  public void testIterateResetBoard() {
    int[] testBoard = {3, 3, 3, 3};
    int[] expectedBoard = {0, 0, 0, 0};

    assertArrayEquals(Solver.iterateQueens(testBoard), expectedBoard);
  }

  @Test
  public void testIterateNormalBoard() {
    int[] testBoard = {6, 2, 3, 5, 3, 4};
    int[] expectedBoard = {0, 2, 3, 5, 3, 5};

    assertArrayEquals(Solver.iterateQueens(testBoard), expectedBoard);
  }

  @Test
  public void testIterateConsecutivePlacesBoard() {
    int[] testBoard = {6, 2, 3, 5, 5, 5};
    int[] expectedBoard = {0, 2, 4, 0, 0, 0};

    assertArrayEquals(Solver.iterateQueens(testBoard), expectedBoard);
  }
}
