import com.innowise.duvalov.PalindromeChecker;
import com.innowise.duvalov.stack.Stack;
import com.innowise.duvalov.stack.impl.SizedArrayList;
import org.junit.Assert;
import org.junit.Test;

public class PalindromeCheckerTest {
    @Test
    public void testPalindrome() {
        PalindromeChecker<String> pc = new PalindromeChecker<>();
        String[] words = {"aaa", "awa", "awwa", "awaw", "awwawa"};
        Stack<String> test = new SizedArrayList<>(words);
        boolean[] expected = {false, false, true, true, true};
        boolean[] actual = new boolean[5];
        for (int i = 0; i < 5; i++) {
            actual[i] = pc.isPalindrome(test.pop());
        }
        Assert.assertArrayEquals(expected, actual);
    }
}
