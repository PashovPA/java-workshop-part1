package edu.spbu.matrix;

public class SparseMatrix implements Matrix {
  int height, width;
  double[][] matrix;

  SparseMatrix(double[][] matrix) {
    this.height = matrix.length;
    this.width = matrix[0].length;
    this.matrix = matrix;
  }

  public SparseMatrix(String fileName) {
    return;
  }

  @Override
  public String toString() {
    return null;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public Matrix mul(Matrix o) {
    return null;
  }

  private Matrix mul(SparseMatrix o) {
    return null;
  }

  private Matrix mul(DenseMatrix o) {
    return null;
  }

  @Override
  public Matrix dmul(Matrix o) {
    return null;
  }

  @Override public boolean equals(Object o) {
    return false;
  }
}

