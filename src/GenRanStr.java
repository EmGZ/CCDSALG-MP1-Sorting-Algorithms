/*
  MCO1 Sorting S21 Group 4
  Cabungcal, Mary Joselle
  Ladrido, Eryl Gabriel
  Rejano, Hans Martin
  Uy, Gleezell Vina
*/

/**
*This class contains the method to get the alphabet that will be used
*/
public class GenRanStr {
  private char[] alphabet;

  /**
  *This instantiates the values of the alphabet array
  */
  public GenRanStr() {
    alphabet = new char[4];
    alphabet[0] = 'a';
    alphabet[1] = 'c';
    alphabet[2] = 'g';
    alphabet[3] = 't';
  }

  /**
  *This returns a random alphabet from the alphabet array
  *@return suffix - generated random string
  */
  public String[] getAlphabet(int n) {

    String res = "";
    int i;

    for (i = 0; i < n; i++)
      res = res + alphabet[(int) (Math.random() * 100 % 4)]; // concatenate a random char from array alphabet with string res
  
    String[] suffix = new String[res.length()]; //create new string with length same with res

    for (i = 0; i < res.length(); i++)
      suffix[i] = res.substring(i, res.length()); //deletes the first character and adds the remaining characters to the suffix array

    System.out.println("Generated: " + res);
    for (i = 0; i < suffix.length; i++) {
      System.out.println(i + ":" + suffix[i]);
    }

    return suffix;
  }

}