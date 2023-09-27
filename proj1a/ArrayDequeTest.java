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
//    @Test
//    public void testMegaInsert() {
//        ArrayDeque<Integer> L = new ArrayDeque<Integer>();
//        int N = 1000000;
//        for (int i = 0; i < N; i += 1) {
//            L.addLast(i);
//        }
//        for (int i = 0; i < N; i += 1) {
//            L.addLast(L.get(i));
//        }
//    }
    @Test
    public void testRemove() {
        ArrayDeque<Integer> L = new ArrayDeque<Integer>();
        L.addLast(0);
        L.addLast(1);
        L.addFirst(2);
        L.addLast(3);
        L.get(3)      ;
        L.removeFirst();
        L.addFirst(6);
        L.addLast(7);
        L.removeFirst() ;
        L.addLast(9);
        L.addFirst(10);
        L.addFirst(11);
        L.addLast(12);
        L.addFirst(13);
        L.addLast(14);
        L.removeLast()   ;
        L.addLast(16);
        L.addLast(17);
        L.addFirst(18);
        int k = L.get(4) ;

    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests("all", ArrayDequeTest.class);
    }
}
