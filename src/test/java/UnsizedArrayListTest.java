import com.innowise.duvalov.queue.Queue;
import com.innowise.duvalov.stack.Stack;
import com.innowise.duvalov.stack.impl.UnsizedArrayList;
import org.junit.Assert;
import org.junit.Test;

public class UnsizedArrayListTest {
    @Test
    public void testUnsizedArrayList1(){
        Stack<Double> test = new UnsizedArrayList<>();
        test.push(123.4);
        Assert.assertEquals(test.isEmpty(), test.isFull());
    }

    @Test
    public void testUnsizedArrayList2(){
        Queue<Double> test = new com.innowise.duvalov.queue.impl.UnsizedArrayList<>();
        test.enqueue(123.4);
        Assert.assertEquals(test.isFull(), test.isEmpty());
    }

    @Test
    public void testUnsizedArrayList3() {
        Stack<Integer> test1 = new UnsizedArrayList<>();
        Queue<Integer> test2 = new com.innowise.duvalov.queue.impl.UnsizedArrayList<>();
        for (int i = 0; i <100; i++) {
            test1.push(i);
            test2.enqueue(i);
        }
        Assert.assertEquals(test1.size(),test2.size());
    }

}
