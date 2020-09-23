package paper;

import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException,NullTextException {//io�쳣�׳�
		//��δ֪��������args[]��Ϊ��紫����������
		String filepath = args[0];      //args[0]Ϊorig.txtԴ�ı�
		File file = new File(filepath);
		File file2 = new File(args[1]); //args[2]Ϊ�����ı�
        File file3 = new File(args[2]);	//args[3]Ϊ���ı�
        
        //����Ƿ�ɹ���ȡ�����ı��ľ���·��
        System.out.println("�ļ��ľ���·����" + file.getAbsolutePath());
        System.out.println("�ļ��ľ���·����" + file2.getAbsolutePath());
        System.out.println("�ļ��ľ���·����" + file3.getAbsolutePath());
        
        //�ִʺ����Դ�ı��ͳ�Ϯ�ı�
        String Str1 =textSplit.main(file);
        String Str2 =textSplit.main(file2);
	
        int ed = EditDistance.getEd(Str1, Str2, Str1.length(), Str2.length());//�����С�༭���루��̬�滮��
        double ans = 1 - 1.0 * ed / Math.max(Str1.length(), Str2.length());//������ƶ�

        //������ı�
        io.write(ans,file,file2,file3);
        //MainTest.testEd();
	} 
	
    public static boolean isHanZi(char ch) {
        // �ж��Ƿ���
        return (ch >= 0x4E00 && ch <= 0x9FA5);

    }
}
