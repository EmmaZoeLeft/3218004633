package paper;

import java.io.*;
import java.text.DecimalFormat;

public class io {
	
    public static String read(File file) throws IOException{
            BufferedReader f1 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            String s = "";
            String Str1 = "";
            while ((s = f1.readLine()) != null) {//���ı�ת��ΪString
                Str1 += s + "\r\n";
            }
            return Str1;
    }
    
    public static void  write (double ans,File file,File file2,File file3)
    {
    	//����Ĵ�Ϊ�����ͣ���ȷ��С�������λ
        String ans1 = String.format("%.2f", ans);
        System.out.println("�ı��ظ���Ϊ��"+ans1);
        //�ճ�����ʾΪ�ٷֱ���ʽ
        DecimalFormat df = new DecimalFormat("0.00%");
        System.out.println("�ı��ظ���Ϊ��"+df.format(ans)+"[�ٷֱ���ʽ]");
        
        try (FileWriter writer = new FileWriter(file3)) {
        	writer.write("Դ�ı�����·����"+ file.getAbsolutePath()+"\n");
        	writer.write("�����ı�����·����"+file2.getAbsolutePath()+"\n");
        	writer.write("�ı��ظ���Ϊ��"+ans1+"\n");
            writer.write("�ı��ظ���Ϊ��"+df.format(ans)+"[�ٷֱ���ʽ]");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}