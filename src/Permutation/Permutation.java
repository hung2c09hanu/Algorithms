package Permutation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Permutation {
	public static String inputFileName = "C:/Users/hung2c09hanu/workspace/GENERATION_ALGORITHM/src/BSTR.INP";
	public static String outputFileName = "C:/Users/hung2c09hanu/workspace/GENERATION_ALGORITHM/src/BSTR.OUT";
	public static int n, k, i,a,b;
	
	static int x[];
	static String text = "";
	
	public static void swap(int  n, int m){
		
		int tmp = x[n];
		x[n] = x[m];
		x[m] = tmp;
	}

	public static void main(String[] args) {

		try {

			char[] content = new char[10];
			File input = new File(inputFileName);
			// meant for reading stream of chars
			FileReader fr = new FileReader(input);
			BufferedReader bfr = new BufferedReader(fr);
			bfr.read(content);

			for (int h = 0; h < content.length - 1; h++) {

				if (n <= 0 && Character.isDigit(content[h]))
					n = Integer.parseInt(String.valueOf(content[h]));
			
				else
					break;
			}

			bfr.close();
			x = new int [n+1];
			
		for(i =1;i<=n;i++){
			x[i]=i;
			
		}
		
		
		while(true){
			
			for(i=1; i<=n;i++){
				System.out.print(x[i]);
			}
			System.out.println();
			
			i= n-1;
			//Tim doan cuoi dai nhat, cau hinh thu 2, sau cau hinh dau tien, phan tu x[i] can tim la la x [n-1] va doan cuoi dai nhat o lan duyet dau tien la doan chua phan tu cuoi cung
			while(i>0 && x[i]>x[i+1]){// kien tra tu dau day len cuoi day, tim phan tu x[i] chua duoc sap xep theo thu tu giam danxem cac phan tu da duoc sap xep theo thu tu giam dan chua, neu phan tu da duoc sap xep, ta di chuyen den phan tu truoc no
				i--;
			}
			
			if(i>0){//chua gap hoan vi cuoi
				k = n;//x[k] la phan tu cuoi day
				while(x[k]<x[i]){//lui dan  de tim phan tu x[k] lon hon x[i]
					k--;
					
				}
				swap(k, i);//doi cho x[k] va x[i]
				//lat nguoc doan cuoi thu tu giam dan thanh thu tu tang dan, a: doan dau, b: cuoi doan
				a = i+1;
				b = n;
				while(a<b){
					swap(a, b);
					a++;
					b--;
				}
			}
			else
				break;
		}
		

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
