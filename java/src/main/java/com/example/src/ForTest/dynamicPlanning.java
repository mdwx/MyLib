package com.example.src.ForTest;

public class dynamicPlanning {

int N = 5;
int[][] a=new int[N][N];
int dp[][][] = new int[N+N][N][N]; 
int inf = 100000;

public dynamicPlanning()
{
	for(int i=0;i<N*N; i++)
	{
		a[i/N][i%N] = i;
		if(i%N ==0)
			System.out.printf("\n\n");
		System.out.printf("%d\t",a[i/N][i%N]);			
	}
	
	getAnswer(a,N);
	
}
boolean isValid(int step,int x1,int x2,int n) { //�ж�״̬�Ƿ�Ϸ�  
int y1 = step - x1, y2 = step - x2;  
    return ((x1 >= 0) && (x1 < n) && (x2 >= 0) && (x2 < n) && (y1 >= 0) && (y1 < n) && (y2 >= 0) && (y2 < n));  
}  
  
int getValue(int step, int x1,int x2,int n) {  //����Խ�� �����ڵ�λ�� ���������ֵ  
	return isValid(step, x1, x2, n)?dp[step % 2][x1][x2]:(-inf);  
}  
  
//״̬��ʾdp[step][i][j] ����i <= j, ��step��  �����˷ֱ��ڵ�i�к͵�j�е����÷� ʱ�临�Ӷ�O(n^3) ʹ�ù������� �ռ临�Ӷ�O(n^2)   
int getAnswer(int a[][],int n) {  
int P = n * 2 - 2; //���յĲ���  
int i,j,step,s;  
      
    //���ܵ����λ�� ����Ϊ�������  
    for (i = 0; i < n; ++i) {  
        for (j = i; j < n; ++j) {  
            dp[0][i][j] = -inf;  
        }  
      
    }  
    dp[0][0][0] = a[0][0];  
  
      for (step = 1; step <= P; ++step) {  
        for (i = 0; i < n; ++i) {  
            for (j = i; j < n; ++j) {  
                dp[step][i][j] = -inf;  
                if (!isValid(step, i, j, n)) { //�Ƿ�λ��  
                    continue;  
                }  
                s = step % 2;  //״̬�±��  
                //���ںϷ���λ�ý���dp  
                if (i != j) {  
                    dp[s][i][j] = max(dp[s][i][j], getValue(step - 1, i - 1, j - 1, n));  
                    dp[s][i][j] = max(dp[s][i][j], getValue(step - 1, i - 1, j, n));  
                    dp[s][i][j] = max(dp[s][i][j], getValue(step - 1, i, j - 1, n));  
                    dp[s][i][j] = max(dp[s][i][j], getValue(step - 1, i, j,n));  
                    dp[s][i][j] += a[i][step - i] + a[j][step - j];  //����ͬһ�����ӣ���������  
                }  
                else {  
                    dp[s][i][j] = max(dp[s][i][j], getValue(step - 1, i - 1, j - 1, n));  
                    dp[s][i][j] = max(dp[s][i][j], getValue(step - 1, i - 1, j,  n));  
                    dp[s][i][j] = max(dp[s][i][j], getValue(step - 1, i, j,  n));  
                    dp[s][i][j] += a[i][step - i]; // ��ͬһ�������ֻ�ܼ�һ��  
                }  
                  
            }  
        }  
    }  
    return dp[P % 2][n - 1][n- 1];  
}



private int max(int i, int value) {
	// TODO Auto-generated method stub
	return i>value?i:value;
}

	public static void main(String[] argv){		
	
		dynamicPlanning k =new dynamicPlanning();
		System.out.printf("\n\n%d",k.dp[0][k.N-1][k.N-1]);
	}

}