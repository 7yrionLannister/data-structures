package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class AVLTest {
	private AVL<Integer, Integer> AVL;
	
	private void setupStage1() {
		AVL = new AVL<>();
		AVL.add(4, 4);
		AVL.add(2, 2);
		AVL.add(6, 6);
		AVL.add(1, 1);
		AVL.add(3, 3);
		AVL.add(5, 5);
		AVL.add(7, 7);
	}
	
	@Test
	public void createAVLTest() {
		AVL = new AVL<>();
		assertNull(AVL.getRoot(), "AVL must be empty");
	}

	@Test
	public void addAndSearchTest() {
		createAVLTest();
		int keyandval = 50;
		AVL.add(keyandval, keyandval);
		
		checkAVLProperty(AVL.getRoot());
		
		Integer found = AVL.search(keyandval); 
		assertTrue(AVL.getRoot().getKey() == keyandval && AVL.getRoot().getValue() == keyandval && found == keyandval, "Root is not the expected");
		for(int i = 0; i < 30; i++) {
			keyandval = (int)(Math.random()*100+1);
			AVL.add(keyandval, keyandval);
			
			checkAVLProperty(AVL.getRoot());
			
			found = AVL.search(keyandval);
			assertTrue(found == keyandval, "Element should be found as it was just added");
		}
		assertTrue(AVL.search(200) == null, "No element with key 200 was added so it should not be in the AVL");
	}
	
	@Test
	public void preorderTest() {
		setupStage1();
		ArrayList<Integer> p = new ArrayList<>();
		AVL.preorderFill(p);
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
		AVL.inorderFill(i);
		for (int j = 1; j < i.size(); j++) {
			assertTrue(i.get(j) >= i.get(j-1), "It is not inorder");
		}
	}
	
	@Test
	public void postOrderTest() {
		setupStage1();
		ArrayList<Integer> p = new ArrayList<>();
		AVL.postorderFill(p);
		assertTrue(p.get(0) == 1, "It is not preorder");
		assertTrue(p.get(1) == 3, "It is not preorder");
		assertTrue(p.get(2) == 2, "It is not preorder");
		assertTrue(p.get(3) == 5, "It is not preorder");
		assertTrue(p.get(4) == 7, "It is not preorder");
		assertTrue(p.get(5) == 6, "It is not preorder");
		assertTrue(p.get(6) == 4, "It is not preorder");
	}
	
	@Test
	public void successorTest() {
		setupStage1();
		ArrayList<Integer> i = new ArrayList<>();
		AVL.inorderFill(i);
		assertTrue(AVL.successor(i.get(0)) == 2, "Wrong successor");
		assertTrue(AVL.successor(i.get(1)) == 3, "Wrong successor");
		assertTrue(AVL.successor(i.get(2)) == 4, "Wrong successor");
		assertTrue(AVL.successor(i.get(3)) == 5, "Wrong successor");
		assertTrue(AVL.successor(i.get(4)) == 6, "Wrong successor");
		assertTrue(AVL.successor(i.get(5)) == 7, "Wrong successor");
		assertNull(AVL.successor(i.get(6)), "Wrong successor");
	}
	
	@Test
	public void predecessorTest() {
		setupStage1();
		ArrayList<Integer> i = new ArrayList<>();
		AVL.inorderFill(i);
		assertNull(AVL.predecessor(i.get(0)), "Wrong predecessor");
		assertTrue(AVL.predecessor(i.get(1)) == 1, "Wrong predecessor");
		assertTrue(AVL.predecessor(i.get(2)) == 2, "Wrong predecessor");
		assertTrue(AVL.predecessor(i.get(3)) == 3, "Wrong predecessor");
		assertTrue(AVL.predecessor(i.get(4)) == 4, "Wrong predecessor");
		assertTrue(AVL.predecessor(i.get(5)) == 5, "Wrong predecessor");
		assertTrue(AVL.predecessor(i.get(6)) == 6, "Wrong predecessor");
	}
	
	@Test
	public void deleteTest() {
		setupStage1();
		ArrayList<Integer> i = new ArrayList<>();
		
		int toRemove = 4;
		AVL.delete(toRemove);
		assertNull(AVL.search(toRemove), "Element was not deleted");
		i.clear();
		AVL.inorderFill(i);
		for (int j = 1; j < i.size(); j++) {
			assertTrue(i.get(j) >= i.get(j-1), "It is not inorder");
		}
		
		toRemove = 2;
		AVL.delete(toRemove);
		assertNull(AVL.search(toRemove), "Element was not deleted");
		i.clear();
		AVL.inorderFill(i);
		for (int j = 1; j < i.size(); j++) {
			assertTrue(i.get(j) >= i.get(j-1), "It is not inorder");
		}
		
		toRemove = 7;
		AVL.delete(toRemove);
		assertNull(AVL.search(toRemove), "Element was not deleted");
		i.clear();
		AVL.inorderFill(i);
		for (int j = 1; j < i.size(); j++) {
			assertTrue(i.get(j) >= i.get(j-1), "It is not inorder");
		}
		
		toRemove = 3;
		AVL.delete(toRemove);
		assertNull(AVL.search(toRemove), "Element was not deleted");
		i.clear();
		AVL.inorderFill(i);
		for (int j = 1; j < i.size(); j++) {
			assertTrue(i.get(j) >= i.get(j-1), "It is not inorder");
		}
		
		toRemove = 1;
		AVL.delete(toRemove);
		assertNull(AVL.search(toRemove), "Element was not deleted");
		i.clear();
		AVL.inorderFill(i);
		for (int j = 1; j < i.size(); j++) {
			assertTrue(i.get(j) >= i.get(j-1), "It is not inorder");
		}
		
		toRemove = 5;
		AVL.delete(toRemove);
		assertNull(AVL.search(toRemove), "Element was not deleted");
		i.clear();
		AVL.inorderFill(i);
		for (int j = 1; j < i.size(); j++) {
			assertTrue(i.get(j) >= i.get(j-1), "It is not inorder");
		}
		
		toRemove = 6;
		AVL.delete(toRemove);
		assertNull(AVL.search(toRemove), "Element was not deleted");
		i.clear();
		AVL.inorderFill(i);
		for (int j = 1; j < i.size(); j++) {
			assertTrue(i.get(j) >= i.get(j-1), "It is not inorder");
		}
		
		assertNull(AVL.getRoot(), "All the elements in the tree were removed so it must be empty");
	}
	
	public void checkAVLProperty(AVLNode<Integer, Integer> node) {
		System.out.println("node: "+node.getValue()+", bf: " + node.getBalanceFactor());
		assertTrue(Math.abs(node.getBalanceFactor()) <= 1, "Tree is not height balanced");
		if(node.getLeft() != null) {
			checkAVLProperty(node.getLeft());
		}
		if(node.getRight() != null) {
			checkAVLProperty(node.getRight());
		}
	}
}
