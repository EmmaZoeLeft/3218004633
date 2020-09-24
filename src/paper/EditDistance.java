package paper;

public class EditDistance {
	public static int getEd(String str1, String str2, int l1, int l2) {//��̬�滮����С�༭����
		int Distance = 0;
		int ed = 0;
		if (l1 != 0 && l2 != 0) {
			int[][] Distance_Array = new int[l1 + 1][l2 + 1];
			//���
			int Bianhao = 0;//��ʼ������ÿ���ַ����
			for (int i = 0; i <= l1; i++) {
				Distance_Array[i][0] = Bianhao;
				Bianhao++;
			}
			Bianhao = 0;
            for (int i = 0; i <= l2; i++) {
                Distance_Array[0][i] = Bianhao;
                Bianhao++;
            }

            char[] Str1_CharArray = str1.toCharArray();
            char[] Str2_CharArray = str2.toCharArray();
            for (int i = 1; i <= l1; i++) {
                for (int j = 1; j <= l2; j++) 
                {
                    if (Str1_CharArray[i - 1] == Str2_CharArray[j - 1]){
                    	Distance = 0;}//��ͬ���� 
                    else{Distance = 1;}

                    int Temp1 = Distance_Array[i - 1][j] + 1;//��
                    int Temp2 = Distance_Array[i][j - 1] + 1;//��
                    int Temp3 = Distance_Array[i - 1][j - 1] + Distance;//��

                    Distance_Array[i][j] = Math.min(Temp1, Temp2);//����С��һ��
                    Distance_Array[i][j] = Math.min(Temp3, Distance_Array[i][j]);
                }
            }
            ed = Distance_Array[l1][l2];
        }
		
        return ed;
    }
}
