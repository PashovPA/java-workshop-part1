package edu.spbu.matrix;

import java.util.*;
import java.io.*;

/**
 * Разряженная матрица
 */
public class SparseMatrix implements Matrix {
  private int height, width;
  int[] rows, cols;
  double[] values;
  private int hashCode;

  SparseMatrix(int height, int width, int[] rows, int[] cols, double[] values) {
    this.height = height;
    this.width = width;
    this.rows = rows;
    this.cols = cols;
    this.values = values;

    this.hashCode = Arrays.hashCode(this.rows) + Arrays.hashCode(this.cols) + Arrays.hashCode(this.values);
  }

  /**
   * загружает матрицу из файла
   *
   * @param fileName
   */
  public SparseMatrix(String fileName) {

  }

  /**
   * однопоточное умнджение матриц
   * должно поддерживаться для всех 4-х вариантов
   *
   * @param o
   * @return
   */
  @Override
  public Matrix mul(Matrix o) {
    return null;
  }

  /**
   * многопоточное умножение матриц
   *
   * @param o
   * @return
   */
  @Override
  public Matrix dmul(Matrix o) {
    return null;
  }

  /**
   * спавнивает с обоими вариантами
   *
   * @param o
   * @return
   */
  @Override
  public boolean equals(Object o) {
    return false;
  }

  @Override
  public double get(int i, int j) {
    return 0;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public int getWidth() {
    return this.width;
  }
}

