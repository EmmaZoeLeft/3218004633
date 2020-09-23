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
		//fileΪ���������ļ�����
		File output = new File("lib"+File.separator+"testSplit.txt"); //�ִʡ�ȥͣ�ôʺ���ı�����	
		
		try {
	        File file1 = new File("data/stopWords.txt"); 
	        List<String> stopword= FileUtils.readLines(file1,"utf8");  //����ͣ�ôʣ��洢��List������
	        BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
			BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output),"UTF-8"));
			String line;
			Jieba jieba = new Jieba();
			int i = 0;
			while((line = bufr.readLine())!=null){   //ѭ��ÿһ���ı����д���
				List<String> outList = new ArrayList<String>();
				List<String> input_text_list = new ArrayList<>();
				
				//�����ж�����ı�¼��String�б�input_text_list��
				input_text_list.add(line);
				//��ÿ���ı��ý�ͽ��зִʣ������طִʺ��String����
				String[] outStrings = jieba.seg(input_text_list).get(0).split("\\s+"); 
				//��String����ת��List����outList
				for(String word:outStrings)   
					outList.add(word);
				//ȥ��ͣ�ô�
				outList.removeAll(stopword); 
				//��List����תΪ�ַ���seg���м��ÿո����
				String seg = String.join(" ", outList); 
				
				//���ַ���segд���ļ�output��
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
		
		//�ٽ��ִʺ���ļ�output����ַ�����ʽ
		BufferedReader f1 = new BufferedReader(new InputStreamReader(new FileInputStream(output)));
		String s = "";
        String Str1 = "";
		while ((s = f1.readLine()) != null) {
            Str1 += s + "\r\n";
        }
		return Str1;
	}
}
