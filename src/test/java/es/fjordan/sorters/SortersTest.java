/**
 * 
 */
package es.fjordan.sorters;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.base.Stopwatch;

/**
 * @author Fernando Jordan Silva (fjordansilva@gmail.com)
 *
 */
public class SortersTest {

	private DecimalFormat format = new DecimalFormat("#.##");
	private Integer[] s1, s2, s3;
	
	public SortersTest() {
		Random generator = new Random(System.currentTimeMillis());
		List<Integer> lista = new ArrayList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			lista.add(generator.nextInt());
		}	
		
		s1 = lista.toArray(new Integer[0]);
		s2 = lista.toArray(new Integer[0]);
		s3 = lista.toArray(new Integer[0]);
		
		dump(s2);
	}
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	@Ignore
	public void testQuickSort_1() {
		QuickSort_v1 q = new QuickSort_v1();
				
		Stopwatch stopwatch = new Stopwatch().start();
		
		q.sort(s1);
		
		stopwatch.stop();
		long millis = stopwatch.elapsed(TimeUnit.MILLISECONDS);
		
		System.out.println("QuickSort v1 (50000 items): " + format.format(millis) + " milliseconds");		
//		dump(s1);
	}
	
	@Test
	public void testMergeSort_1() {
		MergeSort q = new MergeSort();
				
		Stopwatch stopwatch = new Stopwatch().start();
		
		q.sort(s2);
		
		stopwatch.stop();
		long millis = stopwatch.elapsed(TimeUnit.MILLISECONDS);
		
		System.out.println("MergeSort v1 (50000 items): " + format.format(millis) + " milliseconds");		
	}
	
	@Test
	@Ignore
	public void testJavaSort_1() {		
		Stopwatch stopwatch = new Stopwatch().start();
		
		Arrays.sort(s3);
				
		stopwatch.stop();
		long millis = stopwatch.elapsed(TimeUnit.MILLISECONDS);
		
		System.out.println("JavaSort v1 (50000 items): " + format.format(millis) + " milliseconds");		
	}
	
	private void dump(Comparable[] a) {
		System.out.print("Array: {");
		for(Comparable i : a) {
			System.out.print(i + " ");
		}
		System.out.println("}");
	}
}
