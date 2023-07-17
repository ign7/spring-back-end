package com.example.control.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class UploadImg {
	
	
	public static boolean uploadsave(MultipartFile imagem) {
	    boolean success = false;

	    if (!imagem.isEmpty()) {
	        String nomearquivo = imagem.getOriginalFilename();
	        try {
	            String diretorio = "C:\\Users\\User\\front-end-control\\src\\images";
	            File dir = new File(diretorio);
	            if (!dir.exists()) {
	                dir.mkdirs();
	            }

	            File serverFile = new File(dir.getAbsolutePath() + File.separator + nomearquivo);
	            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
	            stream.write(imagem.getBytes());
	            stream.close();

	            System.out.println("Server file: " + serverFile.getAbsolutePath());
	            success = true; // Definir sucesso como true se o upload for bem-sucedido
	        } catch (Exception e) {
	            System.out.println("FAIL: " + e.getMessage());
	        }
	    } else {
	        System.out.println("Arquivo vazio");
	    }

	    return success;
	}

}
