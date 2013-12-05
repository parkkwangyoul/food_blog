package com.food.blog.upload;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Service
public class UploadServiceImpl implements UploadService {

	public String getFreeFilePath(String ... paths) {
		String path = "resources/upload/";
		
		for (int i = 0; i < paths.length; ++i) {
			path += paths[i] + "/";
	    }
		
		/*로컬용 경로*/
		path = "C:/sourcetree/food_blog/food_blog/food_blog/src/main/webapp/resources/upload/";
		
		//랜덤 경로 생성: 이미 없는 경로를 만든다.
		String randomPath = null;
		while (randomPath == null) {
			UUID randomUUID = UUID.randomUUID();
			File testPath = new File(path + randomUUID);
			if (testPath.exists() == false) {
				randomPath = testPath.getPath();
				
				testPath = new File(path);
				if (testPath.exists() == false) {
					//폴더가 없으면 만든다.
					testPath.mkdirs();
				}
			}
		}
		return randomPath;
	}
	

	
	public String transferFile(CommonsMultipartFile uploadedFile, String ... paths) {
		String filePath = getFreeFilePath(paths);
		
		File dest = new File(filePath);
		try {
			uploadedFile.transferTo(dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filePath;
	}
	
}
