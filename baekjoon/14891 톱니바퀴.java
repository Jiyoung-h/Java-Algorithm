import java.io.*;
import java.util.*;

public class Main {

	public static String[] gear = new String[4];
	public static boolean[] check = new boolean[4];

	public static void rotation(int g, int d) {
		char left = gear[g].charAt(6);
		char right = gear[g].charAt(2);
		check[g] = true;
		if (d == 1) { // 시계 방향
			gear[g] = gear[g].charAt(gear[g].length() - 1) + gear[g].substring(0, gear[g].length() - 1);
		} else { // 반시계 방향
			gear[g] = gear[g].substring(1) + gear[g].charAt(0);
		}
		if (g - 1 >= 0 && check[g - 1] == false) {
			if (gear[g - 1].charAt(2) != left) {
				rotation(g - 1, -d);
			}
		}
		if (g + 1 <= 3 && check[g + 1] == false) {
			if (gear[g + 1].charAt(6) != right) {
				rotation(g + 1, -d);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			gear[i] = br.readLine();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n, d;
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			Arrays.fill(check, false);
			rotation(n - 1, d);
		}
		int answer = 0;
		if (gear[0].charAt(0) == '1')
			answer += 1;
		if (gear[1].charAt(0) == '1')
			answer += 2;
		if (gear[2].charAt(0) == '1')
			answer += 4;
		if (gear[3].charAt(0) == '1')
			answer += 8;
		System.out.println(answer);
	}
}
