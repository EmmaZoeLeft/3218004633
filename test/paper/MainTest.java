package paper;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {
	@Test
	public void test_add() {
		File file =new File("data/orig.txt");	//fileΪԴ�ı�
        File file3 = new File("data/test.txt"); //file3Ϊ����ı�
        String testfile=new  String("data/orig_0.8_add.txt");//�����ı�
        
        File fileTest = new File(testfile);//ת��Ϊfile����
        
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
        
        //�����ı����ƶ�
        int ed = EditDistance.getEd(Str1, Str2, Str1.length(), Str2.length());//�����С�༭���루��̬�滮��
        double ans = 1 - 1.0 * ed / Math.max(Str1.length(), Str2.length());//������ƶ�
        
        io.write(ans,file,fileTest,file3);
        
        Assert.assertEquals(0.8,ans,0.2);
        
	}
	
	//ÿ��ֻҪ�������������ͻ���ʾOutOfMemoryError�ѿռ���������˺ܾö�û�취�������
	/*
    public  void testEd(){
    	//�������࣬ʵ���Ϻ�Main���ԭ����һ���ģ�ֻ�ǲ��Ǵ��ζ���
    	
        File file =new File("data/orig.txt");	//fileΪԴ�ı�
        File file3 = new File("data/test.txt"); //file3Ϊ����ı�
    	
    	//���д������ı���ɵ�string����
        String [] testNames = new String[]{
                "data/orig_0.8_add.txt",
                "data/orig_0.8_del.txt",
                "data/orig_0.8_dis_1.txt",
                "data/orig_0.8_dis_10.txt",
                "data/orig_0.8_dis_15.txt"
        };
        
        
        //��һ����
        for (int i=0;i<testNames.length;i++) {
            System.out.println("����"+i+':');
            File fileTest = new File(testNames[i]);//��һת��Ϊfile����
            
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
            
            //�����ı����ƶ�
            int ed = EditDistance.getEd(Str1, Str2, Str1.length(), Str2.length());//�����С�༭���루��̬�滮��
            double ans = 1 - 1.0 * ed / Math.max(Str1.length(), Str2.length());//������ƶ�
            
            io.write(ans,file,fileTest,file3);
            
            Assert.assertEquals(0.8,ans,0.2);
        }
    }*/
}
