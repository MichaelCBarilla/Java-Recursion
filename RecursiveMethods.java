
public class RecursiveMethods {

	public static void main(String[] args) {
		hanoi(4, "Source", "Auxillary", "Destination");
	}

	public static double xToN(double x, int n) {
		if (n == 0) {
			return 1;
		} else {
			double rp = xToN(x, n - 1);
			double gs = x * rp;
			return gs;
		}
	}
	
	public static long nthFib(int n) {
		if (n == 1 || n ==2) {
			return 1;
		} else {
			long rp1  = nthFib(n - 1);
			long rp2 = nthFib(n - 2);
			long gs = rp1 + rp2;
			return gs;
		}
	}
	
	public static void stringReverse(String s, int sLength) {
		if (sLength == 0) {
			return;
		} else {
			System.out.println(s.charAt(sLength - 1));
			stringReverse(s, sLength - 1);
		}
	}
	
	public static void hanoi(int n, String source, String auxillary, String destination) {
		if (n == 1) {
			System.out.println("Move 1 ring from tower " + source + " to tower " + destination);
		} else {
			hanoi(n - 1, source, destination, auxillary);
			System.out.println("Move 1 ring from tower " + source + " to tower " + destination);
			hanoi(n - 1, auxillary, source, destination);
		}
	}
}
