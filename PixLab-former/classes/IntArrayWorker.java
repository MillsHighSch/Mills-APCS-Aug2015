public class IntArrayWorker
{
  /** two dimensional matrix */
  private int[][] matrix = null;
  
  /** set the matrix to the passed one
    * @param theMatrix the one to use
    */
  public void setMatrix(int[][] theMatrix)
  {
    matrix = theMatrix;
  }
  /** 
   * Exercise #1 on Page 9
   * new getCount method to return the number of times the passed integer appears in the matrix
   */ 
  public int getCount(int target){
     int count = 0;
      for (int[] rowArray : matrix)
    {
      for (int item : rowArray)
      {
          if (item == target)
          {
              count = count +1;
          }
      }
    }
    return count;
  }
  /** 
   * Exercise #2 on Page 9
   * new getLargest method return the largest value in the matrix
   */ 
  public int getLargest(){
     int largest = -1;
      for (int[] rowArray : matrix)
    {
      for (int item : rowArray)
      {
          if (item > largest)
          {
              largest = item;
          }
      }
    }
    return largest;
  }
  /**
   * Exercise #3 on Page 9
   * new getColTotal method returns total of all integers in a specified column
   */
  public int getColTotal(int targetCol)
  {
    int total = 0;
    for (int row = 0; row < matrix.length; row++)
    {
      total = total + matrix [row][targetCol];
    }
    return total;
  }
  
 
  /**
   * Method to return the total 
   * @return the total of the values in the array
   */
  public int getTotal()
  {
    int total = 0;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        total = total + matrix[row][col];
      }
    }
    return total;
  }
  
  /**
   * Method to return the total using a nested for-each loop
   * @return the total of the values in the array
   */
  public int getTotalNested()
  {
    int total = 0;
    for (int[] rowArray : matrix)
    {
      for (int item : rowArray)
      {
        total = total + item;
      }
    }
    return total;
  }
  
  /**
   * Method to fill with an increasing count
   */
  public void fillCount()
  {
    int numCols = matrix[0].length;
    int count = 1;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < numCols; col++)
      {
        matrix[row][col] = count;
        count++;
      }
    }
  }
  
  /**
   * print the values in the array in rows and columns
   */
  public void print()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        System.out.print( matrix[row][col] + " " );
      }
      System.out.println();
    }
    System.out.println();
  }
  
  
  /** 
   * fill the array with a pattern
   */
  public void fillPattern1()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; 
           col++)
      {
        if (row < col)
          matrix[row][col] = 1;
        else if (row == col)
          matrix[row][col] = 2;
        else
          matrix[row][col] = 3;
      }
    }
  }
 
}