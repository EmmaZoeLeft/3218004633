package paper;

import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException,NullTextException {//io�쳣�׳�
		//��δ֪��������args[]��Ϊ��紫����������
		String filepath = args[0];      //args[0]Ϊorig.txtԴ�ı�
		File file = new File(filepath);	//file�洢��string��ʽ��args[0]
		File file2 = new File(args[1]); //args[1]Ϊ�����ı�
        File file3 = new File(args[2]);	//args[2]Ϊ���ı�
        
        //����Ƿ�ɹ���ȡ�����ı��ľ���·��
        System.out.println("Դ�ı�����·����" + file.getAbsolutePath());
        System.out.println("�����ı�����·����" + file2.getAbsolutePath());
        System.out.println("���ı�����·����" + file3.getAbsolutePath());
        
        //�ִʺ����Դ�ı��ͳ�Ϯ�ı�
        String Str1 =textSplit.main(file);
        String Str2 =textSplit.main(file2);
	
        //�������ƶ�
        int ed = EditDistance.getEd(Str1, Str2, Str1.length(), Str2.length());//�����С�༭���루��̬�滮��
        double ans = 1 - 1.0 * ed / Math.max(Str1.length(), Str2.length());//������ƶ�

        //������ı�
        io.write(ans,file,file2,file3);
        
        //��Ԫ����
        //MainTest.testEd();
	} 
	
}
