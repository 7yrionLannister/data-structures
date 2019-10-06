package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class BSTTest {
	private BST<Integer, Integer> bst;
	
	private void setupStage1() {
		bst = new BST<>();
		bst.add(4, 4);
		bst.add(2, 2);
		bst.add(6, 6);
		bst.add(1, 1);
		bst.add(3, 3);
		bst.add(5, 5);
		bst.add(7, 7);
	}
	
	@Test
	public void createBSTTest() {
		bst = new BST<>();
		assertNull(bst.getRoot(), "BST must be empty");
	}

	@Test
	public void addAndSearchTest() {
		createBSTTest();
		int keyandval = 50;
		bst.add(keyandval, keyandval);
		Integer found = bst.search(keyandval); 
		assertTrue(bst.getRoot().getKey() == keyandval && bst.getRoot().getValue() == keyandval && found == keyandval, "Root is not the expected");
		for(int i = 0; i < 30; i++) {
			keyandval = (int)(Math.random()*100+1);
			bst.add(keyandval, keyandval);
			found = bst.search(keyandval);
			assertTrue(found == keyandval, "Element should be found as it was just added");
		}
		assertTrue(bst.search(200) == null, "No element with key 200 was added so it should not be in the BST");
	}
	
	@Test
	public void preorderTest() {
		setupStage1();
		ArrayList<Integer> p = new ArrayList<>();
		bst.preorderFill(p);
		assertTrue(p.get(0) == 4, "It is not preorder");
		assertTrue(p.get(1) == 2, "It is not preorder");
		assertTrue(p.get(2) == 1, "It is not preorder");
		assertTrue(p.get(3) == 3, "It is not preorder");
		assertTrue(p.get(4) == 6, "It is not preorder");
		assertTrue(p.get(5) == 5, "It is not preorder");
		assertTrue(p.get(6) == 7, "It is not preorder");
	}
	
	@Test
	public void inorderTest() {
		setupStage1();
		ArrayList<Integer> i = new ArrayList<>();
		bst.inorderFill(i);
		for (int j = 0; j < i.size(); j++) {
			assertTrue(i.get(j) == j+1, "It is not inorder");
		}
	}
	
	@Test
	public void postOrderTest() {
		setupStage1();
		ArrayList<Integer> p = new ArrayList<>();
		bst.postorderFill(p);
		assertTrue(p.get(0) == 1, "It is not preorder");
		assertTrue(p.get(1) == 3, "It is not preorder");
		assertTrue(p.get(2) == 2, "It is not preorder");
		assertTrue(p.get(3) == 5, "It is not preorder");
		assertTrue(p.get(4) == 7, "It is not preorder");
		assertTrue(p.get(5) == 6, "It is not preorder");
		assertTrue(p.get(6) == 4, "It is not preorder");
		bst.getRoot().getLeft() = null;
	}
}
