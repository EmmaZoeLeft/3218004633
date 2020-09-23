package paper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.hfutec.preprocess.wordseg.Jieba;

public class textSplit {
	
	public static String main(File file) throws IOException {
		//file为传递来的文件参数
		File output = new File("lib"+File.separator+"testSplit.txt"); //分词、去停用词后的文本数据	
		
		try {
	        File file1 = new File("data/stopWords.txt"); 
	        List<String> stopword= FileUtils.readLines(file1,"utf8");  //加载停用词，存储在List集合中
	        BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
			BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output),"UTF-8"));
			String line;
			Jieba jieba = new Jieba();
			int i = 0;
			while((line = bufr.readLine())!=null){   //循环每一行文本进行处理
				List<String> outList = new ArrayList<String>();
				List<String> input_text_list = new ArrayList<>();
				
				//将逐行读入的文本录入String列表input_text_list中
				input_text_list.add(line);
				//将每行文本用结巴进行分词，并返回分词后的String数组
				String[] outStrings = jieba.seg(input_text_list).get(0).split("\\s+"); 
				//将String数组转成List集合outList
				for(String word:outStrings)   
					outList.add(word);
				//去除停用词
				outList.removeAll(stopword); 
				//将List集合转为字符串seg，中间用空格隔开
				String seg = String.join(" ", outList); 
				
				//将字符串seg写入文件output中
				bufw.append(seg);
				bufw.newLine();
				bufw.flush();
				//System.out.println(i++);
			}
			bufw.flush();
			bufw.close();
			bufr.close();			
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		//再将分词后的文件output搞成字符串形式
		BufferedReader f1 = new BufferedReader(new InputStreamReader(new FileInputStream(output)));
		String s = "";
        String Str1 = "";
		while ((s = f1.readLine()) != null) {
            Str1 += s + "\r\n";
        }
		return Str1;
	}
}
