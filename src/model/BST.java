package model;

import java.util.List;

/**This class is provided as the primary way to access a BST and its functionalities<br>
 * Any insertion and deletion must be performed through this class and not directly in BSTNode 
 * and, no other class should directly access the setKey(k) method of the BSTNode class(except this class)  
 * as it may cause the tree to not fulfill the order property*/
public class BST<K extends Comparable<K>, V> {
	private BSTNode<K ,V> root;

	public void add(K key, V value) {
		if(root == null) {
			root = new BSTNode<>(key, value);
		} else {
			root.add(new BSTNode<>(key, value));
		}
	}

	public boolean delete(BSTNode<K, V> z) {
		BSTNode<K, V> y;
		if(z != null) {
			if(z.getLeft() == null || z.getRight() == null) {
				y = z;
			} else {
				y = successor(z);
			}
			
			BSTNode<K, V> x;
			
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
	
	public BSTNode<K, V> search(K key) {
		if(root != null) {
			return root.search(key);
		} 
		return null;
	}

	public void preorderFill(List<BSTNode<K, V>> p) {
		if(root != null) {
			root.preorderFill(p);
		}
	}

	public void inorderFill(List<BSTNode<K, V>> i) {
		if(root != null) {
			root.inorderFill(i);
		}
	}

	public void postorderFill(List<BSTNode<K, V>> p) {
		if(root != null) {
			root.postorderFill(p);
		}
	}
	
	public BSTNode<K, V> minimum() {
		if(root != null) {
			return root.minimum();
		}
		return null;
	}
	
	public BSTNode<K, V> maximum() {
		if(root != null) {
			return root.maximum();
		}
		return null;
	}
	
	public BSTNode<K, V> successor(BSTNode<K, V> src) {
		if(src.getRight() != null) {
			return src.getRight().minimum();
		} else {
			BSTNode<K, V> prnt = src.getParent();
			while(prnt != null && src == prnt.getRight()) {
				src = prnt;
				prnt = prnt.getParent();
			}
			return prnt;
		}
	}
	
	public BSTNode<K, V> predecessor(BSTNode<K, V> src) {
		if(src.getLeft() != null) {
			return src.getLeft().maximum();
		} else {
			BSTNode<K, V> prnt = src.getParent();
			while(prnt != null && src == prnt.getLeft()) {
				src = prnt;
				prnt = prnt.getParent();
			}
			return prnt;
		}
	}

	public BSTNode<K, V> getRoot() {
		return root;
	}
}
