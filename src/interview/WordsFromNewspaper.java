package interview;

import java.util.HashMap;
import java.util.List;

public class WordsFromNewspaper
{
  // This is the text editor interface.
  // Anything you type or change here will be seen by the other person in real time.

  // kidnamp
  // cut of the individuals word from newspaper
  //
  public boolean canWriteRansomNote(String[] newspaperWords, String[] ransomNoteWords) {

    boolean answer = true;
    for (int i=0; i<ransomNoteWords.length; i++)
    {
      String neededWord = ransomNoteWords[i];
      for(int j=0; j<newspaperWords.length; j++)
      {
        if(neededWord.equals(newspaperWords[j]))
        {
          newspaperWords[j]="";
          break;
        }
        if(j==newspaperWords.length-1)
        {
          return false;
        }
      }
    }

    // with HashMap
    // build hashmap
    HashMap<String,List<String>> map = new HashMap<>();
    for(int i=0; i<newspaperWords.length;i++)
    {
      if(map.containsKey(newspaperWords[i]))
      {
        List<String> actualList = map.get(newspaperWords[i]);
        actualList.add(newspaperWords[i]);
      }
    }
    // <<red: <red, red>,<blue: blue>, ...

    int foundWords = 0;
    for (int i=0; i<ransomNoteWords.length; i++)
    {
      if(map.containsKey(ransomNoteWords[i]))
      {
        List<String> actualList = map.get(ransomNoteWords[i]);
        actualList.remove(ransomNoteWords[i]);
        foundWords++;
        continue;
        // go on
        // remove from map
      }
      else {
        return false;
      }
    }

    // newspaperWords.size + c * ransomNoteWords
    return true;


  }

}
