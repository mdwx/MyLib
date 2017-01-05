package com.example.src.tree;

public class SBTTree<T extends Comparable<T>> extends BinaryTree<T> {

	private SBTNode Root;
	
	public SBTTree(){ Root = null;}
	public SBTTree(T Data) {
		Root = new SBTNode(Data);
	}
	
	@Override
	public boolean Insert(T Data) {
		// TODO Auto-generated method stub
		
		if(this.Root == null)
		{
			this.Root = new SBTNode(Data);
			return (this.Root != null);
		}
		else
		{
			int Toal = this.Root.size;
			
			this.Root.SBTinsert(Data);
			this.Root = this.Root.Maintain();
			
			return (Toal != this.Root.size);
		}
	}

	@Override
	public boolean Delete(T key) {
		// TODO Auto-generated method stub
		if(this.Root != null)
		{
			int Toal = this.Root.size;
			
			this.Root = this.Root.SBTDelete(key);			
			
			return (this.Root == null || Toal != this.Root.size);
			
		}	
		return false;
	}
	
	@Override
	public void PreorderTraversal() {
		// TODO Auto-generated method stub
		if(this.Root != null)
		{
			Root.PreorderTraversal();
		}
		else
		{
			System.out.println("Tree is NULL!!!");
		}
		
	}

	@Override
	public void InorderTraversal() {
		// TODO Auto-generated method stub
		if(this.Root != null)
		{
			Root.InorderTraversal();
		}
		else
		{
			System.out.println("Tree is NULL!!!");
		}
	}

	@Override
	public void PostorderTraversal() {
		// TODO Auto-generated method stub
		if(this.Root != null)
		{
			Root.PostorderTraversal();
		}
		else
		{
			System.out.println("Tree is NULL!!!");
		}
	}
	
	public SBTTree<T> SBTSearch(T Data){
		if(this.Root != null)
		{
			SBTTree<T> tree = new SBTTree<T>();
			tree.Root = this.Root.SBTSearch(Data);
			return tree;
		}
		return null;
	}
		 
	public int getsize() {
		return Root== null?-1:Root.size;
	}
	public T getRootData() {
		return Root== null?null:Root.Data;
	}
	
	public class SBTNode{
		
		  private T  Data;	  
		  private int size;	  
		  private SBTNode Right;
		  private SBTNode Left;	  
		  private SBTNode parent;		  
		  	    
		 public SBTNode(){}
		 public SBTNode(T Data)
		 {
			 this.Data = Data;
			 this.Left = null;
			 this.Right = null;
			 this.parent = this;
			 this.size = 1;
		 }
		
		
		private  SBTNode RightRotate()
		{
			int size_t = 0;		
			SBTNode child = this.Left;	
			
			this.Left = child.Right;		 
			child.Right = this;		 		
			child.size = this.size;

			
			if(this.parent == this)
			{
				child.parent = child;
			}
			else
			{
				child.parent = this.parent;		
			}
			
			this.parent = child;
			
			if(this.Left != null)
				size_t += this.Left.size;
			if(this.Right != null)
				size_t += this.Right.size;		
			this.size = size_t+1;
			
			return  child;
		}

	   private SBTNode LeftRotate()
		{
			int size_t = 0;
			SBTNode child = this.Right;
			
			this.Right = child.Left;
			child.Left = this;
			child.size = this.size;

			if(this.parent == this)
			{
				child.parent = child;
			}
			else
			{
				child.parent = this.parent;			
			}
			
			this.parent = child;
			
			if(this.Left != null)
				size_t += this.Left.size;
			if(this.Right != null)
				size_t += this.Right.size;
			this.size = size_t+1;
			
			return child;

		}

	   SBTNode Maintain()
		{
		    if(this == null || this.size <= 2)
		    {
		    	 return this;
		    }	      
		   
				if(this.Left!=null && this.Left.Left!=null && ( this.Right == null || this.Left.Left.size > this.Right.size))
				{
					return this.RightRotate();
				}				
				else if(this.Left!=null && this.Left.Right!=null && ( this.Right == null || this.Left.Right.size > this.Right.size))
				{
					this.Left = this.Left.LeftRotate();
					return this.RightRotate();
				}			
			 
	   
				if(this.Right!=null && this.Right.Right!=null && ( this.Left == null || this.Right.Right.size > this.Left.size))
				{
					return this.LeftRotate();
				}	
				else if(this.Right!=null && this.Right.Left!=null && (this.Left == null || this.Right.Left.size > this.Left.size))
				{
					this.Right = this.Right.RightRotate();
					return this.LeftRotate();
				}
				
				return this;	
		}
	   
	   SBTNode Count()
	   {
		   int _size = 0;
		   
		   if( this.Left != null)
				_size += this.Left.size;
			if( this.Right != null)
				_size += this.Right.size;
			this.size = _size +1;

			return this.Maintain();
	   }


	   SBTNode SBTSearch(T Data){
		   
		    if(Data.compareTo(this.Data) == 0)
		    {
		    	return this;
		    }
		       
		    if(Data.compareTo(this.Data) < 0)
		    {
		    	if(this.Left != null)
		    	{
		    		return this.Left.SBTSearch(Data);	    			    		
		    	}
		    	else
		    	{
		    		return null;
		    	}	    	 
		    }	        
		    else
		    {
		    	if(this.Right != null)
		    	{
		    		 return this.Right.SBTSearch(Data);	    		
		    	}
		    	else
		    	{	    	 
		    	  return null;	
		    	}
		    }
		       
		}
	   
	 
	  public void  SBTinsert(T Data)
	  {	
		  this.SBTinsert(new SBTNode(Data));
	  }
	  
	  private void  SBTinsert(SBTNode node)
	  {		
		   
			this.size++;			
			node.parent = this;
			
			if(node.Data.compareTo(this.Data) < 0)
			{
				if(this.Left == null)
				{
					this.Left = node;
				}
				else
				{
					this.Left.SBTinsert(node);
					this.Left = this.Left.Maintain();
				}
			}
			else if(node.Data.compareTo(this.Data) >= 0)
			{

				if(this.Right == null)
				{
					this.Right = node;
				}
				else
				{
					this.Right.SBTinsert(node);
					this.Right = this.Right.Maintain();
				}	
			}
			
		}	   
	  

		SBTNode SBTDelete(T Data)
		{
			
			SBTNode p = null;

			if( this != null && Data.compareTo(this.Data) > 0)
			{
				if(this.Right != null)
				{
					this.Right = this.Right.SBTDelete(Data);
					return this.Count();
				}
			
				return this;
				
			}		
			else if(this != null && Data.compareTo(this.Data) < 0)
			{
				if(this.Left != null)
				{
					this.Left = this.Left.SBTDelete(Data);
					return this.Count();
				}
				return this;
			}		
			else if(this != null && Data.compareTo(this.Data) == 0)
			{			
				if( this.Left != null)
				{
					p = this.Left;
					while(p.Right != null)
						p = p.Right;

					this.Data = p.Data;

					this.Left = this.Left.SBTDelete(p.Data);
					
					return this.Count();
				}			
				else if(this.Right != null)
				{			
					p = this.Right;
					while(p.Left != null)
						p = p.Left;

					this.Data = p.Data;

					this.Right = this.Right.SBTDelete(p.Data);
								
					return this.Count();
				}
				else
				{		
					this.parent = null;
					return null;				
				}	
			}
			return this;
		}
		
		void PreorderTraversal()
		{
			 if(this != null)
			{			
				System.out.println(this.Data.toString());
			}
			if(this.Left != null)
			{
				System.out.println("还有左子树");
				this.Left.PreorderTraversal();
			}
					
					
			if(this.Right != null)
			{
				System.out.println("还有右子树");
				this.Right.PreorderTraversal();
			}		
		}

		void InorderTraversal()
		{
		
			if(this.Left != null)
			{
				System.out.println("还有左子树");
				this.Left.InorderTraversal();
			}
			
			 if(this != null)
			{
					
				System.out.println(this.Data.toString());
			}
									
			if(this.Right != null)
			{
				System.out.println("还有右子树");
				this.Right.InorderTraversal();
			}		
		}
		 
		void PostorderTraversal()
		{
				 
			if(this.Left != null)
			{
				System.out.println("还有左子树");
				this.Left.PostorderTraversal();
			}
					
					
			if(this.Right != null)
			{
				System.out.println("还有右子树");
				this.Right.PostorderTraversal();
			}	
			
			if(this != null)
			{
				
				System.out.println(this.Data.toString());
			}
		}
		
		SBTNode SBTFindRoot()
		{
			SBTNode p = this;
			if(p.parent != p)
			{
				p = p.parent;
			}
			return p;
		}

	}
	
		
		public static void main(String[] args) 
		{
			int i;

			SBTTree<Float> Tree = new SBTTree<Float>();			

			SBTTree<Float> find;
			
			for(i=0; i<1000; i++)
			{
				Tree.Insert((float) i);	
				Tree.Insert((float) ((int)(Math.random()*10)));	
			
			}
			//Tree.Delete("0");
			//Tree.Delete("1");
			//Tree.Delete("2");
			//Tree.Delete("3");
			//Tree.Delete("4");
			//Tree.Delete("5");
			//Tree.Delete("6");
			//Tree.Delete("7");
			
			find = Tree.SBTSearch((float) 7.0);
			
			
			
			Tree.PreorderTraversal();
			//find.PreorderTraversal();
			//Tree.InorderTraversal();	
			//Tree.PostorderTraversal();	
			
		}
}



