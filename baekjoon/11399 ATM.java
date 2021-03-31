import java.io.*;
import java.util.*;

public class Main {
	public static int n, l, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int[] p = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(p);
		int tmp = 0;
		int result = 0;
		for (int i = 0; i < n; i++) {
			tmp += p[i];
			result += tmp;
		}
		System.out.println(result);
	}
}
