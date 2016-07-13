package com.example.src.ForTest;

import java.util.ArrayList;
import java.util.List;

public class Submatrix {
	
    /// <summary>
    /// 三元组
    /// </summary>
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

    /// <summary>
    /// 标识矩阵
    /// </summary>
    public class SPNode
    {
        //矩阵总行数
        public int rows;

        //矩阵总列数
        public int cols;

        //非零元素的个数
        public int count;

        //矩阵中非零元素
        public List<Unit> nodes = new ArrayList<Unit>();
    }

    /// <summary>
    /// 构建一个三元组
    /// </summary>
    /// <returns></returns>
    public SPNode Build()
    {
        SPNode spNode = new SPNode();

        //遵循行优先的原则
        spNode.nodes.add(new Unit(0,0,8));
        spNode.nodes.add(new Unit(1,2,1) );
        spNode.nodes.add(new Unit(2,3,6) );
        spNode.nodes.add(new Unit(3,1,4) );

        //4阶矩阵
        spNode.rows = spNode.cols = 4;

        //非零元素的个数
        spNode.count = spNode.nodes.size();

        return spNode;
    }

    /// <summary>
    /// 行转列运算
    /// </summary>
    /// <param name="spNode"></param>
    /// <returns></returns>
    public SPNode ConvertSpNode(SPNode spNode)
    {
        //矩阵元素的x和y坐标进行交换
        SPNode spNodeLast = new SPNode();

        //行列互换
        spNodeLast.rows = spNode.cols;
        spNodeLast.cols = spNode.rows;
        spNodeLast.count = spNode.count;

        //循环原矩阵的列数 (行列转换)
        for (int col = 0; col < spNode.cols; col++)
        {
            //循环三元组行的个数
            for (int sp = 0; sp < spNode.count; sp++)
            {
            	Unit single = spNode.nodes.get(sp);

                //找到三元组中存在的相同编号
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

        //构建三元组
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
