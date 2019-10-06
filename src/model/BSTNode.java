package model;

import java.util.List;

public class BSTNode<E extends Comparable<E>> {
	private E key;
	private BSTNode<E> parent;
	private BSTNode<E> left;
	private BSTNode<E> right;
	
	public BSTNode(E key) {
		this.key = key;
	}
	
	public boolean add(E newitem) {
		return add(new BSTNode<E>(newitem));
	}
	
	private boolean add(BSTNode<E> newitem) {
		newitem.setParent(this);
		if(newitem.key.compareTo(key) > 0) {
			if(right == null) {
				right = new BSTNode<E>(key);
				return true;
			} else {
				right.add(newitem);
			}
		} else {
			if(left == null) {
				newitem.setParent(left);
				left = new BSTNode<E>(key);
				return true;
			} else {
				left.add(newitem);
			}
		}
		return false;
	}
	
	public void preorderFill(List<E> p) {
		p.add(key);
		if(left != null) {
			left.preorderFill(p);
		}
		if(right != null) {
			right.preorderFill(p);
		}
	}
	
	public void inorderFill(List<E> p) {
		if(left != null) {
			left.inorderFill(p);
		}
		p.add(key);
		if(right != null) {
			right.inorderFill(p);
		}
	}
	
	public void postorderFill(List<E> p) {
		if(left != null) {
			left.postorderFill(p);
		}
		if(right != null) {
			right.postorderFill(p);
		}
		p.add(key);
	}
	
	public E minimum() {
		if(left != null) {
			return left.minimum();
		}
		return key;
	}
	
	public E maximum() {
		if(right != null) {
			return right.maximum();
		}
		return key;
	}

	public E getKey() {
		return key;
	}

	public void setKey(E key) {
		this.key = key;
	}

	public BSTNode<E> getLeft() {
		return left;
	}

	public void setLeft(BSTNode<E> left) {
		this.left = left;
	}

	public BSTNode<E> getRight() {
		return right;
	}

	public void setRight(BSTNode<E> right) {
		this.right = right;
	}

	public BSTNode<E> getParent() {
		return parent;
	}

	public void setParent(BSTNode<E> parent) {
		this.parent = parent;
	}
}
