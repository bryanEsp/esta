package com.automatizacion.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.IIOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class LecturaExcel {
	public LecturaExcel() {
		
	}
	public void lectura(String ruta, String nombre) throws IOException {
		File file = new File(ruta);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook newworkbook = new XSSFWorkbook(inputStream);
		XSSFSheet newsheet = newworkbook.getSheet(nombre);
		int rowCount = newsheet.getLastRowNum() - newsheet.getFirstRowNum();
		for (int i = 0; i <= rowCount; i++) {
			XSSFRow fila = newsheet.getRow(i);
			
			for (int j = 0; j < fila.getLastCellNum(); j++) {
				System.out.println(fila.getCell(i).getStringCellValue() + "||");
			}
		}
	}
	public String LeerValorCelda(String ruta, String nombre, int fila, int celda) throws IOException {
		File file = new File(ruta);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook newworkbook = new XSSFWorkbook(inputStream);
		XSSFSheet newsheet = newworkbook.getSheet(nombre);
		
		DataFormatter formatter = new DataFormatter();
		XSSFRow row = newsheet.getRow(fila);
		XSSFCell cell = row.getCell(celda);
       
        String data0= formatter.formatCellValue(cell);

		return data0;
	}
}
