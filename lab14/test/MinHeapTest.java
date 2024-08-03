import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MinHeapTest {
    private MinHeap<Integer> heap;

    @Before
    public void setUp() {
        heap = new MinHeap<>();
    }

    @Test
    public void testHeapInitialization() {
        assertTrue("Heap should be initialized empty", heap.size() == 0);
        assertNull("Min of an empty heap should be null", heap.findMin());
    }

    @Test
    public void testInsertAndRemoveSingleElement() {
        heap.insert(10);
        assertEquals("Heap size should be 1 after one insert", 1, heap.size());
        assertEquals("Min should be the only element inserted", Integer.valueOf(10), heap.findMin());
        assertEquals("Remove min should return the only element", Integer.valueOf(10), heap.removeMin());
        assertTrue("Heap should be empty after removal", heap.size() == 0);
    }

    @Test
    public void testInsertMultipleElements() {
        int[] elements = {5, 2, 9, 1, 7};
        for (int element : elements) {
            heap.insert(element);
        }
        assertEquals("Correct min after multiple inserts", Integer.valueOf(1), heap.findMin());
    }

    @Test
    public void testSequentialRemoveMin() {
        int[] elements = {5, 3, 8, 1, 6};
        for (int element : elements) {
            heap.insert(element);
        }
        assertEquals("First min should be 1", Integer.valueOf(1), heap.removeMin());
        assertEquals("Next min should be 3", Integer.valueOf(3), heap.removeMin());
        assertEquals("Next min should be 5", Integer.valueOf(5), heap.removeMin());
        assertEquals("Next min should be 6", Integer.valueOf(6), heap.removeMin());
        assertEquals("Last min should be 8", Integer.valueOf(8), heap.removeMin());
        assertTrue("Heap should be empty after all removals", heap.size() == 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertDuplicateElement() {
        heap.insert(4);
        heap.insert(4); // This should throw IllegalArgumentException
    }

    @Test
    public void testRemoveMinOnEmptyHeap() {
        assertNull("Removing min from an empty heap should return null", heap.removeMin());
    }

    @Test
    public void testHeapPropertyAfterRandomInsertsAndRemoves() {
        int[] elements = {10, 4, 15, 1, 3, 9, 20, 15, 8, 2};
        for (int element : elements) {
            heap.insert(element);
        }
        Integer prevMin = heap.removeMin(); // Should be 1
        while (heap.size() > 0) {
            Integer currentMin = heap.removeMin();
            assertTrue("Each removed element should be greater than the last", prevMin <= currentMin);
            prevMin = currentMin;
        }
    }
}
