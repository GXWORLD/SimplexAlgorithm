package SimplexAlgorithm;

public class Value_B {
	static Double[] b;
	public Value_B(Double...b) {
		this.b = b;
	}
	public static void baseChange(int i, Double n, Double[] x) {
		b[i] = b[i]*n;
		for(int i1 = 0; i1 < b.length; i1++) {
			if(i != i1)
			b[i1] = b[i1]-b[i]*x[i1];
		}
	}
}
