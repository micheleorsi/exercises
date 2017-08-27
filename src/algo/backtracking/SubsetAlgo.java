package algo.backtracking;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
    List<Set<Integer>> subsets;
    subsets = subsets(new int[] { 3, 1, 2 });

    assertNotNull(subsets);
    assertEquals(8, subsets.size());

    Assert.assertTrue(subsets.contains(new HashSet<>(Arrays.asList())));
    Assert.assertTrue(subsets.contains(new HashSet<>(Arrays.asList(3))));
    Assert.assertTrue(subsets.contains(new HashSet<>(Arrays.asList(3,1))));
    Assert.assertTrue(subsets.contains(new HashSet<>(Arrays.asList(3,1,2))));
    Assert.assertTrue(subsets.contains(new HashSet<>(Arrays.asList(3,2))));
    Assert.assertTrue(subsets.contains(new HashSet<>(Arrays.asList(2))));
    Assert.assertTrue(subsets.contains(new HashSet<>(Arrays.asList(1,2))));
    Assert.assertTrue(subsets.contains(new HashSet<>(Arrays.asList(1))));

    for (Set<Integer> subset : subsets) {
      System.out.println(subset);
    }
  }


  public List<Set<Integer>> subsets(int[] nums) {
    List<Set<Integer>> list = new ArrayList<>();
//    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
  }

  private void backtrack(List<Set<Integer>> list , List<Integer> tempList, int [] nums, int start){
    list.add(new HashSet<>(tempList));
    for(int i = start; i < nums.length; i++){
      tempList.add(nums[i]);
      backtrack(list, tempList, nums, i + 1);
      tempList.remove(tempList.size() - 1);
    }
  }

  @Test
  public void threeElementCombinatorial() {
    List<List<Integer>> subsets;
    int[] arr = {3, 1, 2};
    subsets = subsetsCombin(arr);

    assertNotNull(subsets);
    assertEquals(8, subsets.size());

    Assert.assertTrue(subsets.contains(Arrays.asList()));
    Assert.assertTrue(subsets.contains(Arrays.asList(3)));
    Assert.assertTrue(subsets.contains(Arrays.asList(3,1)));
    Assert.assertTrue(subsets.contains(Arrays.asList(3,1,2)));
    Assert.assertTrue(subsets.contains(Arrays.asList(3,2)));
    Assert.assertTrue(subsets.contains(Arrays.asList(2)));
    Assert.assertTrue(subsets.contains(Arrays.asList(1,2)));
    Assert.assertTrue(subsets.contains(Arrays.asList(1)));

  }

  List<List<Integer>> subsetsCombin(int[] sum) {
    int max = 1<< sum.length;
    List<List<Integer>> subset = new ArrayList<>();
    for(int i=0; i<max; i++) {
      List<Integer> list = generateSubset(i,sum);
      subset.add(list);
    }
    return subset;
  }

  private List<Integer> generateSubset(int i, int[] array) {
    int idx = 0;
    System.out.print("i: "+i+"("+Integer.toBinaryString(i)+") {"+Arrays.toString(array)+"} ");

    List<Integer> actual = new ArrayList<>();
    for(int k=i; k>0; k>>=1) {
      if((k&1)==1) {
        actual.add(array[idx]);
      }
      idx++;
    }
    System.out.println(actual);

    return actual;
  }

  // with duplicates
  @Test
  public void threeElementWithDuplicates() {
    List<List<Integer>> subsets = subsetsWithDuplicates(new int[] { 2, 1, 2 });

    assertNotNull(subsets);
    subsets = new LinkedList<>(subsets);
    assertEquals(6, subsets.size());

    Assert.assertTrue(subsets.contains(new ArrayList<>(Arrays.asList())));
    Assert.assertTrue(subsets.contains(new ArrayList<>(Arrays.asList(2))));
    Assert.assertTrue(subsets.contains(new ArrayList<>(Arrays.asList(1))));
    Assert.assertTrue(subsets.contains(new ArrayList<>(Arrays.asList(1,2,2))));
    Assert.assertTrue(subsets.contains(new ArrayList<>(Arrays.asList(2,2))));
    Assert.assertTrue(subsets.contains(new ArrayList<>(Arrays.asList(1,2))));
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
      backtrackWithDuplicates(list, tempList, nums, i + 1);
      tempList.remove(tempList.size() - 1);
    }
  }

}

class ADMSubset extends Backtrack {
  @Override
  boolean isASolution(int[] a, int k, int n) {
    return super.isASolution(a, k, n);
  }

  @Override
  void backtrack(int[] a, int k, int input) {
    super.backtrack(a, k, input);
  }

  @Override
  void constructCandidate(int[] a, int k, int input) {
    super.constructCandidate(a, k, input);
  }

  @Override
  void processSolution(int[] a, int k, int input) {
    super.processSolution(a, k, input);
  }
}
