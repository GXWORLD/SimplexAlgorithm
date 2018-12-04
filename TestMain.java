package SimplexAlgorithm;

import java.util.Collections;
/*5XaA+6XbA+12XaB+10XbB+14XaC+15XbC+X1=3000
y1+y3+y4 -XaA-XbA+X2=0
y1+y2+y4 -XaB-XbB +X3=0
y1+y2+y3 -XaC-XbC+X4=0*/
public class TestMain {
	public static void main(String[] args) {
		
		Vector_P p1 = new Vector_P(0.0, 1.0,1.0,1.0);
		Vector_P p2 = new Vector_P(0.0, 0.0,1.0,1.0);
		Vector_P p3 = new Vector_P(0.0, 1.0,0.0,1.0);
		Vector_P p4 = new Vector_P(0.0, 1.0,1.0,0.0);
		Vector_P p5 = new Vector_P(5.0, -1.0, 0.0,0.0);
		Vector_P p6 = new Vector_P(6.0, -1.0, 0.0,0.0);
		Vector_P p7 = new Vector_P(12.0, 0.0,-1.0,0.0);
		Vector_P p8 = new Vector_P(10.0, 0.0,-1.0,0.0);
		Vector_P p9 = new Vector_P(14.0, 0.0,0.0,-1.0);
		Vector_P p10 = new Vector_P(15.0, 0.0, 0.0,-1.0);
		Vector_P p11= new Vector_P(1.0, 0.0, 0.0,0.0);
		Vector_P p12= new Vector_P(0.0, 1.0, 0.0,0.0);
		Vector_P p13= new Vector_P(0.0, 0.0, 1.0,0.0);
		Vector_P p14= new Vector_P(0.0, 0.0, 0.0,1.0);
		Value_B b = new Value_B(3000.0,0.0,0.0,0.0);
		ValueCoefficient c = new ValueCoefficient(40.0, 35.0, 12.0, 10.0,-5.0,-6.0,-12.0,-10.0,-14.0,-15.0,0.0,0.0,0.0,0.0);
		Tool.print();
		while (Collections.max(Tool.get§Ò()) > 0) {
			
			Tool.exChange();
			Tool.print();
		}
		Tool.result();
		//System.out.println(Tool.getX());
	}
}


