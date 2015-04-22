
/**
	 * Heap implementation of Priority Queue
     * using an Array.
	 * 
	 * Abstraction function is
	 * AF(r)= ([heap=[0, Max, 5, 6, 5, -1,...], size])
	 * 
	 * List of operations: peek(), insert(int Key), remove(), 
	 *                     
	 * 
	 *  
	 */
package heap;

import java.lang.reflect.Method;
import java.util.Arrays;

import sorting.Utils;

/**
 * @author Thierry Edson Noumessi
 *
 * @date Apr 3, 2015
 * @6:33:43 PM
 * @maxheap.java
 */
public class PriorityQueue {

private	int [] heap;
private	int size;
	
	
	public PriorityQueue() {
		super();
		this.heap = new int [20] ;
		this.size = 0;
	}
	
	public PriorityQueue(int size) {
		super();
		this.heap = new int [size] ;
		this.size = 0;
	}
	/**
	 * Ensure Order property of Heap.
	 * @param a
	 * @param i
	 */
	private void reheapup(int[] a,int i){
		
		int parentIndex=i/2;
		if(parentIndex!=0){
			if(a[i]>a[parentIndex]){
				Utils.swap(a, i, parentIndex);
				reheapup(a, parentIndex);
			}
		}
		
	}
	/**
	 * Returns the max element in the Heap
	 * @return
	 */
	public int peek(){
		int max=heap[1];
		return max;
	}
	/**
	 * Remove the Max and reestablish the heap properties
	 * (Shape(by default) and Order) 
	 */
	public void remove(){
		
		if(getSize()<1){}
		else{
			heap[1]=heap[getSize()];
			heap[getSize()]=0;
			size--;
			reheapdown(heap,1);			
		    }
		
	}
	
	/**
	 * Ensure Order property of Heap.
	 * @param heap
	 * @param indexparent
	 */
	private void reheapdown(int[] heap,int indexparent){
		if(getSize()<1){}
		else{
			if(2*indexparent+1>getSize()){
				
				if(indexparent==getSize()/2){
					if(heap[indexparent]<heap[2*indexparent]){
						System.out.println("swapping"+heap[indexparent]+" : "+heap[2*indexparent]);
						Utils.swap(heap, indexparent, 2*indexparent);
					}
				}
				
			}else{
				if(heap[2*indexparent]>heap[2*indexparent+1]){
					System.out.println("swapping"+heap[indexparent]+" : "+heap[2*indexparent]);
					Utils.swap(heap, indexparent, 2*indexparent);
					reheapdown(heap, 2*indexparent);
				}
				else{
					/*
					 *(heap[2*indexparent]<=heap[2*indexparent+1]) 
					 */
					System.out.println("swapping"+heap[indexparent]+" : "+heap[2*indexparent+1]);
					Utils.swap(heap, indexparent, 2*indexparent+1);
					reheapdown(heap, 2*indexparent+1);
				}
			}
		}
		
	}
	/**
	 * Add a new element in the Heap
	 * @param val
	 */
	public void Insert(int val){
		System.out.println(getHeap().length);
		System.out.println(size);
		if(getHeap().length-1==getSize()){
			System.out.println("Heap full");
		}else{
			
			this.size++;
			heap[size]=val;
			reheapup(heap, size);
		}
		
	}
	
	
	



	/**
	 * @return the heap
	 */
	public int[] getHeap() {
		return heap;
	}

	/**
	 * @param heap the heap to set
	 */
	public void setHeap(int[] heap) {
		this.heap = heap;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PriorityQueue [heap=" + Arrays.toString(heap) + ", size="
				+ size + "]";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	PriorityQueue p=new PriorityQueue();
	p.Insert(4);
	p.Insert(-12);
	p.Insert(5);
	p.Insert(12);
	p.Insert(5);
	p.Insert(16);
	p.Insert(6);
	
	p.Insert(10);
	p.Insert(20);
	//p.Insert(12);
	
	System.out.println(p.peek());
	p.remove();
	System.out.println(p);
	p.remove();
	System.out.println(p);
	p.remove();
	System.out.println(p);
	p.remove();p.remove();
	p.Insert(20);
	
	System.out.println(p);
	System.out.println(p.getClass().getMethods()[0]);
	
	}
	
}
