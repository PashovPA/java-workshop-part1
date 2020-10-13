package edu.spbu.matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Плотная матрица
 */

public class DenseMatrix implements Matrix
{
  private int height, width;
  double[][] array;
  private int hashCode;


  DenseMatrix(int height, int width, double[][] array) {
      this.height = height;
      this.width = width;
      this.array = array;

      this.hashCode = Arrays.deepHashCode(this.array);
  }

  /**
   * загружает матрицу из файла
   *
   * @param fileName
   */

  public DenseMatrix(String fileName) throws RuntimeException {
    this.width = 0;
    this.height = 0;
    LinkedList<double[]> temp = new LinkedList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      String line = br.readLine();
      String[] splitLine = line.split("\\s+");
      double[] matrixRow = new double[splitLine.length];;
      for ( int i = 0; i < splitLine.length; i++) matrixRow[i] = Double.parseDouble(splitLine[i]);
      this.width = matrixRow.length;
      this.height = 1;
      temp.add(matrixRow);

      while ((line = br.readLine()) != null) {

        splitLine = line.split("\\s+");
        for ( int i = 0; i < splitLine.length; i++) matrixRow[i] = Double.parseDouble(splitLine[i]);

        if (matrixRow.length != this.width) {
          throw new RuntimeException("Невозможно загрузить матрицу из файла " + fileName + ": строки имеют разную длину!");
        }

        temp.add(matrixRow);
        ++this.height;
      }

      this.array = new double[this.height][];
      for (int i = 0; i < this.height; ++i) {
        array[i] = temp.get(i);
      }
      this.hashCode = Arrays.deepHashCode(this.array);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override public String toString() {
    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < this.height; ++i) {

      for(int j = 0; j < this.width; ++j) {
        sb.append(array[i][j]).append(" ");
      }
      sb.append("\n");
    }
    return sb.toString();
  }

  /**
   * однопоточное умнджение матриц
   * должно поддерживаться для всех 4-х вариантов
   *
   * @param o
   * @return
   */

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
          out[i][j] += this.array[i][k] * o.array[j][k];
        }
      }
    }

    return new DenseMatrix(newHeight, newWidth, out);
  }

  /**
   * многопоточное умножение матриц
   *
   * @param o
   * @return
   */
  @Override public Matrix dmul(Matrix o)
  {
    return null;
  }

  /**
   * сравнивает с обоими вариантами
   * @param o
   * @return
   */

  @Override public boolean equals(Object o) {
    if (o == this) {
      return true;
    }

    if (o instanceof DenseMatrix) {
      DenseMatrix dm = (DenseMatrix) o;

      if (this.hashCode != dm.hashCode) {
        return false;
      }

      for (int i = 0; i < this.getHeight(); ++i) {
        for (int j = 0; j < this.getWidth(); ++j) {
          if (this.array[i][j] != dm.array[i][j]) {
            return false;
          }
        }
      }
      return true;
    }

    if (o instanceof SparseMatrix) {
      return false;
    }

    return false;
  }

  @Override public double get(int i, int j) {
    return this.array[i][j];
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
        out[j][i] = this.array[i][j];
      }
    }
    return new DenseMatrix(this.width, this.height, out);
  }
}

