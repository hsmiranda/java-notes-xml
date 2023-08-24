package br.com.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Classe com metodos uteis.
 * 
 * @author hmiranda
 *
 */
public class Utilitarios {
	
	 private Utilitarios() {
		 throw new IllegalStateException("Utility class");
	}
	
	/**
	 * Cria um arquivo temporario com base em um texto.
	 *  
	 * @param texto
	 * @return
	 */
	public static File salvaTemp(String texto) {
		
		File f = null;
		
        try {
        	
        	String tmpdir = System.getProperty("java.io.tmpdir");
			Path diretorio = Files.createTempFile("tmp", null);
			
			byte[] textoEmBytes = texto.getBytes();
			Files.write(diretorio, textoEmBytes);			
			
			System.out.println(tmpdir);
		} 
        
        catch (IOException e) {
			e.printStackTrace();
		}
			
		return f;
	}
	
	/**
	 * Metodo que zipa um arquivo.
	 *
	 * @param dir
	 * @param name
	 * @param files
	 */
	public static void createZipFiles(String dir, String name, List<File> files) {

		byte[] buffer = new byte[1024];
		File dirFile = new File(dir);

		try{

			FileOutputStream fos = new FileOutputStream(dir + "/" + name + ".zip");
			
			ZipOutputStream zos = new ZipOutputStream(fos);

			for (Iterator<File> iterator = files.iterator(); iterator.hasNext();) {
				
				File file = iterator.next();
				
				// Adiciona ao zip a estrutura referente aos diretórios relativos a partir do diretório passado
				ZipEntry ze = new ZipEntry(dirFile.toURI().relativize(file.toURI()).getPath());
				zos.putNextEntry(ze);
				
				FileInputStream in = new FileInputStream(file.getAbsolutePath());
				
				int len;
				while ((len = in.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}
				
				in.close();
			}

			zos.closeEntry();
			zos.close();
		}
				
		catch(IOException ex){
			ex.printStackTrace();
		}
	}
}