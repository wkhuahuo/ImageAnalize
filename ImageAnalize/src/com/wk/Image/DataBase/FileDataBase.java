package com.wk.Image.DataBase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import com.wk.Image.Tag.Poem;

public class FileDataBase {
	private String fileFullPath="dataBase/PoemDataBase.txt";
	public Map<String,Poem> keyandPoem = new HashMap<String, Poem>();
	public Map<String,Poem> initFileDataBase(){
		File file = new File(fileFullPath);
		if(!file.exists()){
			return null;
		}
		try {
			FileReader filein = new FileReader(file);
			BufferedReader bufferRead = new BufferedReader(filein);
			
			String str = new String();
            while ((str = bufferRead.readLine()) != null) {
                String[] tmpContent = str.split(":");
                assert(tmpContent.length!=2);
                if(tmpContent.length==2){//
                	Poem poem = new Poem(tmpContent[1]);
                	keyandPoem.put(tmpContent[0], poem);
                }
            }
            filein.close();
        
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return keyandPoem;	
	}
	
	
	
}
