package algo.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Permutations
{

  // permutations
  @Test
  public void threeElement() {
    List<List<Integer>> subsets = permutations(new int[] { 1, 2, 3 });

    assertNotNull(subsets);
    subsets = new LinkedList<List<Integer>>(subsets);
    assertEquals(6, subsets.size());
    for(List<Integer> actualList: subsets)
    {
      System.out.println(Arrays.toString(actualList.toArray()));
    }
  }

  private List<List<Integer>> permutations(int[] nums)
  {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums); // not needed
    backtrack(list,new ArrayList<>(),nums);
    return list;
  }

  private void backtrack(List<List<Integer>> list, ArrayList<Integer> tempList, int[] nums)
  {
    if(tempList.size() == nums.length)
    {
      list.add(new ArrayList<>(tempList));
    }
    else {
      for(int i=0; i<nums.length; i++)
      {
        if(tempList.contains(nums[i])) continue;
        tempList.add(nums[i]);
        this.backtrack(list, tempList, nums);
        tempList.remove(tempList.size()-1);
      }
    }
  }

  // with duplicates
  @Test
  public void threeElementWithDuplicates() {
    List<List<Integer>> subsets = permutationsWithDuplicates(new int[] { 1, 2, 2 });

    assertNotNull(subsets);
    subsets = new LinkedList<List<Integer>>(subsets);
    assertEquals(3, subsets.size());
    for(List<Integer> actualList: subsets)
    {
      System.out.println(Arrays.toString(actualList.toArray()));
    }
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
