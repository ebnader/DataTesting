import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





public class ReadData {
	
	public static String[][]getData(String filename,String sheetName)throws IOException{
		FileInputStream fis = new FileInputStream("C:\\Users\\ebnad\\Documents\\eclipseMars\\DataTesting\\MercuryData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh =  wb .getSheetAt(0);
		int rowNum=sh.getLastRowNum()+1;
		int colNum=sh.getRow(0).getLastCellNum();
		
		String[][]data=new String[rowNum][colNum];
		for(int i=0;i<rowNum;i++){
			Row row=sh.getRow(i);
			for(int j=0;j<colNum;j++){
			Cell cell= row.getCell(j);
			String value=celltoString(cell);
			value=new DataFormatter().formatCellValue((org.apache.poi.ss.usermodel.Cell) cell);
			data[i][j]=value;
		
			wb.close();
			
			}
			
		}
		
		return data;
		
	}

	private static String celltoString(Cell cell) {
		// TODO Auto-generated method stub
		return null;
	}

}
