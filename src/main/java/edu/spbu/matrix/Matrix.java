package edu.spbu.matrix;

public interface Matrix {
  String toString();
  int getHeight();
  int getWidth();
  Matrix mul(Matrix o);
  Matrix dmul(Matrix o);
  boolean equals(Object o);
}