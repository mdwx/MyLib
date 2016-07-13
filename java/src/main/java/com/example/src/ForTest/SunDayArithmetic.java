package com.example.src.ForTest;

/**
 * Created by Arales on 2016/5/27.
 */
public class SunDayArithmetic {

    static int SundaySearch(String Des, String Pattern)
    {
       if(Des == null || Pattern == null){
           return -1;
       }
        int pArray[] = new int[26];

        for(int i=0; i<Pattern.length(); i++){
            int c = Pattern.charAt(i)-97;
            if(pArray[c] == 0){
                pArray[c] = i;
            }
        }

        for (int nBegin = 0; nBegin <= Des.length() - Pattern.length();){
            int i = nBegin, j = 0;
            for ( ;j < Pattern.length() && i < Des.length() && Des.charAt(i) == Pattern.charAt(j);i++, j++);
            if (j == Pattern.length()){
                return nBegin;
            }
            if (nBegin + Pattern.length() > Des.length()){
                return -1;
            }
            else{
                nBegin += Pattern.length() - pArray[Des.charAt(nBegin+Pattern.length())-97];
            }
        }
        return -1;
    }


   public static void main(String args[])
    {
        String  dest      =   "abcxxxbaaaabaaaxbbaaabcdamno";
        String[] pattern = {
                "a",
                "ab",
                "abc",
                "abcd",
                "x",
                "xx",
                "xxx",
                "ax",
                "axb",
                "xb",
                "b",
                "m",
                "mn",
                "mno",
                "no",
                "o",
                "",
                "aaabaaaab",
                "baaaabaaa",
                "aabaaaxbbaaabcd",
                "abcxxxbaaaabaaaxbbaaabcdamno",
        };
        System.out.println("position" + SundaySearch(dest,pattern[3] ));
    }


}
