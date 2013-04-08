/**
 * 
 */
package es.fjordan.sorters;

/**
 * @author Fernando Jordan Silva (fjordansilva@gmail.com)
 *
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class QuickSort_v2 {

	public QuickSort_v2() {
		
	}
	
	/**
	 * Inicio del algoritmo quicksort. 
	 * @param a Array de elementos comparables.
	 */	
	public void sort(Comparable[] a) {
		sort(a, 0, a.length-1);
	}
	
	/**
	 * Algoritmo de ordenacion sobre el que se hacen las llamadas recursivas.
	 * @param a
	 * @param low
	 * @param high
	 */	
	private void sort(Comparable[]a, int low, int high) {
		int l = low, h = high;		
		if (high > low) {
			Comparable middle = a[(low+high)/2];
			while(l < h) {
				while( l < high && a[l].compareTo(middle) < 0) {
					++l;
				}
				while( h > low && a[h].compareTo(middle) > 0) {
					--h;
				}
				if (l <= h) {
					Comparable tmp = a[l];
					a[l] = a[h];
					a[h] = tmp;
					++l;
					--h;
				}
			}
			if (low < h) {
				sort(a, low, h);
			}
			if (l < high) {
				sort(a, l, high);
			}
		}
	}
}
