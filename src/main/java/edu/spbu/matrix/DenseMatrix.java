package edu.spbu.matrix;

import java.util.*;
import java.io.*;


public class DenseMatrix implements Matrix
{
  private int height, width;
  double[][] matrix;

  public DenseMatrix(double[][] matrix) {
      this.height = matrix.length;
      this.width = matrix[0].length;
      this.matrix = matrix;
  }

  public DenseMatrix(String fileName) throws RuntimeException {
    try {
      String[] stringRow;
      double[] doubleRow;
      ArrayList<double[]> temp = new ArrayList<>();
      Scanner data = new Scanner(new File(fileName));

      while (data.hasNextLine()) {
        stringRow = data.nextLine().split("\\s+");
        doubleRow = new double[stringRow.length];
        for (int i = 0; i < doubleRow.length; i++) {
          doubleRow[i] = Double.parseDouble(stringRow[i]);
        }
        temp.add(doubleRow);
      }

      double[][] matrix = temp.toArray(new double[temp.size()][]);

      this.matrix = matrix;
      this.height = matrix.length;
      this.width = matrix[0].length;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override public String toString() {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < this.height; ++i) {
      for(int j = 0; j < this.width; ++j) {
        sb.append(matrix[i][j]).append(" ");
      }
      sb.append("\n");
    }

    return sb.toString();
  }

  @Override public Matrix mul(Matrix o) throws RuntimeException
  {
    if (this.width != o.getHeight()) {
      throw new RuntimeException("Операция невозможна : матрицы не имеют подходящих размеров!");
    }
    if (o instanceof DenseMatrix) {
      return mul((DenseMatrix) o);
    } else if (o instanceof SparseMatrix) {
      return mul((SparseMatrix) o);
    }

    return null;
  }

  private DenseMatrix mul( DenseMatrix o) {
    int newHeight = this.height, newWidth = o.getWidth();
    o = o.transpose();

    double[][] out = new double[newHeight][newWidth];
    for (int i = 0; i < newHeight; ++i) {
      for (int j = 0; j < newWidth; ++j) {
        for (int k = 0; k < this.width; ++k) {
          out[i][j] += this.matrix[i][k] * o.matrix[j][k];
        }
      }
    }

    return new DenseMatrix(out);
  }

  @Override public Matrix dmul(Matrix o)
  {
    return null;
  }

  @Override public boolean equals(Object o) {
    if (o == this) {
      return true;
    }

    if (o instanceof DenseMatrix) {
      DenseMatrix dm = (DenseMatrix) o;

      if ((this.width == dm.getWidth()) && (this.height == dm.getHeight())) {
        for (int i = 0; i < this.height; ++i) {
          for (int j = 0; j < this.width; ++j) {
            if (this.matrix[i][j] != dm.matrix[i][j]) {
              return false;
            }
          }
        }
        return true;
      }
    }

    if (o instanceof SparseMatrix) {
      return false;
    }

    return false;
  }

  @Override public double get(int i, int j) {
    return this.matrix[i][j];
  }

  @Override public int getHeight() {
    return this.height;
  }

  @Override public int getWidth() {
    return this.width;
  }

  public DenseMatrix transpose() {
    double[][] out = new double[this.width][this.height];
    for (int i = 0; i < this.height; ++i) {
      for (int j = 0; j < this.width; ++j) {
        out[j][i] = this.matrix[i][j];
      }
    }
    return new DenseMatrix(out);
  }
}

