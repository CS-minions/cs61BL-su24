import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UnionFindTest {

    private UnionFind uf;

    @Before
    public void setUp() {
        // 初始化一个大小为 10 的 UnionFind 对象
        uf = new UnionFind(10);
    }

    @Test
    public void testInitialRoots() {
        // 测试初始时，每个元素都是自己的根
        for (int i = 0; i < 10; i++) {
            assertEquals("Element should be its own root", i, uf.find(i));
        }
    }

    @Test
    public void testInitialSize() {
        // 测试初始时，每个集合的大小都是 1
        for (int i = 0; i < 10; i++) {
            assertEquals("Each set should initially have size of 1", 1, uf.sizeOf(i));
        }
    }

    @Test
    public void testUnionAndConnected() {
        uf.union(1, 2);
        assertTrue("Element 1 and 2 should be connected", uf.connected(1, 2));
        assertEquals("Union of 1 and 2 should have size of 2", 2, uf.sizeOf(1));

        uf.union(2, 3);
        assertTrue("Element 1 and 3 should be connected via 2", uf.connected(1, 3));
        assertEquals("Union of 1, 2, 3 should have size of 3", 3, uf.sizeOf(1));

        // Testing the size after multiple unions
        uf.union(4, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        assertTrue("Element 4 and 7 should be connected", uf.connected(4, 7));
        assertEquals("Union of 4, 5, 6, 7 should have size of 4", 4, uf.sizeOf(7));
    }

    @Test
    public void testParentAndRoot() {
        uf.union(0, 1);
        uf.union(0, 2);
        assertFalse("5 should not be connected to 0", uf.connected(5, 0));
    }

    @Test
    public void testUnionSelf() {
        uf.union(0, 0);
        assertEquals("Union of self should not change size", 1, uf.sizeOf(0));
    }
}


