package Split_Merge;

import java.io.File;
/**
 * ������
 * @author GuangMing
 *
 */
public class TestDemo {
	public static void main(String[] args) {
		//�ָ��ļ�
		File src=FileUtil.getSplitSrcFile(); //��һ���ļ�,������ʵ����
		File dest=FileUtil.getSplitDestFile(); //��һ���ļ��У����Բ�����
		new SplitFile(src, dest, 1024*6); //10240��һ��long���͵���ֵ�������ļ��ֿ�ÿһ��Ĵ�С����λ���ֽڣ�B��1024B=1KB��
		
		File printFile=FileUtil.getPrintFile();
		new PrintFile().printFile(printFile);
		
		//�ϲ��ļ�
		File srcFile=FileUtil.getMergeSrcFile(); //��һ���ļ��У�������ʵ����
		File destFile=FileUtil.getMergeDestFile(); //Ҳ��һ���ļ���
		new MergeFile(srcFile, destFile);
		
	}

}
