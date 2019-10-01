package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class HeapTest {
	Comparator<Integer> compMin = Collections.reverseOrder();
	Comparator<Integer> compMax = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1-o2;
		}
		
	};
	
	private Heap<Integer> h;
	
	@Test
	public void testBuildMaxHeap() {
		h = new Heap<Integer>(compMax);
		Integer[] array = new Integer[]{5,7,10,1,4,6,8,2,9,12};
		h.setTree(array);
		Integer[] tree = h.getTree();
		System.out.println(Arrays.toString(tree));
		for (int i = 0; i < array.length; i++) {
			if(i == 0) {
				assertTrue(h.parent(i) < 0, "Root must not have a parent");
			} else {
				assertTrue(tree[h.parent(i)] > tree[i], "It is not a max-heap");
			}
		}
	}
	
	@Test
	public void testHeapSort() {
		testBuildMaxHeap();
		Integer[] sortedArray = h.getTree();
		Heap.HeapSort(sortedArray, h.getComp());
		System.out.println(Arrays.toString(sortedArray));
		for (int i = 1; i < sortedArray.length; i++) {
			assertTrue(sortedArray[i] > sortedArray[i-1], "Array is not sorted");
		}
	}

}
