package com.example.src.fonsview;

import java.util.Observable;

public class RingBuffer extends Observable{

	private int RingBuffer_SIZE = 4*1014*1024;
	private byte[] m_buf;
	private int m_read, m_write;  ///< The indices of the next read/write operations. read == write implies that buffer is empty.

	public RingBuffer(){
		RingBufferInit();
	}
	public RingBuffer(int size){
		RingBuffer_SIZE = size;
		RingBufferInit();
	}
	private void RingBufferInit(){
		m_buf = new byte[RingBuffer_SIZE];
		m_read = m_write = 0;
	}
	public void insert(byte[] begin) {
		insert(begin, begin.length);
	}
	public void insert(byte[] begin, int length) {
		int r = m_read;  // The read position
		int w = m_write;  // The write position
		
		boolean overflow = false;
		
		if(length > RingBuffer_SIZE || length > begin.length){
			length = RingBuffer_SIZE < begin.length ? RingBuffer_SIZE:begin.length;
		}		
		
		if (modulo(w+length) == w+length){//loop enough data . don't modulo
			System.arraycopy(begin, 0, m_buf, w, length);	// Copy sample		
			if(r > w && r < w + length)overflow = true; 
			w += length;			// Update cursor
		}
		else
		{
			System.arraycopy(begin, 0, m_buf, w, modulo(-w)); 				  	
			System.arraycopy(begin, modulo(-w), m_buf, 0, modulo(length + w));	
			
			if(r > w || r < modulo(w + length))overflow = true;
			w = modulo(w + length); 
		}
		
		m_write = w;
		if (overflow){
			m_read = modulo(w + 1);  // Reset read pointer on overflow
			measurementsChanged();// for After calling
		}
	}
	
	/// Read data from current position if there is enough data to fill the range (otherwise return -1). Does not move read pointer.
	public int read(byte[] begin) {
		return read(begin, 0,begin.length);
	}
	public int read(byte[] begin,int offsite, int length) {
		
		if (modulo(m_write - m_read) < length) return -1;  // Not enough Data available
		
		int r = m_read;
		
		
		if(length > begin.length)length = begin.length;

		if(length <= modulo(-r)){	//loop enough data 	do not modulo
			System.arraycopy(m_buf, r, begin, offsite, length);			 // Copy Data to output iterator
		}
		else{		//need modulo
			System.arraycopy(m_buf, r, begin, offsite, modulo(-r));		 // Copy Data to output iterator
			System.arraycopy(m_buf, offsite, begin, modulo(-r), length - modulo(-r)); // Copy Data to output iterator
		}
		return length;
	}
	public void pop(int  n) { m_read = modulo(m_read + n); } ///< Move reading pointer forward.
	public int  size()  { return modulo(m_write - m_read); }
	
	private  int  modulo(int  idx) { return (RingBuffer_SIZE + idx) % RingBuffer_SIZE; }  ///< Modulo operation with proper rounding (handles slightly "negative" idx as well)
	
	public void setRingBufferSize(int size){
		
		if(size <= 0){ return; }
		this.RingBuffer_SIZE = size;
		m_buf = new byte[RingBuffer_SIZE];
	}
	public void measurementsChanged() {
		setChanged();
		notifyObservers();
	}
};

