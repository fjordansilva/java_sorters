/**
 * 
 */
package es.fjordan.sorters;

/**
 * @author Fernando Jordan Silva (fjordansilva@gmail.com)
 *
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class MergeSort {
	
	public MergeSort() {
		
	}
	
	/**
	 * Inicio del algoritmo mergesort. 
	 * @param a Array de elementos comparables.
	 */	
	public void sort(Comparable[] a) {
		Comparable[] tmpArray = new Comparable[a.length];
		sort(a, tmpArray, 0, a.length-1);
	}
	
	/**
	 * Metodo interno que realiza llamadas recursivas para realizar la ordenacion.
	 * @param a Array de elementos comprables.
	 * @param tmpArray Array donde almacenar el resultado donde se ha hecho el merge
	 * @param left Indice del elemento mas a la izquierda
	 * @param right Indice del elemento mas a la derecha
	 */
	private void sort(Comparable[] a, Comparable[] tmpArray, int left, int right) {
		if (left < right) {
			System.out.println("left: " + left + "; right: " + right);
			int center = (left + right) / 2;
			// Ordenacion del lado izquierdo
			System.out.println("sort 1");
			sort(a, tmpArray, left, center);
			// Ordenacion del lado derecho
			System.out.println("Sort 2");
			sort(a, tmpArray, center + 1, right);
			// merge de ambos arrays			
			merge(a, tmpArray, left, center+1, right);
		}
	}
	
	/**
	 * Metodo interno para mezclar dos subarrays ordenados.
	 * @param a Array de elementos comparables.
	 * @param tmpArray Array donde almacenar el resultado donde se ha hecho el merge
	 * @param leftPos Indice del elemento mas a la izquierda del subarray
	 * @param rightPos Indice del inicio del segundo subarray
	 * @param rightEnd Indice del elemento mas a la derecha del subarray
	 */
	private void merge(Comparable[] a, Comparable[] tmpArray, int leftPos, int rightPos, int rightEnd) {
		System.out.println("-------------------------------------");
		System.out.println("Merge: leftPos: " + leftPos + "; rightPos: " + rightPos + "; rightEnd: " + rightEnd);
		dump(a);
		dump(tmpArray);
		System.out.println("-------------------------------------");
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numItems = rightEnd - leftPos + 1;
		
		// Loop principal
		while(leftPos <= leftEnd && rightPos <= rightEnd) {
			if (a[leftPos].compareTo(a[rightPos]) < 0) {
				tmpArray[tmpPos++] = a[leftPos++];
			} else {
				tmpArray[tmpPos++] = a[rightPos++];
			}
		}
		
		// Copia el resto del lado izquierdo
		while(leftPos <= leftEnd) {
			tmpArray[tmpPos++] = a[leftPos++];
		}
		
		// Copia el resto del lado derecho
		while(rightPos <= rightEnd) {
			tmpArray[tmpPos++] = a[rightPos++];
		}
		
		// Copiar tmpArray
		for (int i = 0; i < numItems; i++, rightEnd--) {
			a[rightEnd] = tmpArray[rightEnd];
		}
		System.out.println("-------------------------------------");
		System.out.println("MERGED");
		dump(a);
		System.out.println("-------------------------------------");
	}
	
	private void dump(Comparable[] a) {
		System.out.print("Array: {");
		for(Comparable i : a) {
			System.out.print(i + " ");
		}
		System.out.println("}");
	}
}
