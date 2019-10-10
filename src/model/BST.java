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

	public boolean delete(K key) {
		BSTNode<K, V> node = searchNode(key);
		if(node != null) {
			delete(node);
			return true;
		}
		return false;
	}
	
	private void delete(BSTNode<K, V> z) {
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
	}
	
	public V search(K key) {
		BSTNode<K, V> node = searchNode(key);
		if(node != null) {
			return node.getValue();
		}
		return null;
	}
	
	private BSTNode<K, V> searchNode(K key) {
		if(root != null) {
			return root.search(key);
		} 
		return null;
	}

	public void preorderFill(List<V> p) {
		if(root != null) {
			root.preorderFill(p);
		}
	}

	public void inorderFill(List<V> i) {
		if(root != null) {
			root.inorderFill(i);
		}
	}

	public void postorderFill(List<V> p) {
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
	
	public V successor(K src) {
		BSTNode<K, V> node = searchNode(src);
		BSTNode<K, V> suc;
		if(node != null) {
			suc = successor(node);
			if(suc != null) {
				return suc.getValue();
			}
		}
		return null;
	}
	
	private BSTNode<K, V> successor(BSTNode<K, V> src) {
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
	
	public V predecessor(K src) {
		BSTNode<K, V> node = searchNode(src);
		BSTNode<K, V> pre;
		if(node != null) {
			pre = predecessor(node);
			if(pre != null) {
				return pre.getValue();
			}
		}
		return null;
	}
	
	private BSTNode<K, V> predecessor(BSTNode<K, V> src) {
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
