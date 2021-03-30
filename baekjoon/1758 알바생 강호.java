import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer[] tip = new Integer[n];
		for (int i = 0; i < n; i++) {
			tip[i] = sc.nextInt();
		}
		Arrays.sort(tip, Comparator.reverseOrder());

		long sum = 0;
		for (int i = 0; i < n; i++) {
			int tmp = tip[i] - i;
			if (tmp <= 0)
				break;
			else
				sum += tmp;
		}
		System.out.println(sum);
	}
}
