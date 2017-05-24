package interview;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * We have a file with the following lines
 * - "name of something EntityType1"
 * - "name of something else EntityType2"
 * - "name of something else 2 EntityType1"
 * - "name of something else 2 EntityType1"
 *
 * Find:
 * - number of different entity type (in this case 2)
 * - number of different entity (in this case 3)
 * - maximum length of an entity
 */
public class FindOccurenciesOfWord
{
  @Test
  public void test()
  {
    String[] archive = {
      "name of something EntityType1",
      "name of something else EntityType2",
      "name of something else 2 EntityType1",
      "name of something else 2 EntityType1"
    };

    solution(archive);


  }

  public void solution(String[] rows)
  {
    Set<String> entityTypeSet = new HashSet<>();
    Set<String> entitySet = new HashSet<>();
    int max = Integer.MIN_VALUE;
    for(int i=0; i<rows.length; i++)
    {
      StringTokenizer st = new StringTokenizer(rows[i]," ");
      String entityType = "";

      while(st.hasMoreTokens())
      {
        entityType = st.nextToken();
      }
      entityTypeSet.add(entityType);

      String entity = rows[i].substring(0,rows[i].length() - entityType.length());
      entitySet.add(entity.trim());
      max = Math.max(max,entity.trim().length());
    }

    System.out.println(entityTypeSet.size());
    System.out.println(entitySet.size());
    System.out.println(max);

  }

}
