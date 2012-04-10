public class Fibonacci {
	public int fib(int n) {
		switch (n) {
			case 0: return 1;
			case 1: return 1;
			default: return (fib(n - 1) + fib(n - 2));
		}
	}
}
