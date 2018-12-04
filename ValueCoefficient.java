package SimplexAlgorithm;

public class ValueCoefficient {//价值系数
	static Double[] c;
	public ValueCoefficient(Double...c) {
		this.c = c;
		}
	
	public static void exChange(int i, int j) {
		// TODO Auto-generated method stub
	
		Double t = c[i];
		c[i] = c[j];
		c[j] = t;
		
	}
}
