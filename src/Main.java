import org.junit.Assert;
import org.junit.Test;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    @Test
    public void test()
    {
        Assert.assertEquals("ciao","ciao");
    }
}
