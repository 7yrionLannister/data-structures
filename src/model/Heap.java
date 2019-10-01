package model;

import java.util.Comparator;

public class Heap<E> {
	private E[] tree;
	private int heapSize;
	private Comparator<E> comp;
	
	//puede definir el orden definiendo un Comparator
	//comp es necesario ya que aqui no se toma en cuenta el orden natural
	//si comp es Collections.reverseOrder entonces el comportamiento sera el de un minHeap
	//        de lo contrario es un max-heap
	public Heap(Comparator<E> comp) {
		this.comp = comp;
	}
	
	public int left(int index) {
		return 2*index + 1;
	}
	
	public int right(int index) {
		return 2*(index+1);
	}
	
	public int parent(int index) {
		return (index - 1)/2;
	}
	
	//max seria min si se inicializo como un min-heap
	public void heapify(int index) {
		int l = left(index);
		int r = right(index);
		int max = index;
		if(l < heapSize && comp.compare(tree[l], tree[max]) > 0) {
			max = l;
		}
		if(r < heapSize && comp.compare(tree[r], tree[max]) > 0) {
			max = r;
		}
		
		E current = tree[index];
		if(comp.compare(tree[max], current) != 0) {
			tree[index] = tree[max];
			tree[max] = current;
			heapify(max);
		}
	}
	
	public E[] getTree() {
		return tree;
	}

	public void buildHeap(E[] array) {
		int firstInnerNode = parent(tree.length-1);
		heapSize = tree.length;
		while(firstInnerNode > -1) {
			heapify(firstInnerNode);
			firstInnerNode--;
		}
	}
	
	//TODO use buil-heap
	public void setTree(E[] array) {
		tree = array;
		buildHeap(tree);
	}	
}
