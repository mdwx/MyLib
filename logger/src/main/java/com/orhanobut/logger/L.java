package com.orhanobut.logger;

import android.util.Log;

/** 
 * @author Vince  E-mail: xhys01@163.com
 * @version 创建时间：2015-6-11 上午9:33:30 
 * 类说明 
 */
public class L  
{ 
    private L()  
    {  
        /* cannot be instantiated */  
        throw new UnsupportedOperationException("cannot be instantiated");  
    }  
  
    public static boolean isDebug = true;// TURE is will be print
    private static final String TAG = "Vince_Log";
    private  static StringBuilder  strBuffer;

    public static void i(String msg)  {
        if (isDebug) Log.i(TAG, msg);
    }  
  
    public static void d(String msg){
        if (isDebug) Log.d(TAG, msg);
    }  
  
    public static void e(String msg){
        if (isDebug) Log.e(TAG, msg);
    }  
  
    public static void v(String msg){
        if (isDebug) Log.v(TAG, msg);
    }  

    public static void i(String tag, String msg){
        if (isDebug) Log.i(tag, msg);
    }  
  
    public static void d(String tag, String msg){
        if (isDebug) Log.d(tag, msg);
    }  
  
    public static void e(String tag, String msg){
        if (isDebug) Log.e(tag, msg);
    }  
  
    public static void v(String tag, String msg){
        if (isDebug) Log.v(tag, msg);
    }

    public synchronized  static String FL()   //File+line
	 {     
		  StackTraceElement stackTraces[] = (new Throwable()).getStackTrace();     
          strBuffer = new StringBuilder("[");
		  strBuffer.append(stackTraces[1].getFileName()).append(":");
		  strBuffer.append(stackTraces[1].getLineNumber()).append("]");  
		  return strBuffer.toString();     
	 }

    public synchronized  static String FLF()   //File + lien + function
	 {     
		  StackTraceElement stackTraces[] = (new Throwable()).getStackTrace();
          strBuffer = new StringBuilder("[");
         strBuffer.append(stackTraces[1].getFileName()).append(".");
		  strBuffer.append(stackTraces[1].getMethodName()).append("()|");
         strBuffer.append(stackTraces[1].getLineNumber()).append("]");
         return strBuffer.toString();
	 }

    public synchronized  static String All()   //File + line + function + packetName
	 {     
		  StackTraceElement stackTraces[] = (new Throwable()).getStackTrace();
          strBuffer = new StringBuilder("[");
         strBuffer.append(stackTraces[1].getClassName()).append(".");
         strBuffer.append(stackTraces[1].getMethodName()).append("()]|[");
         strBuffer.append(stackTraces[1].getLineNumber()).append("]");
		  return strBuffer.toString();
	 }
}