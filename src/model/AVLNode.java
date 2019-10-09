package model;

import java.util.List;

public class AVLNode<K extends Comparable<K>, V> {
	private K key;
	private V value;
	private AVLNode<K, V> parent;
	private AVLNode<K, V> left;
	private AVLNode<K, V> right;
	private int heigh;
	private int balanceFactor;
	
	public AVLNode(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	/**Use this function through BTS to ensure the order condition throughout the tree
	 * */
	public boolean add(AVLNode<K, V> newitem) {
		newitem.parent = this;
		if(newitem.key.compareTo(key) > 0) {
			if(right == null) {
				right = newitem;
				return true;
			} else {
				right.add(newitem);
			}
		} else if(newitem.key.compareTo(key) < 0){
			if(left == null) {
				left = newitem;
				return true;
			} else {
				left.add(newitem);
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
	
	public void preorderFill(List<AVLNode<K, V>> p) {
		p.add(this);
		if(left != null) {
			left.preorderFill(p);
		}
		if(right != null) {
			right.preorderFill(p);
		}
	}
	
	public void inorderFill(List<AVLNode<K, V>> i) {
		if(left != null) {
			left.inorderFill(i);
		}
		i.add(this);
		if(right != null) {
			right.inorderFill(i);
		}
	}
	
	public void postorderFill(List<AVLNode<K, V>> p) {
		if(left != null) {
			left.postorderFill(p);
		}
		if(right != null) {
			right.postorderFill(p);
		}
		p.add(this);
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

	public int getHeigh() {
		return heigh;
	}

	public void setHeigh(int heigh) {
		this.heigh = heigh;
	}

	public int getBalanceFactor() {
		return balanceFactor;
	}

	public void setBalanceFactor(int balanceFactor) {
		this.balanceFactor = balanceFactor;
	}
}
