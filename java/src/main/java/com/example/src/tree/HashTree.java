package com.example.src.tree;
@SuppressWarnings("rawtypes")
public class HashTree<Key,Data> {
	
	private final static int[] HashNumber = {2,3,5,7,11,13,17,19,23,29,31};//��ϣ����
	private int level;//�������	
	private HashNode Root;//���ĸ��ڵ�
	
	public HashTree(){
		level = 0;
		Root = new HashNode<Integer, Integer>(level,-1,-1);		
	}
	
	
	@SuppressWarnings("hiding")
	class HashNode<Key ,Data> 
	{
		private Key m_key; //���Ĺؼ���
		private Data m_value; //�������ݶ���
		private boolean occupied; //����Ƿ�ռ�ݣ�����Ǳ�ʾ���Ĺؼ�����Ч
		private HashNode[] child; //�����ӽ������
		
		public HashNode() {}
		public HashNode(int level, Key key, Data date) {
			m_key = key; //���Ĺؼ���
			m_value = date; //�������ݶ���
			occupied = true; //����Ƿ�ռ�ݣ�����Ǳ�ʾ���Ĺؼ�����Ч
			child = new HashNode[HashNumber[level]]; //�����ӽ������
		}		
	}
	
	@SuppressWarnings("unchecked")
	boolean Insert(Key key, Data value) {		
		int index;
		HashNode[] childindex = Root.child;		
		
		for(int i=0;i<HashNumber.length; i++){
			
			index = (Integer)key % HashNumber[i];
			
			if(childindex!= null ){
				if (childindex[index] == null){
					childindex[index] = new HashNode<Key, Data>(i+1,key,value);
					if(i+1 > level){
						level = i+1;
					}
						
					return true;
				}
				else if(childindex[index].occupied == false || childindex[index].m_key == key){
					childindex[index].m_key = key; 
					childindex[index].m_value = value; 
					childindex[index].occupied = true; 
					return true;
				}
				else{					
					childindex = childindex[index].child;
					continue; 
				}
			}
			
		}
		return false;
	}  
	boolean Find(Key key, Data value) {
		int index;
		HashNode[] childindex = Root.child;		
		
		for(int i=0;i<level; i++){
			
			index = (Integer)key % HashNumber[i];
			
			if(childindex!= null ){
				if( childindex[index] == null){					
					return false;
				}
				else if(childindex[index].occupied == true &&
						childindex[index].m_key == key &&
						childindex[index].m_value == value){
					return true;					
				}
				else{					
					childindex = childindex[index].child;
					continue; 
				}
			}	
		}
		return false;
	};
	@SuppressWarnings("unchecked")
	boolean Delete(Key key) {
		int index;
		boolean result = false;
		HashNode[] childindex = Root.child;		
		
		for(int i=0;i<level; i++){
			
			index = (Integer)key % HashNumber[i];
			
			if(childindex!= null ){
				if( childindex[index] == null){					
					return result;
				}
				else if(childindex[index].occupied == true &&
						childindex[index].m_key == key ){
					childindex[index].occupied = false;
					childindex = childindex[index].child;
					result = true;
					continue;					
				}
				else{					
					childindex = childindex[index].child;
					continue; 
				}
			}	
		}
		return result;
	};
	
	 public static void main(String[] args) {	
		 HashTree<Integer,Integer> hashTree = new HashTree<Integer, Integer>();
		 hashTree.Insert(4, 3);
		 hashTree.Insert(6, 3);
		 hashTree.Insert(8, 3);
		 hashTree.Insert(12, 3);
		 System.out.println(hashTree.Find(4, 3));
		 System.out.println(hashTree.Delete(4));
		 System.out.println(hashTree.Find(4, 3));
		 System.out.println( hashTree.Insert(4, 3)); 
		 System.out.println(hashTree.Find(4, 3));
		 System.out.println(hashTree.Insert(4, 6));	
	 }
}
