package paper;

import java.io.*;
import java.text.DecimalFormat;

public class io {
	
    public static String read(File file) throws IOException{
            BufferedReader f1 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            String s = "";
            String Str1 = "";
            while ((s = f1.readLine()) != null) {//将文本转化为String
                Str1 += s + "\r\n";
            }
            return Str1;
    }
    
    public static void  write (double ans,File file,File file2,File file3)
    {
    	//输出的答案为浮点型，精确到小数点后两位
        String ans1 = String.format("%.2f", ans);
        System.out.println("文本重复率为："+ans1);
        //照常规显示为百分比形式
        DecimalFormat df = new DecimalFormat("0.00%");
        System.out.println("文本重复率为："+df.format(ans)+"[百分比形式]");
        
        try (FileWriter writer = new FileWriter(file3)) {
        	writer.write("源文本绝对路径："+ file.getAbsolutePath()+"\n");
        	writer.write("查重文本绝对路径："+file2.getAbsolutePath()+"\n");
        	writer.write("文本重复率为："+ans1+"\n");
            writer.write("文本重复率为："+df.format(ans)+"[百分比形式]");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}