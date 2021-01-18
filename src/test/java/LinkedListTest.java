import com.innowise.duvalov.queue.Queue;
import com.innowise.duvalov.stack.Stack;
import com.innowise.duvalov.stack.impl.LinkedList;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {
    @Test
    public void testLinkedList1() {
        Stack<String> test = new LinkedList<>(1);
        test.push("test");
        Assert.assertTrue(test.isFull());
    }

    @Test
    public void testLinkedList2() {
        Queue<String> test = new com.innowise.duvalov.queue.impl.LinkedList<>();
        Assert.assertTrue(test.isEmpty());
    }
}
