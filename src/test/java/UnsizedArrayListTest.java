import com.innowise.duvalov.stack.Stack;
import com.innowise.duvalov.stack.impl.UnsizedArrayList;
import org.junit.Assert;
import org.junit.Test;

public class UnsizedArrayListTest {
    @Test
    public void testUnsizedArrayList1(){
        Stack<Double> test = new UnsizedArrayList<>();
        test.push(123.4);
        Assert.assertFalse(test.isEmpty());
    }

    @Test
    public void testUnsizedArrayList2(){
        Stack<Double> test = new UnsizedArrayList<>();
        test.push(123.4);
        Assert.assertFalse(test.isFull());
    }
}
