package model;

import java.util.List;

/**This class is provided as the primary way to access a AVL and its functionalities<br>
 * Any insertion and deletion must be performed through this class and not directly in AVLNode 
 * and, no other class should directly access the setKey(k) method of the AVLNode class(except this class)  
 * as it may cause the tree to not fulfill the order property*/
public class AVL<K extends Comparable<K>, V> {
	private AVLNode<K ,V> root;

	public void add(K key, V value) {
		if(root == null) {
			root = new AVLNode<>(key, value);
		} else {
			root.add(new AVLNode<>(key, value));
		}
	}

	public boolean delete(AVLNode<K, V> z) {
		AVLNode<K, V> y;
		if(z != null) {
			if(z.getLeft() == null || z.getRight() == null) {
				y = z;
			} else {
				y = successor(z);
			}
			
			AVLNode<K, V> x;
			
			if(y.getLeft() != null) {
				x = y.getLeft();
			} else {
				x = y.getRight();
			}
			
			if(x != null) {
				x.setParent(y.getParent());
			}
			
			if(y.getParent() == null) {
				root = x;
			} else if(y == y.getParent().getLeft()) {
				y.getParent().setLeft(x);
			} else {
				y.getParent().setRight(x);
			}
			
			if(y != z) {
				z.setKey(y.getKey());
				z.setValue(y.getValue());
			}
		}
		return false;
	}
	
	public AVLNode<K, V> search(K key) {
		if(root != null) {
			return root.search(key);
		} 
		return null;
	}

	public void preorderFill(List<AVLNode<K, V>> p) {
		if(root != null) {
			root.preorderFill(p);
		}
	}

	public void inorderFill(List<AVLNode<K, V>> i) {
		if(root != null) {
			root.inorderFill(i);
		}
	}

	public void postorderFill(List<AVLNode<K, V>> p) {
		if(root != null) {
			root.postorderFill(p);
		}
	}
	
	public AVLNode<K, V> minimum() {
		if(root != null) {
			return root.minimum();
		}
		return null;
	}
	
	public AVLNode<K, V> maximum() {
		if(root != null) {
			return root.maximum();
		}
		return null;
	}
	
	public AVLNode<K, V> successor(AVLNode<K, V> src) {
		if(src.getRight() != null) {
			return src.getRight().minimum();
		} else {
			AVLNode<K, V> prnt = src.getParent();
			while(prnt != null && src == prnt.getRight()) {
				src = prnt;
				prnt = prnt.getParent();
			}
			return prnt;
		}
	}
	
	public AVLNode<K, V> predecessor(AVLNode<K, V> src) {
		if(src.getLeft() != null) {
			return src.getLeft().maximum();
		} else {
			AVLNode<K, V> prnt = src.getParent();
			while(prnt != null && src == prnt.getLeft()) {
				src = prnt;
				prnt = prnt.getParent();
			}
			return prnt;
		}
	}

	public void leftRotate(AVLNode<K, V> target) {
		AVLNode<K, V> right = target.getRight();
		if(right == null) {
			throw new IllegalStateException();
		}
		AVLNode<K, V> leftOfRightSubtree = right.getLeft();
		if(leftOfRightSubtree != null) {
			leftOfRightSubtree.setParent(target);
		}
		target.setRight(leftOfRightSubtree);
		
		AVLNode<K, V> parent = target.getParent();
		right.setParent(parent);
		
		if(parent == null) {
			root = right;
			target.setParent(root);
		} else {
			if(parent.getLeft() == target) {
				parent.setLeft(right);
			} else {
				parent.setRight(right);
			}
		}
		
		right.setLeft(target);
	}
	
	public AVLNode<K, V> getRoot() {
		return root;
	}
}
