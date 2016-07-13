package com.example.src.ForTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 利用动态规划求解最短路径问题
 * 
 * @author dell
 * 
 */

public class CalMinDistance {
	// 计算最短的距离
	public static int[] calMinDistance(int distance[][]) {
		int dist[] = new int[distance.length];
		dist[0] = 0;
		for (int i = 1; i < distance.length; i++) {
			int k = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (distance[j][i] != 0) {
					if ((dist[j] + distance[j][i]) < k) {
						k = dist[j] + distance[j][i];
					}
				}
			}
			dist[i] = k;
		}
		return dist;
	}

	// 计算路径
	public static String calTheRoute(int distance[][], int dist[]) {
		Stack<Integer> st = new Stack<Integer>();
		StringBuffer buf = new StringBuffer();
		int j = distance.length - 1;
		st.add(j);// 将尾插入
		while (j > 0) {
			// int num = 0;
			for (int i = 0; i < j; i++) {
				if (distance[i][j] != 0) {
					// num++;
					if (dist[j] - distance[i][j] == dist[i]) {
						st.add(i);
					}
				}
			}
			j = st.peek();
		}
		while (!st.empty()) {
			buf.append(st.pop()).append("-->");
		}
		return buf.toString();
	}

	// 读取文件
	@SuppressWarnings("resource")
	public static int[][] readTheFile(File f) {
		Reader input = null;
		try {
			input = new FileReader(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader buf = null;
		buf = new BufferedReader(input);
		List<String> list = new ArrayList<String>();
		try {
			String str = buf.readLine();
			while (str != null) {
				list.add(str);
				str = buf.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Iterator<String> it = list.iterator();
		int distance[][] = new int[11][11];
		while (it.hasNext()) {
			String str1[] = it.next().split(",");
			int i = Integer.parseInt(str1[0]);
			int j = Integer.parseInt(str1[1]);
			distance[i - 1][j - 1] = Integer.parseInt(str1[2]);
		}
		return distance;

	}

	public static void main(String args[]) {
		// 读文件
		File f = new File("D:" + File.separator + "distance_1.csv");
		int distance[][] = readTheFile(f);
		int dist[] = calMinDistance(distance);
		System.out.println("最短路径长度为：" + dist[distance.length - 1]);
		System.out.println("最短路径为：" + calTheRoute(distance, dist));
	}
}
