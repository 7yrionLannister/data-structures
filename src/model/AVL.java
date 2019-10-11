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
			AVLNode<K, V> node = new AVLNode<>(key, value);
			root.add(node);
			refreshAncestorsHeightAndBalanceFactor(node);
		}
	}
	
	public void refreshAncestorsHeightAndBalanceFactor(AVLNode<K, V> node) {
		AVLNode<K, V> parent = node.getParent();
		if(parent != null) {
			AVLNode<K, V> left = parent.getLeft();
			AVLNode<K, V> right = parent.getRight();
			int maxHeight = Integer.MIN_VALUE;
			int heightLeft = 0;
			int heightRight = 0;
			if(left != null) {
				heightLeft = left.getheight();
			}
			if(right != null) {
				heightRight = right.getheight();
			}
			maxHeight = Math.max(heightLeft, heightRight);
			parent.setheight(maxHeight+1);
			parent.setBalanceFactor(heightRight-heightLeft);
			refreshAncestorsHeightAndBalanceFactor(parent);
		}
	}

	public boolean delete(K key) {
		AVLNode<K, V> node = searchNode(key);
		if(node != null) {
			delete(node);
			return true;
		}
		return false;
	}
	
	private boolean delete(AVLNode<K, V> z) {
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
	
	public V search(K key) {
		AVLNode<K, V> node = searchNode(key);
		if(node != null) {
			return node.getValue();
		}
		return null;
	}
	
	private AVLNode<K, V> searchNode(K key) {
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
	
	public V successor(K src) {
		AVLNode<K, V> node = searchNode(src);
		AVLNode<K, V> suc;
		if(node != null) {
			suc = successor(node);
			if(suc != null) {
				return suc.getValue();
			}
		}
		return null;
	}
	
	private AVLNode<K, V> successor(AVLNode<K, V> src) {
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
	
	public V predecessor(K src) {
		AVLNode<K, V> node = searchNode(src);
		AVLNode<K, V> pre;
		if(node != null) {
			pre = predecessor(node);
			if(pre != null) {
				return pre.getValue();
			}
		}
		return null;
	}
	
	private AVLNode<K, V> predecessor(AVLNode<K, V> src) {
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
		
		target.setParent(right);
		if(parent == null) {
			root = right;
		} else {
			if(parent.getLeft() == target) {
				parent.setLeft(right);
			} else {
				parent.setRight(right);
			}
		}
		
		right.setLeft(target);
		
		refreshAncestorsHeightAndBalanceFactor(target);
	}
	
	public void rightRotate(AVLNode<K, V> target) {
		AVLNode<K, V> left = target.getLeft();
		if(left == null) {
			throw new IllegalStateException();
		}
		AVLNode<K, V> rightOfLeftSubtree = left.getRight();
		if(rightOfLeftSubtree != null) {
			rightOfLeftSubtree.setParent(target);
		}
		target.setLeft(rightOfLeftSubtree);
		
		AVLNode<K, V> parent = target.getParent();
		left.setParent(parent);
		
		target.setParent(left);
		if(parent == null) {
			root = left;
		} else {
			if(parent.getLeft() == target) {
				parent.setLeft(left);
			} else {
				parent.setRight(left);
			}
		}
		
		left.setRight(target);
		
		refreshAncestorsHeightAndBalanceFactor(target);
	}
	
	public AVLNode<K, V> getRoot() {
		return root;
	}
}
