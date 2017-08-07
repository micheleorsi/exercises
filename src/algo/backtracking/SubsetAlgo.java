package algo.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


/**
 * Given a set of distinct integers, nums, return all possible subsets.
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * For example,
 * If nums = [1,2,3], a solution is:
 *
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 *  []
 * ]
 *
 */
public class SubsetAlgo
{

  //subsets
  @Test
  public void threeElement() {
    List<List<Integer>> subsets = subsets(new int[] { 3, 1, 2 });

    assertNotNull(subsets);
    subsets = new LinkedList<List<Integer>>(subsets);
    assertEquals(8, subsets.size());
    for(List<Integer> actualList: subsets)
    {
      System.out.println(Arrays.toString(actualList.toArray()));
    }
  }


  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
//    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
  }

  private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
      tempList.add(nums[i]);
      backtrack(list, tempList, nums, i + 1);
      tempList.remove(tempList.size() - 1);
    }
  }

  // with duplicates
  @Test
  public void threeElementWithDuplicates() {
    List<List<Integer>> subsets = subsetsWithDuplicates(new int[] { 2, 1, 2 });

    assertNotNull(subsets);
    subsets = new LinkedList<>(subsets);
    assertEquals(7, subsets.size());
    for(List<Integer> actualList: subsets)
    {
      System.out.println(Arrays.toString(actualList.toArray()));
    }
  }

  public List<List<Integer>> subsetsWithDuplicates(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrackWithDuplicates(list, new ArrayList<>(), nums, 0);
    return list;
  }

  private void backtrackWithDuplicates(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
      if(i>start && nums[i] == nums[i-1]) continue; // skip duplicates
      tempList.add(nums[i]);
      backtrack(list, tempList, nums, i + 1);
      tempList.remove(tempList.size() - 1);
    }
  }


}
