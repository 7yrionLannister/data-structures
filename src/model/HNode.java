package model;


public class HNode<K, V> {
	private K key;
	private V value;
	
	public HNode(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public V getValue() {
		return value;
	}
	
	public void setValue(V value) {
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	
	public void setKey(K key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "("+key+","+value+")";
	}
}
