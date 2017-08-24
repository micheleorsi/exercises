package algo.backtracking;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Given a collection of distinct numbers, return all possible permutationsv1.
 *
 * For example,
 * [1,2,3] have the following permutationsv1:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 *
 */
public class Permutations
{

  // permutationsv1
  @Test
  public void threeElement() {
    List<List<Integer>> permutations1 = permutationsv1(new int[] { 3, 1, 2 });
    List<List<Integer>> permutations2 = permutationsv2(new int[] { 3, 1, 2 });

    Assert.assertEquals(permutations1,permutations2);

    assertEquals(6, permutations1.size());

    Assert.assertTrue(permutations1.contains(new ArrayList<>(Arrays.asList(3,1,2))));
    Assert.assertTrue(permutations1.contains(new ArrayList<>(Arrays.asList(3,2,1))));
    Assert.assertTrue(permutations1.contains(new ArrayList<>(Arrays.asList(1,3,2))));
    Assert.assertTrue(permutations1.contains(new ArrayList<>(Arrays.asList(1,2,3))));
    Assert.assertTrue(permutations1.contains(new ArrayList<>(Arrays.asList(2,3,1))));
    Assert.assertTrue(permutations1.contains(new ArrayList<>(Arrays.asList(2,1,3))));

  }

  @Test
  public void testString() {
    String input = "cia";
    List<String> result = stringPermutation(input);

    Assert.assertEquals("cia",result.get(0));
    Assert.assertEquals("cai",result.get(1));
    Assert.assertEquals("ica",result.get(2));
    Assert.assertEquals("iac",result.get(3));
    Assert.assertEquals("aci",result.get(4));
    Assert.assertEquals("aic",result.get(5));
  }

  List<String> stringPermutation(String str){
    LinkedList<String> result = new LinkedList<>();
    permutation("", str, result);
    return result;
  }

  void permutation(String prefix, String str, List<String> result){
    if(str.length()==0) result.add(prefix);

    for(int i=0;i<str.length();i++){
      String before=str.substring(0,i);
      String after=str.substring(i+1);
      char newPrefix = str.charAt(i);
      permutation(prefix+ newPrefix, before+after, result);
    }
  }


  private List<List<Integer>> permutationsv1(int[] nums)
  {
    List<List<Integer>> list = new ArrayList<>();
    backtrackv1(list,new ArrayList<>(),nums,nums.length);
    return list;
  }

  private void backtrackv1(List<List<Integer>> list, List<Integer> tempList, int[] nums, int size)
  {
    if(tempList.size() == size)
    {
      list.add(new ArrayList<>(tempList));
    }
    else {
      for(int i=0; i<nums.length; i++)
      {
        int[] newArray = removeElementAt(nums,i);
        tempList.add(nums[i]);
        this.backtrackv1(list, tempList, newArray,size);
        tempList.remove(tempList.size()-1);
      }
    }
  }

  private int[] removeElementAt(int[] input, int idx) {
    int[] returnArr = new int[input.length-1];
    int localIdx = 0;
    for(int i=0; i<input.length; i++) {
      if(i!=idx) {
        returnArr[localIdx++]=input[i];
      }
    }
    return returnArr;
  }

  private List<List<Integer>> permutationsv2(int[] nums)
  {
    List<List<Integer>> list = new ArrayList<>();
    backtrackv2(list,new ArrayList<>(),nums);
    return list;
  }

  private void backtrackv2(List<List<Integer>> list, List<Integer> tempList, int[] nums)
  {
    if(tempList.size() == nums.length)
    {
      list.add(new ArrayList<>(tempList));
    }
    else {
      for(int i=0; i<nums.length; i++)
      {
        if(tempList.contains(nums[i])) continue; // O(n)
        tempList.add(nums[i]);
        this.backtrackv2(list, tempList, nums);
        tempList.remove(tempList.size()-1);
      }
    }
  }

  // with duplicates
  @Ignore
  @Test
  public void threeElementWithDuplicates() {
    List<List<Integer>> permutationsDupl1 = permutationsWithDuplicates(new int[] { 2, 1, 2 });
    List<List<Integer>> permutationsDupl2 = permutationsv1(new int[] { 2, 1, 2  });

    assertEquals(3, permutationsDupl1.size());
    Assert.assertEquals(permutationsDupl1,permutationsDupl2);

    Assert.assertTrue(permutationsDupl1.contains(new ArrayList<>(Arrays.asList(1,2,2))));
    Assert.assertTrue(permutationsDupl1.contains(new ArrayList<>(Arrays.asList(2,1,2))));
    Assert.assertTrue(permutationsDupl1.contains(new ArrayList<>(Arrays.asList(2,2,1))));
  }

  private List<List<Integer>> permutationsWithDuplicates(int[] nums)
  {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums); // not needed
    backtrackWithDuplicates(list,new ArrayList<>(),nums, new boolean[nums.length]);
    return list;
  }

  private void backtrackWithDuplicates(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used)
  {
    if(tempList.size()==nums.length)
    {
      list.add(new ArrayList<>(tempList));
    }
    else {
      for(int i=0; i<nums.length; i++)
      {
        if(used[i] || i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;
        used[i] = true;
        tempList.add(nums[i]);
        backtrackWithDuplicates(list, tempList, nums, used);
        used[i] = false;
        tempList.remove(tempList.size()-1);
      }
    }
  }

}
