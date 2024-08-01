import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;

public class BinaryTreeTest {
    @Test
    public void sampleHeightTest() {
        // 测试空树
        BinaryTree<String> emptyTree = new BinaryTree<>();
        assertThat(emptyTree.height()).isEqualTo(0);

        // 测试只有一个节点的树
        BinaryTree<String> sample1 = BinaryTree.sampleTree1();
        assertThat(sample1.height()).isEqualTo(2);

        // 测试更复杂的树结构
        BinaryTree<String> sample2 = BinaryTree.sampleTree2();
        assertThat(sample2.height()).isEqualTo(4);

        BinaryTree<String> sample3 = BinaryTree.sampleTree3();
        assertThat(sample3.height()).isEqualTo(4);

        BinaryTree<String> sample4 = BinaryTree.sampleTree4();
        assertThat(sample4.height()).isEqualTo(3);
    }
    @Test
    public void testIsCompletelyBalanced() {
        // 测试空树
        BinaryTree<String> emptyTree = new BinaryTree<>();
        assertThat(emptyTree.isCompletelyBalanced()).isTrue();

        // 测试只有一个节点的树
        BinaryTree<String> singleNodeTree = new BinaryTree<>(new BinaryTree.TreeNode<>("a"));
        assertThat(singleNodeTree.isCompletelyBalanced()).isTrue();

        // 测试完全平衡的树
        BinaryTree<String> balancedTree = BinaryTree.sampleTree1();
        assertThat(balancedTree.isCompletelyBalanced()).isTrue();

        // 测试不完全平衡的树
        BinaryTree<String> unbalancedTree = BinaryTree.sampleTree2();
        assertThat(unbalancedTree.isCompletelyBalanced()).isFalse();

        // 测试更复杂的不完全平衡的树
        BinaryTree<String> moreComplexUnbalancedTree = BinaryTree.sampleTree3();
        assertThat(moreComplexUnbalancedTree.isCompletelyBalanced()).isFalse();
    }

    @Test
    public void testFibTree() {
        testFibTreeStructureAndValue();
    }

    private void testFibTreeStructureAndValue() {
        BinaryTree<Integer> fibTree0 = BinaryTree.fibTree(0);
        assertEquals("Fibonacci tree for 0 should have the root value 0", Integer.valueOf(0), fibTree0.getRoot().getItem());

        BinaryTree<Integer> fibTree1 = BinaryTree.fibTree(1);
        assertEquals("Fibonacci tree for 1 should have the root value 1", Integer.valueOf(1), fibTree1.getRoot().getItem());

        BinaryTree<Integer> fibTree5 = BinaryTree.fibTree(5);
        assertEquals("Fibonacci tree for 5 should have the root value 5", Integer.valueOf(5), fibTree5.getRoot().getItem());
        assertEquals("Fibonacci tree node for F(4)", Integer.valueOf(3), fibTree5.getRoot().getLeft().getItem());
        assertEquals("Fibonacci tree node for F(3)", Integer.valueOf(2), fibTree5.getRoot().getLeft().getLeft().getItem());
    }
    // TODO: Add more tests below.
    @Test
    public void testAddAndContains() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // Initially, tree should not contain any elements
        assertThat(bst.contains(10)).isFalse();

        // Add elements to the tree
        bst.add(10);
        bst.add(15);
        bst.add(5);
        bst.add(10); // Attempt to add duplicate

        // Check if elements are correctly added and duplicates are not added
        assertThat(bst.contains(10)).isTrue();
        assertThat(bst.contains(15)).isTrue();
        assertThat(bst.contains(5)).isTrue();
        assertThat(bst.contains(20)).isFalse(); // Check non-existing element

        // The size or count test could be used if you have implemented a size function
        // assertThat(bst.size()).isEqualTo(3);
    }

    @Test
    public void testTreeStructureAfterAdditions() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(20);
        bst.add(10);
        bst.add(30);
        bst.add(5);
        bst.add(15);

        // Check root and its direct children
        assertThat(bst.getRoot().getItem()).isEqualTo(20);
        assertThat(bst.getRoot().getLeft().getItem()).isEqualTo(10);
        assertThat(bst.getRoot().getRight().getItem()).isEqualTo(30);

        // Further check the structure
        assertThat(bst.getRoot().getLeft().getLeft().getItem()).isEqualTo(5);
        assertThat(bst.getRoot().getLeft().getRight().getItem()).isEqualTo(15);
    }
}
