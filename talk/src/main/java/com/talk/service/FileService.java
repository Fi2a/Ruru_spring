package com.talk.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.java.Log;

@Service
@Log
public class FileService {
	
	@Value("${filePath}")
	private String filePath;
	
	public String uploadFile(MultipartFile multipartFile) throws IOException {
		
		String originalName = multipartFile.getOriginalFilename(); // 원본이름
		String fileName = "";
		String fileUrl = "";
		
		fileName = fileSave( originalName , multipartFile.getBytes() );
		fileUrl = "/files/" + fileName ; // 웹(html) 에서 사용할 파일 경로	
			
		return fileUrl;
	}
	
	public List<String> uploadFile(List<MultipartFile> multipartFiles) throws IOException {
		
		List<String> fileUrls = new ArrayList<>();
		
		for( MultipartFile multipartFile : multipartFiles ) {
			String fileUrl = uploadFile(multipartFile);
			fileUrls.add(fileUrl);
		}
		
		return fileUrls;
	}
	
	private String fileSave( String originalName , byte[] fileData) throws IOException {
		
		UUID uuid = UUID.randomUUID(); // 이름 중복을 방지하기 위한 랜덤 문자열생성
		// 업로드 파일의 확장자 추출하기 -> .jpg , .PNG , .hwp
		String ext = originalName.substring( originalName.lastIndexOf(".") );
		// 실제 업로드해서 지정될 이름
		String saveName = uuid.toString() + ext ;
		// 업로드 경로와 업로드파일 명
		String fileUploadUrl = filePath + "/" + saveName;
		
		// 진짜 파일 업로드 실행
		FileOutputStream fos = new FileOutputStream( fileUploadUrl );
		fos.write(fileData);
		fos.close();
		
		return saveName;
	}
	
	
}
