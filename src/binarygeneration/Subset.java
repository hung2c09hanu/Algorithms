package binarygeneration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Subset {
	public static String inputFileName = "C:/Users/hung2c09hanu/workspace/GENERATION_ALGORITHM/src/SUBSET.INP";
	public static String outputFileName = "C:/Users/hung2c09hanu/workspace/GENERATION_ALGORITHM/src/SUBSET.OUT";
	public static int n, k, i;
	static int x[];
	static String text = "";

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

				else if (n > 0 && k <= 0) {
					if (Character.isDigit(content[h + 1])) {
						k = Integer.parseInt(String.valueOf(content[h + 1]));
					}
					continue;
				} else
					break;

			}

			bfr.close();

			x = new int[n];

			for (i = 1; i <= k; i++) {
				x[i] = i;

			}

			while (true) {
				
				text = "{";
				for (i = 1; i <= k - 1; i++) {
					text += x[i] + ",";
				}
				text += x[k] + "}";
				System.out.println(text);// in cau hinh hien tai
				
				// Sinh tiep
				i = k;// Xet tu cuoi day len tim x[i] chua dat gioi han tren
						// n-k+i
				while (i > 0 && x[i] == n - k + i) {
					i--;
				}

				if (i > 0) {// chua lui den 0 co nghia la chua phai cau hinh ket
							// thuc
					x[i]++;// tang x[i] len 1, dat cac phan tu sau x[i] bang
							// gioi han duoi cua no
					for (int j = i + 1; j <= k; j++) {
						x[j] = x[j - 1] + 1;// gioi han duoi cua mot phan tu
					}

				} else
					break;// lui den tan 0 tuc la cac phan tu dat dat gioi han
							// tren- het cau hinh

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void fillChar(int x[], int from, int to, int value) {
		String str = "";
		for (int h = from; h < to; h++) {
			x[h] = value;

		}
		for (int h = 0; h < x.length; h++) {
			str += String.valueOf(x[h]);
		}
		str += "\n";
		try {
			File output = new File(outputFileName);
			FileWriter fw;

			fw = new FileWriter(output, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(str);

			bw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
