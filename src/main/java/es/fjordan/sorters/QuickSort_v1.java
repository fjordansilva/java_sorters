/**
 * 
 */
package es.fjordan.sorters;

/**
 * Implementacion del metodo de ordenacion QuickSort.
 * 
 * @author Fernando Jordan Silva (fjordansilva@gmail.com)
 * 
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class QuickSort_v1 {

	private static final int CUTOFF = 2;
	
	public QuickSort_v1() {
		
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
	 * Se utiliza un corte de 10 (tamaño minimo del array sobre el que aplicar el pivotaje) y un 
	 * particionado en tres partes utilizando la mediana
	 * @param a
	 * @param low
	 * @param high
	 */	
	private void sort(Comparable[]a, int low, int high) {
		dump(a);
		if (low + CUTOFF > high) {
			insertionSort(a, low, high);
		
		} else {
			// Obtencion de la posicion del pivote
			int middle = (low + high) / 2;
			// Ordenar los valores de las posiciones: low, middle y high
			// el pivote será el valor intermedio
			if(a[middle].compareTo(a[low]) < 0) {
				swapReferences(a, low, middle);
			}
			if(a[high].compareTo(a[low]) < 0) {
				swapReferences(a, low, high);
			}
			if(a[high].compareTo(a[middle]) < 0) {
				swapReferences(a, middle, high);
			}
			// Se coloca el pivote en la posicion high-1
			swapReferences(a, middle, high-1);
			Comparable pivot = a[high-1];
			// Se hace el particionado
			int i, j;
			for( i = low, j = high - 1; ;) {
				while(a[i].compareTo(pivot) < 0) {					
					i++;
				}
				while(pivot.compareTo(a[j]) < 0) {
					j--;
				}
				if (i >= j) {
					break;
				}
				swapReferences(a, i, j);
			}
			// Se restaura el pivote
			swapReferences(a, i, high-1);
			
			// Se ordenan los elementos inferiores
			sort(a, low, i-1);
			// Se ordenan los elementos superiores
			sort(a, i+1, high);
		}
	}
	
	/**
	 * Metodo para intercambiar elementos en un array
	 * @param a Array de objetos
	 * @param index1 Indice del primer elemento
	 * @param index2 Indice del segundo elemento
	 */
	private void swapReferences(Object[] a, int index1, int index2) {
		Object tmp = a[index1];
		a[index1] = a[index2];
		a[index2] = tmp;
	}
	
	/**
	 * Rutina interna para la insercion de subarrays.
	 * @param a Array de elementos Comparable
	 * @param low Indice del elemento mas a la izquierda del array.
	 * @param high Indice del elemento mas a la derecha del array.
	 */
	private void insertionSort(Comparable[] a, int low, int high) {
		for( int p = low + 1; p <= high; p++) {
			Comparable tmp = a[p];
			int j;
			for (j = p; j > low && tmp.compareTo(a[j-1]) < 0; j--) {
				a[j] = a[j-1];				
			}
			a[j] = tmp;
		}
	}
	

	private void dump(Comparable[] a) {
		System.out.print("Array: {");
		for(Comparable i : a) {
			System.out.print(i + " ");
		}
		System.out.println("}");
	}
}
