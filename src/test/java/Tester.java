import com.Duvalov.Stack.LinkedStack;
import com.Duvalov.Exceptions.FullCollectionException;
import com.Duvalov.Exceptions.WrongCapacityException;
import com.Duvalov.Exceptions.ZeroCapacityException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class Tester {
    @Test
    public void testLinkedSteck()
            throws WrongCapacityException, FullCollectionException, ZeroCapacityException {
        LinkedStack<Integer> test_1 = new LinkedStack<Integer>(10);
        ArrayList<Integer> testArr = new ArrayList<Integer>(10);
        for (int i = 0; i < 10; i++) {
            test_1.push(i);
            testArr.add(i);
        }
        LinkedStack<Integer> test_2 = new LinkedStack<Integer>(testArr, 10);
        LinkedStack<Integer> test_3 = new LinkedStack<Integer>(testArr, 15);
        LinkedStack<Integer> test_4 = new LinkedStack<Integer>(testArr);
        Assert.assertTrue(test_2.isFull());
        Assert.assertFalse(test_2.isEmpty());
        Assert.assertFalse(test_3.isFull());
        Assert.assertFalse(test_3.isEmpty());
        Assert.assertFalse(test_4.isFull());
    }
}
