import com.innowise.duvalov.queue.Queue;
import com.innowise.duvalov.stack.Stack;
import com.innowise.duvalov.stack.impl.SizedArrayList;
import org.junit.Assert;
import org.junit.Test;

public class SizedArrayListTest {
    @Test
    public void testSizedArrayList1() {
        Stack<Integer> test = new SizedArrayList<>();
        test.push(1);
        Assert.assertEquals(test.peek(), test.pop());
    }

    @Test
    public void testSizedArrayList2() {
        Queue<Integer> queueTest = new com.innowise.duvalov.queue.impl.SizedArrayList<>();
        Stack<Integer> stackTest = new SizedArrayList<>();
        queueTest.enqueue(1);
        queueTest.enqueue(2);
        stackTest.push(2);
        stackTest.push(1);
        Assert.assertEquals(queueTest.peek(),stackTest.peek());
    }
}
