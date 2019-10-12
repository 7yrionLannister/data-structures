package model;

import java.util.List;

public class AVLNode<K extends Comparable<K>, V> {
	private K key;
	private V value;
	private AVLNode<K, V> parent;
	private AVLNode<K, V> left;
	private AVLNode<K, V> right;
	private int height;
	private int balanceFactor;

	public AVLNode(K key, V value) {
		this.key = key;
		this.value = value;
		balanceFactor = 0;
		height = 1;
	}

	/**Use this function through BTS to ensure the order condition throughout the tree
	 * */
	public boolean add(AVLNode<K, V> newitem) {
		newitem.parent = this;
		int comp = newitem.key.compareTo(key); 
		if(comp > 0) {
			if(right == null) {
				right = newitem;
				return true;
			} else {
				return right.add(newitem);
			}
		} else if(comp < 0) {
			if(left == null) {
				left = newitem;
				return true;
			} else {
				return left.add(newitem);
			}
		}
		return false;
	}

	public AVLNode<K, V> search(K key) {
		int comp = this.key.compareTo(key); 
		if(comp == 0) {
			return this;
		} else if(comp < 0 && right != null) {
			return right.search(key);
		} else if(comp > 0 && left != null) {
			return left.search(key);
		}
		return null;
	}

	public void preorderFill(List<V> p) {
		p.add(value);
		if(left != null) {
			left.preorderFill(p);
		}
		if(right != null) {
			right.preorderFill(p);
		}
	}

	public void inorderFill(List<V> i) {
		if(left != null) {
			left.inorderFill(i);
		}
		i.add(value);
		if(right != null) {
			right.inorderFill(i);
		}
	}

	public void postorderFill(List<V> p) {
		if(left != null) {
			left.postorderFill(p);
		}
		if(right != null) {
			right.postorderFill(p);
		}
		p.add(value);
	}

	public AVLNode<K, V> minimum() {
		if(left != null) {
			return left.minimum();
		}
		return this;
	}

	public AVLNode<K, V> maximum() {
		if(right != null) {
			return right.maximum();
		}
		return this;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K k) {
		key = k;
	}

	public AVLNode<K, V> getLeft() {
		return left;
	}

	public void setLeft(AVLNode<K ,V> l) {
		left = l;
	}

	public AVLNode<K, V> getRight() {
		return right;
	}

	public void setRight(AVLNode<K, V> r) {
		right = r;
	}

	public AVLNode<K, V> getParent() {
		return parent;
	}

	public void setParent(AVLNode<K, V> p) {
		parent = p;
	} 

	public V getValue() {
		return value;
	}

	public void setValue(V v) {
		value = v;
	}

	public int getheight() {
		return height;
	}

	public void setheight(int height) {
		this.height = height;
	}

	public int getBalanceFactor() {
		return balanceFactor;
	}

	public void setBalanceFactor(int balanceFactor) {
		this.balanceFactor = balanceFactor;
	}
}
