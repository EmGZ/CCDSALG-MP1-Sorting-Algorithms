/*
  MCO1 Sorting S21 Group 4
  Cabungcal, Mary Joselle
  Ladrido, Eryl Gabriel
  Rejano, Hans Martin
  Uy, Gleezell Vina
*/

/*
* This class contains methods that does merge sorting,
*  bubble sorting, creating the index array.
*
*@param text - array of the original text
*@param p - index for left side of the array
*@param q - index for middle of the array
*@param r - index for right side of the array
*/
public class Sort {

  /**
  *This merges two subarrays of the String[] text
  */
  public void merge(String[] text, int p, int q, int r) {
    int n1 = q - p + 1;
    int n2 = r - q;

    //create two arrays for the left and right side
    String L[] = new String[n1];
    String R[] = new String[n2];

    //initialize the data of the left and right subarrays
    int i, j;
    for (i = 0; i < n1; i++)
      L[i] = text[p + i];

    for (j = 0; j < n2; j++)
      R[j] = text[q + 1 + j];

    //reset values to 0
    i = 0;
    j = 0;
    int k = p;

    //merge the left and right subarrays back to the array
    while (i < n1 && j < n2) {
      // modified the operator if (L[i] <= R[j]]) {
      if (L[i].compareTo(R[j]) < 0) {
        text[k] = L[i];
        i++;
      } else {
        text[k] = R[j];
        j++;
      }
      k++;
    }

    //copy the remaining elements from the left array
    while (i < n1) {
      text[k] = L[i];
      i++;
      k++;
    }

    //copy the remaining elements from the right array
    while (j < n2) {
      text[k] = R[j];
      j++;
      k++;
    }

  }

  /**
  * This calls the merge sort algorithm to sort the text array
  *
  *@param text - the array of generated text
  *@param left - the index for the left subarray to be sorted
  *@param right - the index for the right subarray to be sorted
  */
  public void mergeSort2(String[] text, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;

      mergeSort2(text, left, mid);
      mergeSort2(text, mid + 1, right);

      merge(text, left, mid, right);
    }

  }

  /**
  *This returns a corresponding index array for the text array
  * 
  *@param text1 - unsorted text array
  *@param text2 - sorted text array
  *@param length - length of the array
  *
  *@return indexArray - contains index array
  */
  public int[] getIndex(String[] text1,
      String[] text2,
      int length) {

    int indexArray[] = new int[length];
    int i, j;

    for (i = 0; i < length; i++) {
      for (j = 0; j < length; j++) {
        if (text2[i].equals(text1[j]))
          indexArray[j] = i;
      }
    }

    return indexArray;
  }

  /**
  *This sorts the text array using bubble sort algorithm
  *
  *@param text - array of generated text
  */
  public void bubbleSort(String[] text) {
    for (int i = 1; i <= text.length - 1; i++) {
      for (int j = 0; j < text.length - i; j++) {
        // compare the adjacent strings
        if (text[j].compareTo(text[j + 1]) > 0) { //condition for swapping elements
          String temp = text[j + 1];
          text[j + 1] = text[j];
          text[j] = temp;
        }
      }
    }
  }
}
