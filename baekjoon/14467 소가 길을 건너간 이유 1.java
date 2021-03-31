import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int answer = 0;
		int[] cow = new int[11];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(cow[a] == 0) cow[a]=b+1;
			else {
	            if (cow[a] != b + 1) {
	                answer++;
	                cow[a] = b + 1;
	            }
	        }
		}
		System.out.println(answer);
	}
}
