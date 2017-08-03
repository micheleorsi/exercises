package algo.sort;


public class InsertionSort implements Sort {

  @Override
  public void sort(int[] array)
  {
    for(int i=1; i<array.length; i++)
    {
      for(int j=0; j<i; j++)
      {
        if(array[i]<array[j])
        {
          int temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        }
      }
    }
  }
}
