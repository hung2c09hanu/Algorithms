import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BSTRING1 {
	public static String inputFileName = "C:/Users/hung2c09hanu/workspace/GENERATION_ALGORITHM/src/BSTR.INP";
	public static String outputFileName = "C:/Users/hung2c09hanu/workspace/GENERATION_ALGORITHM/src/BSTR.OUT";
	public static int n;
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
			attempt(0);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void  printResult(){
		for(int i = 0 ; i < n;i++){
			System.out.print(x[i]);
		}
		System.out.println();
	}
	public static void attempt(int pos){//the position to take an attempt
		
		for(int value =0; value<=1;value++){
			x[pos]=value;
			if(pos == n-1){
				printResult();//phan neo
			}
			else
			{
				attempt((pos+1));//phan de quy
			}
		}
	}
}
