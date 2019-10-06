package model;

import java.util.List;

public class BST<K extends Comparable<K>, V> {
	private BSTNode<K ,V> root;

	public void add(K key, V value) {
		if(root == null) {
			root = new BSTNode<>(key, value);
		} else {
			root.add(new BSTNode<>(key, value));
		}
	}

	public V search(K key) {
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

	public BSTNode<K, V> getRoot() {
		return root;
	}
}
