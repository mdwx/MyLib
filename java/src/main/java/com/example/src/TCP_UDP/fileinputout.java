package com.example.src.TCP_UDP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Arales on 2016/7/18.
 * E_mail :  xhys01@163.com
 * Description :
 */
public class fileinputout {
    public static void main(String[] args) throws IOException {

        File inFile = new File("tcty36.rm");

        File outFile = new File("newtcty36.rm");

//最大的流为60Mb,当文件的容量大于60Mb的时候便分开流

        final int MAX_BYTE = 60000000;

        long streamTotal = 0;  //接受流的容量

        int streamNum = 0;  //流需要分开的数量

        int leave = 0;  //文件剩下的字符数

        byte[] inOutb;  //byte数组接受文件的数据

//创建流文件读入与写出类

        FileInputStream inStream = new FileInputStream(inFile);

        FileOutputStream outStream = new FileOutputStream(outFile);

//通过available方法取得流的最大字符数

        streamTotal = inStream.available();

//取得流文件需要分开的数量

        streamNum = (int)Math.floor(streamTotal/MAX_BYTE);

//分开文件之后,剩余的数量

        leave = (int)streamTotal % MAX_BYTE;

//文件的容量大于60Mb时进入循环

        if (streamNum > 0) {

            for(int i = 0; i < streamNum; ++i){

                inOutb = new byte[MAX_BYTE];

//读入流,保存在byte数组

                inStream.read(inOutb, 0, MAX_BYTE);

                outStream.write(inOutb);  //写出流

                outStream.flush();  //更新写出的结果

            }

        }

//写出剩下的流数据

        inOutb = new byte[leave];

        inStream.read(inOutb, 0, leave);

        outStream.write(inOutb);

        outStream.flush();

        inStream.close();

        outStream.close();

    }
}
