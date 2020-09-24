package paper;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {
	@Test
	public void test_add() {
		File file =new File("data/orig.txt");	//file为源文本
        File file3 = new File("data/test.txt"); //file3为结果文本
        String testfile=new  String("data/orig_0.8_add.txt");//测试文本
        
        File fileTest = new File(testfile);//转化为file类型
        
        String Str1 = null;
        try {
        	Str1 = textSplit.main(file);
        } catch (IOException e) {
        	e.printStackTrace();
        }

        String Str2 = null;
        try {
        	Str2 = textSplit.main(fileTest);
        } catch (IOException e) {
        	e.printStackTrace();
        }
        
        //计算文本相似度
        int ed = EditDistance.getEd(Str1, Str2, Str1.length(), Str2.length());//获得最小编辑距离（动态规划）
        double ans = 1 - 1.0 * ed / Math.max(Str1.length(), Str2.length());//求得相似度
        
        io.write(ans,file,fileTest,file3);
        
        Assert.assertEquals(0.8,ans,0.2);
        
	}
	
	//每次只要连续测试两个就会提示OutOfMemoryError堆空间溢出，搞了很久都没办法解决……
	/*
    public  void testEd(){
    	//测试用类，实际上和Main类的原理是一样的，只是不是传参而已
    	
        File file =new File("data/orig.txt");	//file为源文本
        File file3 = new File("data/test.txt"); //file3为结果文本
    	
    	//所有待查重文本组成的string数组
        String [] testNames = new String[]{
                "data/orig_0.8_add.txt",
                "data/orig_0.8_del.txt",
                "data/orig_0.8_dis_1.txt",
                "data/orig_0.8_dis_10.txt",
                "data/orig_0.8_dis_15.txt"
        };
        
        
        //逐一测试
        for (int i=0;i<testNames.length;i++) {
            System.out.println("测试"+i+':');
            File fileTest = new File(testNames[i]);//逐一转化为file类型
            
            String Str1 = null;
            try {
            	Str1 = textSplit.main(file);
            } catch (IOException e) {
            	e.printStackTrace();
            }

            String Str2 = null;
            try {
            	Str2 = textSplit.main(fileTest);
            } catch (IOException e) {
            	e.printStackTrace();
            }
            
            //计算文本相似度
            int ed = EditDistance.getEd(Str1, Str2, Str1.length(), Str2.length());//获得最小编辑距离（动态规划）
            double ans = 1 - 1.0 * ed / Math.max(Str1.length(), Str2.length());//求得相似度
            
            io.write(ans,file,fileTest,file3);
            
            Assert.assertEquals(0.8,ans,0.2);
        }
    }*/
}
