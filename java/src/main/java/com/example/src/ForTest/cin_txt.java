package com.example.src.ForTest;

import java.io.File;  
import java.io.InputStreamReader;  
import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.FileInputStream;  
import java.io.FileWriter;  
  
public class cin_txt {  
	private static BufferedReader br;

	public static void main(String args[]) {
        try { // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw  
  
            /* ����TXT�ļ� */  
            //String pathname = "D:\\twitter\\input.txt"; // ����·�������·�������ԣ������Ǿ���·����д���ļ�ʱ��ʾ���·��  
            File filename = new File(".\\output.txt"); // Ҫ��ȡ����·����input��txt�ļ�  
            InputStreamReader reader = new InputStreamReader(  
                    new FileInputStream(filename)); // ����һ������������reader  
            br = new BufferedReader(reader);
            String line = "";  
            line = br.readLine();  
            while (line != null) { 
                System.out.println(line);
                line = br.readLine(); // һ�ζ���һ������  
            }  
  
            /* д��Txt�ļ� */  
            File writename = new File(".\\output.txt"); // ���·�������û����Ҫ����һ���µ�output��txt�ļ�  
            writename.createNewFile(); // �������ļ�  
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
            out.write("�һ�д���ļ���\r\n"); // \r\n��Ϊ����  
            out.flush(); // �ѻ���������ѹ���ļ�  
            out.close(); // ���ǵùر��ļ�  
  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
} 