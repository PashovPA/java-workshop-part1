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
          throw new RuntimeException("Unable to load matrix from " + fileName + ": rows have different length!");
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


  /**
   * однопоточное умнджение матриц
   * должно поддерживаться для всех 4-х вариантов
   *
   * @param o
   * @return
   */
  @Override public Matrix mul(Matrix o)
  {
    return null;
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
    return false;
  }

}
