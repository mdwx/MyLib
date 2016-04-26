package com.example.src.ForTest;

import java.util.ArrayList;
import java.util.List;

public class Submatrix {
	
    /// <summary>
    /// ��Ԫ��
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
    /// ��ʶ����
    /// </summary>
    public class SPNode
    {
        //����������
        public int rows;

        //����������
        public int cols;

        //����Ԫ�صĸ���
        public int count;

        //�����з���Ԫ��
        public List<Unit> nodes = new ArrayList<Unit>();
    }

    /// <summary>
    /// ����һ����Ԫ��
    /// </summary>
    /// <returns></returns>
    public SPNode Build()
    {
        SPNode spNode = new SPNode();

        //��ѭ�����ȵ�ԭ��
        spNode.nodes.add(new Unit(0,0,8));
        spNode.nodes.add(new Unit(1,2,1) );
        spNode.nodes.add(new Unit(2,3,6) );
        spNode.nodes.add(new Unit(3,1,4) );

        //4�׾���
        spNode.rows = spNode.cols = 4;

        //����Ԫ�صĸ���
        spNode.count = spNode.nodes.size();

        return spNode;
    }

    /// <summary>
    /// ��ת������
    /// </summary>
    /// <param name="spNode"></param>
    /// <returns></returns>
    public SPNode ConvertSpNode(SPNode spNode)
    {
        //����Ԫ�ص�x��y������н���
        SPNode spNodeLast = new SPNode();

        //���л���
        spNodeLast.rows = spNode.cols;
        spNodeLast.cols = spNode.rows;
        spNodeLast.count = spNode.count;

        //ѭ��ԭ��������� (����ת��)
        for (int col = 0; col < spNode.cols; col++)
        {
            //ѭ����Ԫ���еĸ���
            for (int sp = 0; sp < spNode.count; sp++)
            {
            	Unit single = spNode.nodes.get(sp);

                //�ҵ���Ԫ���д��ڵ���ͬ���
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

        //������Ԫ��
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
