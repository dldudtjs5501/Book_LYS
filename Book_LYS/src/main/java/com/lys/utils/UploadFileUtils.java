package com.lys.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

import net.coobird.thumbnailator.Thumbnails;

public class UploadFileUtils {
	static final int THUMB_WIDTH = 300;
	static final int THUMB_HEIGHT = 300;
	
	public static String fileUpload(String uploadPath, 
			String fileName,
			byte[] fileData,String ymdPath)throws Exception {
		
		UUID uid = UUID.randomUUID();
		
		String newFileName = uid + "_" + fileName;
		String imgPath = uploadPath + ymdPath;
		
		System.out.println("newFileName======= "+newFileName);
		System.out.println("imgPath======= "+imgPath);
		
		File target = new File(imgPath ,newFileName );
		FileCopyUtils.copy(fileData, target);
		
		System.out.println("target=========="+target);
		
		String thumbFileName = "s_"+newFileName;
		File image = new File(imgPath + File.separator + newFileName);
		
		System.out.println("thumbFileName  = "+thumbFileName);
		System.out.println("image ="+image);
		
		File thumbnail = new File(imgPath + File.separator + "s" + File.separator +thumbFileName);
		
		if(image.exists()) {
			thumbnail.getParentFile().mkdir();
			Thumbnails.of(image).size(THUMB_WIDTH, THUMB_HEIGHT).toFile(thumbnail);
		}
		
		return newFileName;	
	}
	//calcPath �޼ҵ� (��¥)
	public static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator + 
				new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		String datePath = monthPath + File.separator + 
				new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		System.out.println("yearPath : "+yearPath);
		System.out.println("monthPath : "+monthPath);
		System.out.println("datePath : "+datePath);
		
		makeDir(uploadPath,yearPath,monthPath,datePath);
		makeDir(uploadPath,yearPath,monthPath,datePath+"\\s");
		return datePath;
	}
	//���͸� ����
	public static void makeDir(String uploadPath,String...paths) {
		if(new File(paths[paths.length -1]).exists()) {return;}
		
		for(String path : paths) {
			File dirPath = new File(uploadPath + path);
			
			if(!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
	}
}