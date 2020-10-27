package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileDownloadHelper {
	
	public static void copy(String filePath, OutputStream os) throws IOException {
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(filePath);
			byte[] data = new byte[8096]; //버퍼 크기 설정
			int len = -1;
			while((len = fis.read(data)) != -1) {
				os.write(data, 0, len);
			} // 파일이 남아 있면 읽어서(read) data에 저장(write)
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch(IOException ioe) {
					
				}
			}
			if(os != null) {
				try {
					os.close();
				} catch(IOException oe) {
					
				}
			}
		}
		
	}
	
}
