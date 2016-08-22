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
        try {
            File filename = new File(".\\output.txt");
            InputStreamReader reader = new InputStreamReader(  
                    new FileInputStream(filename));
            br = new BufferedReader(reader);
            String line = "";  
            line = br.readLine();  
            while (line != null) { 
                System.out.println(line);
                line = br.readLine();
            }  

            File writename = new File(".\\output.txt");
            writename.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
            out.write("\r\n");
            out.flush();
            out.close();
  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
} 