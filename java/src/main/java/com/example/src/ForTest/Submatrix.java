package com.example.src.ForTest;

import java.util.ArrayList;
import java.util.List;

public class Submatrix {

    public class Unit
    {
        public int x;
        public int y;
        public int element;
        
        public Unit(int x,int y, int element)
        {
        	this.x = x;
        	this.y = y;
        	this.element = element;
        }
    }


    public class SPNode
    {
        public int rows;

        public int cols;

        public int count;

        public List<Unit> nodes = new ArrayList<Unit>();
    }
    public SPNode Build()
    {
        SPNode spNode = new SPNode();

        spNode.nodes.add(new Unit(0,0,8));
        spNode.nodes.add(new Unit(1,2,1) );
        spNode.nodes.add(new Unit(2,3,6) );
        spNode.nodes.add(new Unit(3,1,4) );

        spNode.rows = spNode.cols = 4;

        spNode.count = spNode.nodes.size();

        return spNode;
    }

    public SPNode ConvertSpNode(SPNode spNode)
    {
        SPNode spNodeLast = new SPNode();

        spNodeLast.rows = spNode.cols;
        spNodeLast.cols = spNode.rows;
        spNodeLast.count = spNode.count;

        for (int col = 0; col < spNode.cols; col++)
        {
            for (int sp = 0; sp < spNode.count; sp++)
            {
            	Unit single = spNode.nodes.get(sp);

                if (col == single.y)
                {
                    spNodeLast.nodes.add(new Unit(single.y,single.x,single.element));	                        
                }
            }
        }
        return spNodeLast;
    }

    public static void main(String[] args) {
    	Submatrix martix = new Submatrix();

        SPNode node = martix.Build();

        for (Unit item : node.nodes)
        {
          System.out.println(item.x + "\t" + item.y + "\t" + item.element);
        }

        System.out.println("******************************************************");

        node = martix.ConvertSpNode(node);

        for (Unit item : node.nodes)
        {
          System.out.println(item.x + "\t" + item.y + "\t" + item.element);
        }
        
        }

	}
