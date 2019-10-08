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
		Integer found = bst.search(keyandval).getKey(); 
		assertTrue(bst.getRoot().getKey() == keyandval && bst.getRoot().getValue() == keyandval && found == keyandval, "Root is not the expected");
		for(int i = 0; i < 30; i++) {
			keyandval = (int)(Math.random()*100+1);
			bst.add(keyandval, keyandval);
			found = bst.search(keyandval).getKey();
			assertTrue(found == keyandval, "Element should be found as it was just added");
		}
		assertTrue(bst.search(200) == null, "No element with key 200 was added so it should not be in the BST");
	}
	
	@Test
	public void preorderTest() {
		setupStage1();
		ArrayList<BSTNode<Integer, Integer>> p = new ArrayList<>();
		bst.preorderFill(p);
		assertTrue(p.get(0).getKey() == 4, "It is not preorder");
		assertTrue(p.get(1).getKey() == 2, "It is not preorder");
		assertTrue(p.get(2).getKey() == 1, "It is not preorder");
		assertTrue(p.get(3).getKey() == 3, "It is not preorder");
		assertTrue(p.get(4).getKey() == 6, "It is not preorder");
		assertTrue(p.get(5).getKey() == 5, "It is not preorder");
		assertTrue(p.get(6).getKey() == 7, "It is not preorder");
	}
	
	@Test
	public void inorderTest() {
		setupStage1();
		ArrayList<BSTNode<Integer, Integer>> i = new ArrayList<>();
		bst.inorderFill(i);
		for (int j = 1; j < i.size(); j++) {
			assertTrue(i.get(j).getKey() >= i.get(j-1).getKey(), "It is not inorder");
		}
	}
	
	@Test
	public void postOrderTest() {
		setupStage1();
		ArrayList<BSTNode<Integer, Integer>> p = new ArrayList<>();
		bst.postorderFill(p);
		assertTrue(p.get(0).getKey() == 1, "It is not preorder");
		assertTrue(p.get(1).getKey() == 3, "It is not preorder");
		assertTrue(p.get(2).getKey() == 2, "It is not preorder");
		assertTrue(p.get(3).getKey() == 5, "It is not preorder");
		assertTrue(p.get(4).getKey() == 7, "It is not preorder");
		assertTrue(p.get(5).getKey() == 6, "It is not preorder");
		assertTrue(p.get(6).getKey() == 4, "It is not preorder");
	}
	
	@Test
	public void successorTest() {
		setupStage1();
		ArrayList<BSTNode<Integer, Integer>> i = new ArrayList<>();
		bst.inorderFill(i);
		assertTrue(bst.successor(i.get(0)).getKey() == 2, "Wrong successor");
		assertTrue(bst.successor(i.get(1)).getKey() == 3, "Wrong successor");
		assertTrue(bst.successor(i.get(2)).getKey() == 4, "Wrong successor");
		assertTrue(bst.successor(i.get(3)).getKey() == 5, "Wrong successor");
		assertTrue(bst.successor(i.get(4)).getKey() == 6, "Wrong successor");
		assertTrue(bst.successor(i.get(5)).getKey() == 7, "Wrong successor");
		assertNull(bst.successor(i.get(6)), "Wrong successor");
	}
	
	@Test
	public void predecessorTest() {
		setupStage1();
		ArrayList<BSTNode<Integer, Integer>> i = new ArrayList<>();
		bst.inorderFill(i);
		assertNull(bst.predecessor(i.get(0)), "Wrong predecessor");
		assertTrue(bst.predecessor(i.get(1)).getKey() == 1, "Wrong predecessor");
		assertTrue(bst.predecessor(i.get(2)).getKey() == 2, "Wrong predecessor");
		assertTrue(bst.predecessor(i.get(3)).getKey() == 3, "Wrong predecessor");
		assertTrue(bst.predecessor(i.get(4)).getKey() == 4, "Wrong predecessor");
		assertTrue(bst.predecessor(i.get(5)).getKey() == 5, "Wrong predecessor");
		assertTrue(bst.predecessor(i.get(6)).getKey() == 6, "Wrong predecessor");
	}
	
	@Test
	public void deleteTest() {
		setupStage1();
		ArrayList<BSTNode<Integer,Integer>> i = new ArrayList<>();
		
		int toRemove = 4;
		bst.delete(bst.search(toRemove));
		i.clear();
		bst.inorderFill(i);
		for (int j = 1; j < i.size(); j++) {
			assertTrue(i.get(j).getKey() >= i.get(j-1).getKey(), "It is not inorder");
		}
		
		toRemove = 2;
		bst.delete(bst.search(toRemove));
		i.clear();
		bst.inorderFill(i);
		for (int j = 1; j < i.size(); j++) {
			assertTrue(i.get(j).getKey() >= i.get(j-1).getKey(), "It is not inorder");
		}
		
		toRemove = 7;
		bst.delete(bst.search(toRemove));
		i.clear();
		bst.inorderFill(i);
		for (int j = 1; j < i.size(); j++) {
			assertTrue(i.get(j).getKey() >= i.get(j-1).getKey(), "It is not inorder");
		}
		
		toRemove = 3;
		bst.delete(bst.search(toRemove));
		i.clear();
		bst.inorderFill(i);
		for (int j = 1; j < i.size(); j++) {
			assertTrue(i.get(j).getKey() >= i.get(j-1).getKey(), "It is not inorder");
		}
		
		toRemove = 1;
		bst.delete(bst.search(toRemove));
		i.clear();
		bst.inorderFill(i);
		for (int j = 1; j < i.size(); j++) {
			assertTrue(i.get(j).getKey() >= i.get(j-1).getKey(), "It is not inorder");
		}
		
		toRemove = 5;
		bst.delete(bst.search(toRemove));
		i.clear();
		bst.inorderFill(i);
		for (int j = 1; j < i.size(); j++) {
			assertTrue(i.get(j).getKey() >= i.get(j-1).getKey(), "It is not inorder");
		}
		
		toRemove = 6;
		bst.delete(bst.search(toRemove));
		i.clear();
		bst.inorderFill(i);
		for (int j = 1; j < i.size(); j++) {
			assertTrue(i.get(j).getKey() >= i.get(j-1).getKey(), "It is not inorder");
		}
		
		assertNull(bst.getRoot(), "All the elements in the tree were removed so it must be empty");
	}
}
