package edu.spbu.matrix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MatrixTest
{
  /**
   * ожидается 4 таких теста
   */

  @Test
  public void mulDD() {
    Matrix m1 = new DenseMatrix("m1.txt");
    Matrix m2 = new DenseMatrix("m2.txt");
    Matrix expected = new DenseMatrix("result.txt");
    assertEquals(expected, m1.mul(m2));
  }

  @Test
  public void testString() {
    Matrix m1 = new DenseMatrix("m1.txt");
    System.out.println(m1.toString());
  }

  @Test
  public void testEqualsTrue() {
    Matrix m1 = new DenseMatrix("m1.txt");
    Matrix m2 = new DenseMatrix("m1.txt");
    assertTrue(m1.equals(m2));
  }
  @Test
  public void testEqualsFalse() {
    Matrix m1 = new DenseMatrix("m1.txt");
    Matrix m2 = new DenseMatrix("m2.txt");
    assertFalse(m1.equals(m2));
  }
}
