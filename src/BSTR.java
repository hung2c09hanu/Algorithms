import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BSTR {
	public static String inputFileName = "C:/Users/hung2c09hanu/workspace/GENERATION_ALGORITHM/src/BSTR.INP";
	public static String outputFileName = "C:/Users/hung2c09hanu/workspace/GENERATION_ALGORITHM/src/BSTR.OUT";
	public static int n, k;
	static int x[];

	public static void main(String[] args) {

		try {

			File input = new File(inputFileName);
			// meant for reading stream of chars
			FileReader fr = new FileReader(input);
			BufferedReader bfr = new BufferedReader(fr);

			n = Integer.parseInt(bfr.readLine());
			bfr.close();
			x = new int[n];
			// tao cau hinh dau 0...0
			fillChar(x, 0, n, 0);

			while (true) {
				for (int i = 0; i < x.length; i++) {
					System.out.print(x[i]);
				}
				System.out.println();

				k = n - 1;// x[k] la phan tu cuoi day
				while (k >= 0 && x[k] == 1) {
					k--;
				}

				if (k >= 0) {// chua gap phai cau hinh 1...1

					x[k] = 1;
					fillChar(x, k + 1, n, 0);
				} else
					// da gap cau hinh 1...1
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

	public static void fillChar(int x[], int from, int to, int value) {
		String str = "";
		for (int i = from; i < to; i++) {
			x[i] = value;

		}
		for (int i = 0; i < x.length; i++) {
			str += String.valueOf(x[i]);
		}
		str+="\n";
		try {
			File output = new File(outputFileName);
			FileWriter fw;

			fw = new FileWriter(output,true);
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
