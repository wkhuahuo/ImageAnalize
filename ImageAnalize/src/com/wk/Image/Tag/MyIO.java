package com.wk.Image.Tag;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyIO {
	public static String readFromIn(InputStream in){
		/*BufferedReader reader = new BufferedReader(new InputStreamReader(in));   
        StringBuilder sb = new StringBuilder();   
        String line = null;   
        try {   
            while ((line = reader.readLine()) != null) {   
                sb.append(line + "/n");   
            }   
        } catch (IOException e) {   
            e.printStackTrace();   
        } finally {   
            try {   
                in.close();   
                reader.close();
            } catch (IOException e) {   
                e.printStackTrace();   
            }   
        }
		return line;   

	    */
		try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] temp = new byte[1024];
            for (;;) {
                int size = in.read(temp);
                if (size != -1) {
                    out.write(temp, 0, size);
                } else {
                    break;
                }
            }
            String result = new String(out.toByteArray());
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
	   
	}

	public static boolean writetoFile(File file,String content){
		FileWriter filewrite;
		try {
			filewrite = new FileWriter(file);
			filewrite.write(content);
		} catch (IOException e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
