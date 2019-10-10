package model;

import java.util.List;

public class BSTNode<K extends Comparable<K>, V> {
	private K key;
	private V value;
	private BSTNode<K, V> parent;
	private BSTNode<K, V> left;
	private BSTNode<K, V> right;
	
	public BSTNode(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	/**Use this function through BTS to ensure the order condition throughout the tree
	 * */
	public boolean add(BSTNode<K, V> newitem) {
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
	
	public BSTNode<K, V> search(K key) {
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
	
	public BSTNode<K, V> minimum() {
		if(left != null) {
			return left.minimum();
		}
		return this;
	}
	
	public BSTNode<K, V> maximum() {
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

	public BSTNode<K, V> getLeft() {
		return left;
	}
	
	public void setLeft(BSTNode<K ,V> l) {
		left = l;
	}

	public BSTNode<K, V> getRight() {
		return right;
	}
	
	public void setRight(BSTNode<K, V> r) {
		right = r;
	}

	public BSTNode<K, V> getParent() {
		return parent;
	}
	
	public void setParent(BSTNode<K, V> p) {
		parent = p;
	} 

	public V getValue() {
		return value;
	}
	
	public void setValue(V v) {
		value = v;
	}
}
