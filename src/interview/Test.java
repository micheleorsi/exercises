package interview;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by morsi on 21/06/2017.
 */
public class Test {

    public static void main(String[] args)
    {
        int[] a = {1};
        Test t = new Test();
        t.increment(a);
        System.out.println(a[a.length-1]);
    }
    void increment(int[] i)
    {
        i[i.length-1]++;
    }

    @org.junit.Test
    public void test()
    {
        String pattern = ".*(\\d+).*(\\d+).*";
        Exception t = new Exception("test");

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher("ciao ciao");
        if(m.find())
        {
            System.out.println("in0: "+m.group(0));
            System.out.println("in1: "+m.group(1));
        }



    }
}
