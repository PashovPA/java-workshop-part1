# Computer-based workshop
The main objective of this course is to familiarise students with the basics of professional programming using the Java language.

## Main topics of the course:
* Fundamentals of Java programming language
  * Basic operations
  * Working with arrays 
  * Working with collections (java.util), HastMap.
  * Multi-threaded programming and synchronization
  * Network programming
* Modern software development tools
  * IntelliJ IDE, Eclipse
  * Version control system git, github.

## Practical assignments
All completed tasks are published on github; a link to the finished tasks is sent to the teacher.

1. Setting up github
   1. Create a user on github
   2. "fork" https://github.com/artem-aliev/java-template/ repository to its own space
   3. Clone it on the production machine
   4. Make code changes to make "commit" and "push"
   5. Send the teacher a link to the repository created
2. Setting up IntelliJ/Eclipse
   1. export the project into the IDE
   2. Run unit test [IntSortTest.java](https://github.com/artem-aliev/java-template/blob/master/src/test/java/edu/spbu/sort/IntSortTest.java)
3. Getting to know Java. Sorting
   1. Replace in [IntSort.java](https://github.com/artem-aliev/java-template/blob/master/src/main/java/edu/spbu/sort/IntSort.java) file the standard call with your own algorithm. 
       Any algorithm with average computational complexity n*log(n) is suitable.
4. object-oriented programming.
   1. [Matrix.java](https://github.com/artem-aliev/java-template/blob/master/src/main/java/edu/spbu/matrix/Matrix.java) Matrix interface with one operation: multiplication
   2. Task: create two classes DenseMatrix and SparseMatrix: dense and dilation matrix with corresponding storage methods
   3. to implement the "mul" method of multiplication in a way that allows multiplying different types of matrices by each other
   4. Write unit tests loi for all multiplication options. Example: [MatrixTest.java](https://github.com/artem-aliev/java-template/blob/master/src/test/java/edu/spbu/matrix/MatrixTest.java)
5. Multithreaded programming
   1. Add a method to DenseMatrix and SparseMatrix that multiplies matrices in multiple threads
   2. Write tests to see if the speed increases as the number of threads increases
6. Network programming
   1. Write a simple http server able to give html files from a folder
   2. Write a simple http client that can send a "GET" request and print the response on the screen
   3. Check client/server work with each other
   4. Check that the server works with a standard browser
   5. Check that client receives information from any web server on the internet



Translated with www.DeepL.com/Translator (free version)
