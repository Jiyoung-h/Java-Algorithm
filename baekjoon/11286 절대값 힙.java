import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> {
			int aa = Math.abs(a);
			int ab = Math.abs(b);
			if (aa == ab)
				return a - b;
			return aa - ab;
		});
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a == 0) {
				if (q.isEmpty())
					System.out.println("0");
				else
					System.out.println(q.poll());
			} else {
				q.add(a);
			}
		}
	}
}
