package SimplexAlgorithm;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Tool {
	static int M = Vector_P.p.length;
	static int N = Matrix_A.num;
	static Double[][] base = new Double[M][M];
	public Tool() {
	}

	public static void print() {
		/*
		 * for(ArrayList<Double> i:a) System.out.println(i);
		 */
		/*System.out.print("  C ");
		for(Double i:ValueCoefficient.c)
				System.out.print("   "+i);
		System.out.println();
		System.out.print("  b ");
		for (int i = 1; i <= N; i++)
			System.out.print("    P" + i + "");
		    System.out.print("    θ");
			System.out.println();
		for (int j = 0; j < M; j++) {
			System.out.print(" "+Value_B.b[j]+" ");
			for (int i = 0; i < N; i++) {
				if (Matrix_A.a.get(i)[j] >= 0 && Matrix_A.a.get(i)[j] <= 10)
					System.out.print("   " + Matrix_A.a.get(i)[j]);
				else
					System.out.print("  " + Matrix_A.a.get(i)[j]);
			}
			if(getθ().get(j) == 99999.99)
				System.out.print("   null");
				else
					System.out.print("   "+getθ().get(j));
			System.out.println();
		}
		System.out.print("  б ");
		for(Double i:getб())
				System.out.print("   "+i);
		System.out.println();
		System.out.println("----------------------------------------------------------------");*/
		System.out.print("C" +" = [ ");
		for(Double i:ValueCoefficient.c)
			System.out.print(i+", ");
		System.out.println("]");
		
		/*System.out.print("X" +" = [ ");
		for(int i:Matrix_A.x)
			System.out.print("x"+i+", ");
		System.out.println("]");*/
		
		for (int i = 0; i < N; i++) {
			System.out.print("P" + Matrix_A.x.get(i)+" = [ " );
			for(int j = 0; j < M; j++)
				System.out.print(new DecimalFormat("#0.00").format(Matrix_A.a.get(i)[j])+", ");
			System.out.println("]");
		}
		
		
		System.out.print("b" +" = [ ");
		for(Double i:Value_B.b)
			System.out.print(new DecimalFormat("#0.00").format(i)+", ");
		System.out.println("]");
		
		System.out.print("θ" +" = [ ");
		for(Double i:getθ())
			if(i != null)
			System.out.print(new DecimalFormat("#0.00").format(i)+", ");
			else System.out.print("--, ");
		System.out.println("]");
		
		System.out.print("б" +" = [ ");
		for(Double i:getб())
			System.out.print(new DecimalFormat("#0.00").format(i)+", ");
		System.out.println("]");
		System.out.println("----------------------------------------------------------------");
		
			
	}

	public static ArrayList<Double> getX() { // 计算初始基可行解
		ArrayList<Double> result = new ArrayList<>();
		// System.out.println(M + "," + N);
		for (int i = 0; i < M; i++)
			for (int j = 0; j < M; j++)
				if (i == j)
					base[i][j] = 1.0;
				else
					base[i][j] = 0.0;

		for (int i = 0; i < N - M; i++)
			result.add(0.0);
		for (int i = 0; i < M; i++) {
			Double e = 0.0;
			for (int j = 0; j < M; j++) {
				e += base[i][j] * Value_B.b[j];
			}
			result.add(e);
		}
		return result;
	}

	public static ArrayList<Double> getб() {
		ArrayList<Double> result = new ArrayList<>();
		for (int j = 0; j < N; j++) {
			Double z = 0.0;
			for (int i = 0; i < M; i++) {
				z += ValueCoefficient.c[N - M + i ] * Matrix_A.a.get(j)[i];
			}
			result.add(ValueCoefficient.c[j]-z);
		}
		return result;
	}

	public static ArrayList<Double> getθ() {
         int index = getб().indexOf(Collections.max(getб()));
		ArrayList<Double> result = new ArrayList<>();
		for (int i = 0; i < M; i++) {
		 if(Matrix_A.a.get(index)[i] > 0)
			result.add(Value_B.b[i] / Matrix_A.a.get(index)[i]);
		 else
			result.add(null);
		}
		return result;

	}
	public static void result() {
		System.out.println(result_X());
		System.out.println(result_Z());
		
	}
	public static String result_X() {
		ArrayList<String> result1 = new ArrayList<>();
		ArrayList<String> result2 = new ArrayList<>();
		for(Double b:getX())
		result1.add(new DecimalFormat("#0.00").format(b));
		for(Integer b:Matrix_A.x)
		result2.add("x"+b);
		return result2+" = "+result1;

	}
	public static String result_Z() {
		Double result = 0.0;
		ArrayList<Double> x = getX();
		for (int i = 0; i < N; i++) {
			result += ValueCoefficient.c[i] * x.get(i);
		}
		return "z = "+new DecimalFormat("#0.00").format(result);

	}

	public static void exChange() {
		// TODO Auto-generated method stub
		int i = getб().indexOf(Collections.max(getб()));
		//int j = getθ().indexOf(Collections.min(getθ()));//有空值，会产生错误
		//去空值
		ArrayList<Double> a =  new ArrayList<>();
		for(Double b:getθ()) {
			if(b!=null)
			a.add(b);
		}
		int j = getθ().indexOf(Collections.min(a));
		Matrix_A.exChange(i ,N-M+j);
		ValueCoefficient.exChange(i ,N-M+j);
		baseChange(j);
	}
	public static void baseChange(int i) {
		Matrix_A.baseChange(N-M+i,i);
		
	}

}
