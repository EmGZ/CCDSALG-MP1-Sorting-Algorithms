/*
  MCO1 Sorting S21 Group 4
  Cabungcal, Mary Joselle
  Ladrido, Eryl Gabriel
  Rejano, Hans Martin
  Uy, Gleezell Vina
*/

/**
*This class contains the method to print the index array
*/
public class IndexArray {

  /**
  *This prints the suffix array
  *
  *@param index - contains the index array
  */
  public void indexArray (int[] index) {
    System.out.print("Suffix Array: ");

    for (int i = 0; i < index.length; i++)
      System.out.print(index[i] + " ");

    System.out.println(" ");
  }
}