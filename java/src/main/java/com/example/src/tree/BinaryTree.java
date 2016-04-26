package com.example.src.tree;

public abstract class BinaryTree<T> {
	
	abstract public boolean Insert(T node);

	abstract public boolean Delete(T key);		

	abstract public BinaryTree<T> SBTSearch(T Data);
	
	abstract public void PreorderTraversal();
	
	abstract public void InorderTraversal();
	
	abstract public void PostorderTraversal();
}
