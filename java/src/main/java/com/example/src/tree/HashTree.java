package com.example.src.tree;
@SuppressWarnings("rawtypes")
public class HashTree<Key,Data> {
	
	private final static int[] HashNumber = {2,3,5,7,11,13,17,19,23,29,31};//哈希除数
	private int level;//树的深度	
	private HashNode Root;//树的根节点
	
	public HashTree(){
		level = 0;
		Root = new HashNode<Integer, Integer>(level,-1,-1);		
	}
	
	
	@SuppressWarnings("hiding")
	class HashNode<Key ,Data> 
	{
		private Key m_key; //结点的关键字
		private Data m_value; //结点的数据对象
		private boolean occupied; //结点是否被占据，如果是表示结点的关键字有效
		private HashNode[] child; //结点的子结点数组
		
		public HashNode() {}
		public HashNode(int level, Key key, Data date) {
			m_key = key; //结点的关键字
			m_value = date; //结点的数据对象
			occupied = true; //结点是否被占据，如果是表示结点的关键字有效
			child = new HashNode[HashNumber[level]]; //结点的子结点数组
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
						childindex[index].m_value.equals(value)){
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
		 HashTree<Integer,test> hashTree = new HashTree<>();

		 hashTree.Insert(4, new test(3));
		 hashTree.Insert(6, new test(3));
		 hashTree.Insert(8, new test(3));
		 hashTree.Insert(12, new test(3));
		 System.out.println(hashTree.Find(4, new test(3)));
		 System.out.println(hashTree.Delete(4));
		 System.out.println(hashTree.Find(4, new test(3)));
		 System.out.println( hashTree.Insert(4, new test(3)));
		 System.out.println(hashTree.Find(4, new test(3)));
		 System.out.println(hashTree.Insert(4,new test(6)));
	 }
}
