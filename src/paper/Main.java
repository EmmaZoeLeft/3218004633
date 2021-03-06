package paper;

import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException,NullTextException {//io异常抛出
		//“未知数”数组args[]作为外界传入参数的入口
		String filepath = args[0];      //args[0]为orig.txt源文本
		File file = new File(filepath);	//file存储了string形式的args[0]
		File file2 = new File(args[1]); //args[1]为查重文本
        File file3 = new File(args[2]);	//args[2]为答案文本
        
        //检测是否成功获取以上文本的绝对路径
        System.out.println("源文本绝对路径：" + file.getAbsolutePath());
        System.out.println("查重文本绝对路径：" + file2.getAbsolutePath());
        System.out.println("答案文本绝对路径：" + file3.getAbsolutePath());
        
        //分词后读入源文本和抄袭文本
        String Str1 =textSplit.main(file);
        String Str2 =textSplit.main(file2);
	
        //计算相似度
        int ed = EditDistance.getEd(Str1, Str2, Str1.length(), Str2.length());//获得最小编辑距离（动态规划）
        double ans = 1 - 1.0 * ed / Math.max(Str1.length(), Str2.length());//求得相似度

        //输出答案文本
        io.write(ans,file,file2,file3);
        
        //单元测试
        //MainTest.testEd();
	} 
	
}
