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
        //编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符
        int ed = EditDistance.getEd(Str1, Str2, Str1.length(), Str2.length());//获得最小编辑距离（动态规划）
        double ans = 1 - 1.0 * ed / Math.max(Str1.length(), Str2.length());//求得相似度
        // double bb = getSimilarity(Str_1,Str_2);余弦定理方法
        //io.write(ans,file3);
        return  ans;
    }
}