/*
  MCO1 Sorting S21 Group 4
  Cabungcal, Mary Joselle
  Ladrido, Eryl Gabriel
  Rejano, Hans Martin
  Uy, Gleezell Vina

  Code References:
  https://www.geeksforgeeks.org/program-generate-random-alphabets/ - Basis for generating random string

  https://www.geeksforgeeks.org/merge-sort/ -Basis for merge sort
  
*/

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    int count = 0;

    Scanner numScanner = new Scanner(System.in);
    // Asking user for input N
    System.out.print("Enter n: ");
    int n = numScanner.nextInt();
    // Asking user for number of iterations K
    System.out.print("Enter k: ");
    int k = numScanner.nextInt();
    
    numScanner.close();

    double dTime1 = 0, // contains running time for merge sort
           dTime2 = 0; // contains running time for bubble sort
    double next = 0,
           bestM = 0, worstM = 0,
           bestB = 0, worstB = 0;
    double[] tempMerge = new double[k];
    double[] tempBubble = new double[k];

    while (count < k) {
      GenRanStr generate = new GenRanStr(); // instanstiate a GenRanStr object

      // generate random text of length n with 2 copies
      String randomText[] = generate.getAlphabet(n); //
      String randomText2[] = randomText.clone();

      // instantiate merge object and sort randomText array
      Sort merge = new Sort();

      // set the starting time for the merge sort
      double startTime1 = System.currentTimeMillis() / 1.0;
      merge.mergeSort2(randomText, 0,
          randomText.length - 1);

      // generate index array that corresponds to randomText
      int index[] = new int[randomText.length];
      index = merge.getIndex(randomText,
          randomText2,
          randomText.length);

      // displaying the merge sorted index
      System.out.println("");
      System.out.println("Merge Sorted:");
      int i;
      for (i = 0; i < randomText.length; i++) {
        System.out.println(index[i] + ":" + randomText[i]);
      }

      // instantiate index Object and print sorted index array
      IndexArray indexList = new IndexArray();
      indexList.indexArray(index);

      // compute running time for merge sort
      double stopTime1 = System.currentTimeMillis() / 1.0;
      double elapsedTime1 = stopTime1 - startTime1;
      dTime1 += (elapsedTime1);
      next = elapsedTime1;

      // store worst running time
      if (next > worstM) {
        worstM = next;
      }

      // store best running time
      if (count == 0 || next < bestM) {
        bestM = next;
      }
      System.out.println("\n");

      // instantiate bubble sort object and sort randomText
      Sort bubble = new Sort();
      String newText[] = randomText2.clone();
      String newText2[] = newText.clone();

      // set starting time for bubble sort
      double startTime2 = System.currentTimeMillis() / 1.0;
      // generate index array that corresponds to bubble sort
      int index2[] = new int[newText.length];
      bubble.bubbleSort(newText2);
      index2 = bubble.getIndex(newText2, newText,
          newText.length);

      // displaying the index array after bubble sorting
      System.out.println("Bubble Sorted:");
      for (i = 0; i < newText2.length; i++) {
        System.out.println(index2[i] + ":" + newText2[i]);
      }
      indexList.indexArray(index2);

      // compute running time for bubble sort
      double stopTime2 = System.currentTimeMillis() / 1.0;
      double elapsedTime2 = stopTime2 - startTime2;
      dTime2 += (elapsedTime2);
      next = elapsedTime2;

      // set worst running time
      if (next > worstB) {
        worstB = next;
      }

      // set best running time
      if (count == 0 || next < bestB) {
        bestB = next;
      }

      // print running time for bubble sort and merge sort
      System.out.println("Execution time of Bubble Sort: " +
          elapsedTime2);
      System.out.println("Execution time of Merge Sort: " +
          elapsedTime1);
      // storing the running times in temp arrays
      tempMerge[count] = elapsedTime1;
      tempBubble[count] = elapsedTime2;

      count++; // increment iteration count
    }
    // computers for the average running time
    dTime1 /= (k * 1.0);
    dTime2 /= (k * 1.0);

    // display running times per iteration k for Merge
    System.out.println("Merge Running Times: ");
    for (int i = 0; i < k; i++) {
      System.out.println(tempMerge[i]);
    }

    System.out.println("");

    // display running times per iteration k for Bubble
    System.out.println("Bubble Running Times: ");
    for (int i = 0; i < k; i++) {
      System.out.println(tempBubble[i]);
    }

    // display running time for merge sort
    System.out.println(String.format("\nMerge Avg: %.3f", dTime1));
    System.out.println(String.format("Merge Best: %.3f", bestM));
    System.out.println(String.format("Merge Worst: %.3f\n", worstM));

    // display running time for bubble sort
    System.out.println(String.format("Bubble Avg: %.3f", dTime2));
    System.out.println(String.format("Bubble Best: %.3f", bestB));
    System.out.println(String.format("Bubble Worst: %.3f", worstB));
  }
}
