package paper;

import java.io.File;
import java.io.IOException;

public class Test {
    public static double test(String testname)
    {
        File file =new File("data"+File.separator+"orig.txt");
        File file3 = new File("data"+File.separator+"orig_0.8_add.txt");
        File file1 = new File(testname);
        String Str1 = null;
        try {
        	Str1 = textSplit.main(file);
        } catch (IOException e) {
        	e.printStackTrace();
        }
        String Str2 = null;
        try {
        	Str2 = textSplit.main(file1);
        } catch (IOException e) {
        	e.printStackTrace();
        }
        //�༭����������һ���ַ��滻����һ���ַ�������һ���ַ���ɾ��һ���ַ�
        int ed = EditDistance.getEd(Str1, Str2, Str1.length(), Str2.length());//�����С�༭���루��̬�滮��
        double ans = 1 - 1.0 * ed / Math.max(Str1.length(), Str2.length());//������ƶ�
        // double bb = getSimilarity(Str_1,Str_2);���Ҷ�����
        //io.write(ans,file3);
        return  ans;
    }
}