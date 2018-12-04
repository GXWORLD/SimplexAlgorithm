package SimplexAlgorithm;

import java.util.*;


public class Matrix_A{
	static int num = 0;
	static LinkedList<Double[]> a = new LinkedList<>();
	static LinkedList<Integer> x = new LinkedList<>();
	public Matrix_A () {}
	public static void add(Double[] p) {
		// TODO Auto-generated method stub
		a.add(p);
		num++;
		x.add(num);
	}


	public static void clear() {
		a.clear();
		x.clear();
		num = 0;
	}
	public static void exChange(int i, int j) {
		// TODO Auto-generated method stub
		Double [] t = a.get(i);
		Double [] t1 = a.get(j);
		a.remove(i);
		a.add(i, t1);
		a.remove(j);
		a.add(j, t);
		Integer t2 = x.get(i);
		Integer t3 = x.get(j);
		x.remove(i);
		x.add(i, t3);
		x.remove(j);
		x.add(j, t2);
	}
	public static void baseChange(int i, int j) {
		// TODO Auto-generated method stub
		Double t = a.get(i)[j];
		Double n = 1.0/t;
		for(Double [] i1:a)
			i1[j] = i1[j]*n;
		
		Double [] x = new  Double[Tool.M];
		for(int i1 = 0; i1 < x.length;i1++) {
			if(i1 == j) x[i1] = 0.0;
			x[i1] = a.get(i)[i1]/1.0;
		}
		for(int i1 = 0; i1 < x.length; i1++) {
			for(Double [] i2:a) {
				if(i1 != j) 
				i2[i1] -= x[i1]*i2[j];
			}
		}
		Value_B.baseChange(j,n,x);
	} 
}