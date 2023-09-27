import org.junit.Test;
import static org.junit.Assert.*;
/** Tests the ArrayDeque class.
 *  @author Josh Hug
 *  Modified by George Sun
 */

public class ArrayDequeTest {
    @Test
    public void testEmptySize() {
        ArrayDeque<Integer> L = new ArrayDeque<Integer>();
        assertEquals(0, L.size());
    }
    @Test
    public void testAddAndSize() {
        ArrayDeque<Integer> L = new ArrayDeque<Integer>();
        L.addLast(99);
        L.addLast(99);
        assertEquals(2, L.size());
    }

    @Test
    public void testGet() {
        ArrayDeque<Integer> L = new ArrayDeque<Integer>();
        L.addLast(99);
        assertEquals(99, L.get(0).intValue());
        L.addLast(36);
        assertEquals(99, L.get(0).intValue());
        assertEquals(36, L.get(1).intValue());
    }
    /** Tests insertion of a large number of items.*/
    @Test
    public void testMegaInsert() {
        ArrayDeque<Integer> L = new ArrayDeque<Integer>();
        int N = 1000000;
        for (int i = 0; i < N; i += 1) {
            L.addLast(i);
        }
        for (int i = 0; i < N; i += 1) {
            L.addLast(L.get(i));
        }
    }
    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests("all", ArrayDequeTest.class);
    }
}
