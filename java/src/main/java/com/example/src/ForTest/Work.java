package com.example.src.ForTest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * @author Vince  E-mail: xhys01@163.com
 * @version ����ʱ�䣺2015-6-2 ����11:41:11 
 * ��˵�� 
 */
public class Work implements Runnable {

	int i;
	public static CountDownLatch Latch = new CountDownLatch(4);
	public Work(List<MediaBase> list) {
		// TODO Auto-generated constructor stub
		i = list.size();
	}
	
	public void run() {		
		// TODO Auto-generated method stub
		while(i > 0)
		{		
			i--;	
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Latch.countDown();
		}
					
	}
	
	public MediaBase mediaBase(String title, String url)
	{
		MediaBase p = new MediaBase(title, url);
		return p;
	}
	
	
	public class MediaBase {

		private String title;
		private String url;
		
		private String Keyword;
		
	public MediaBase(String title, String url) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.url = url;
	}	
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFirstchar(){
		return Keyword;
	}

	public void setFirstchar(String Keyword) {
		this.Keyword = Keyword;
	}


	@Override
	public String toString() {
		return title;
	}

	
}

	/**
	 * @param args
	 */
	/***************************************************************************
	 * Test
	 * 
	 * @Name: Pinyin4jUtil.java
	 * @Description: TODO
	 * @author: wang_chian@foxmail.com
	 * @version: Jan 13, 2012 9:49:27 AM
	 * @param args
	 */
	public static void main(String[] args) {
		//long start =System.currentTimeMillis();
		long start =System.nanoTime();
		List<MediaBase> SetlectList = new ArrayList<MediaBase>();
		Work w = new Work(SetlectList);
		
		MediaBase arg0 = w.mediaBase("ttet1","werwer");
		MediaBase arg2 = w.mediaBase("ttet2","werwer");
		MediaBase arg3 = w.mediaBase("ttet3","werwer");
		MediaBase arg4 = w.mediaBase("ttet4","werwer");
		SetlectList.add(arg0);
		SetlectList.add(arg2);
		SetlectList.add(arg3);
		SetlectList.add(arg4);
		SetlectList.add(arg0);
		SetlectList.add(arg2);
		SetlectList.add(arg3);
		SetlectList.add(arg4);
		SetlectList.add(arg0);
		SetlectList.add(arg2);
		SetlectList.add(arg3);
		SetlectList.add(arg4);
		SetlectList.add(arg0);
		SetlectList.add(arg2);
		SetlectList.add(arg3);
		SetlectList.add(arg4);
		SetlectList.add(arg0);
		SetlectList.add(arg2);
		SetlectList.add(arg3);
		SetlectList.add(arg4);
		SetlectList.add(arg0);
		SetlectList.add(arg2);
		SetlectList.add(arg3);
		SetlectList.add(arg4);
		SetlectList.add(arg0);
		SetlectList.add(arg2);
		SetlectList.add(arg3);
		SetlectList.add(arg4);
		SetlectList.add(arg0);
		SetlectList.add(arg2);
		SetlectList.add(arg3);
		SetlectList.add(arg4);
	//	Work work = new Work(SetlectList);
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();				
		cachedThreadPool.execute(new Work(SetlectList));
		cachedThreadPool.execute(new Work(SetlectList));
		cachedThreadPool.execute(new Work(SetlectList));
		cachedThreadPool.execute(new Work(SetlectList));
		
		//long end =System.currentTimeMillis();

		try {
			Work.Latch.await();
			long end =System.nanoTime();
			System.out.println(end - start);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
	}

}
