package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import util.Util;

public class HeapImpl<T extends Comparable<T>> implements Heap<T> {

	protected T[] heap;
	protected int index = -1;
	protected Comparator<T> comparator;
	private static final int INITIAL_SIZE = 20;
	private static final int INCREASING_FACTOR = 10;

	public HeapImpl(Comparator<T> comparator) {
		this.heap = (T[]) new Comparable[INITIAL_SIZE];
		this.comparator = comparator;
	}

	private int parent(int i) {
		return (i - 1) / 2;
	}

	private int left(int i) {
		return (i * 2 + 1);
	}

	private int right(int i) {
		return (i * 2 + 1) + 1;
	}

	private void heapify(int position) {
		int larger = position;
		int left = left(position);
		int right = right(position);

		if (heap[left] != null && comparator.compare(heap[left], heap[larger]) > 0) {
			larger = left;
		}

		if (heap[right] != null && comparator.compare(heap[right], heap[larger]) > 0) {
			larger = right;
		}

		if (larger != position) {
			Util.swap(heap, position, larger);
			heapify(larger);
		}
	}

	@Override
	public boolean isEmpty() {
		return index == -1;
	}

	@Override
	public void insert(T element) {
		if (element != null) {

			if (index == heap.length - 1) {
				heap = Arrays.copyOf(heap, heap.length + INCREASING_FACTOR);
			}

			heap[++index] = element;
			upHeapify(index);
		}
	}

	private void upHeapify(int position) {
		int parent = parent(position);

		if (parent >= 0 && heap[parent] != null && comparator.compare(heap[position], heap[parent]) > 0) {
			Util.swap(heap, position, parent);
			upHeapify(parent);
		}
	}

	@Override
	public T rootElement() {
		return heap[0];
	}

	@Override
	public T extractRootElement() {
		T root = rootElement();
		if (!isEmpty()) {
			Util.swap(heap, 0, index);
			heap[index--] = null;
			heapify(0);
		}
		return root;
	}

	@Override
	public void buildHeap(T[] array) {
		clear();
		for (T element : array) {
			insert(element);
		}
	}

	@Override
	public T[] heapsort(T[] array) {
		T[] rtn = (T[]) new Comparable[array.length];
		clear();
		buildHeap(array);

		int i = 0;

		if (isMaxHeap()) {
			i = size() - 1;
			while (!isEmpty()) {
				rtn[i--] = extractRootElement();
			}
		} else {
			while (!isEmpty()) {
				rtn[i++] = extractRootElement();
			}
		}

		return rtn;
	}

	@Override
	public T[] toArray() {
		ArrayList<T> resp = new ArrayList<T>();
		for (T elem : this.heap) {
			if (elem != null) {
				resp.add(elem);
			}
		}
		return (T[]) resp.toArray(new Comparable[0]);
	}

	@Override
	public int size() {
		return index + 1;
	}

	private void clear() {
		this.heap = (T[]) new Comparable[heap.length];
		index = -1;
	}

	private boolean isMaxHeap() {
		boolean isMax = true;
		int index = 0;

		while (index < size() && isMax) {
			if (heap[index].compareTo(rootElement()) > 0) {
				isMax = false;
			}
			index++;
		}
		return isMax;
	}

}
