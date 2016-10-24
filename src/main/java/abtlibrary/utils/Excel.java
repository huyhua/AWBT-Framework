package abtlibrary.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Excel {
	private FileInputStream ExcelFile;
	public XSSFSheet ExcelWSheet;
	private XSSFWorkbook ExcelWBook;
	private XSSFCell Cell;
	private XSSFRow Row;
	public Method method;

	// This method is to set the File path and to open the Excel file, Pass
	// Excel Path and Sheetname as Arguments to this method
	public void setExcelFile(String path, String sheetName) throws Exception {
		try {
			// Open the Excel file
			ExcelFile = new FileInputStream(path);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			if (sheetName.equals("")) {
				ExcelWSheet = ExcelWBook.getSheetAt(0);
			} else {
				ExcelWSheet = ExcelWBook.getSheet(sheetName);
			}
		} catch (Exception e) {
			throw (e);
		}
	}

	// This method is used to get the total rows in data Excel file
	public int getNumrow() throws Exception {
		try {
			int numrow = ExcelWSheet.getLastRowNum() - ExcelWSheet.getFirstRowNum();
			return numrow;
		} catch (Exception e) {
			return 0;
		}
	}

	// This method is used to get the total column in data Excel file
	public int getLastColumnIndex() throws Exception {
		int column_index = 0;
		try {

			int lastRow = ExcelWSheet.getLastRowNum();
			for (int i = 0; i < lastRow; i++) {
				int lastCol = ExcelWSheet.getRow(i).getLastCellNum();
				for (int n = lastCol; n >= 0; n--) {
					String cellData = getCellData(i, n);
					if (!cellData.equals("")) {
						lastCol = n;
						break;
					}
				}
				if (lastCol > column_index) {
					column_index = lastCol;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return column_index;
	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num
	public String getCellData(int RowNum, int ColNum) {
		try {
			String CellData = "";
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			if (Cell.getCellType() == 1) {
				CellData = Cell.getStringCellValue().toString();
			} else if (Cell.getCellType() == 0) {
				CellData = String.valueOf(Cell.getNumericCellValue());
			}

			return CellData;
		} catch (Exception e) {
			return "";

		}
	}

	// This method is to write in the Excel cell, Row num and Col num are the
	// parameters
	public void setCellData(String filepath, String Result, int RowNum, int ColNum) throws Exception {
		try {
			Row = ExcelWSheet.getRow(RowNum);
			if (Row == null) {
				Row = ExcelWSheet.createRow(RowNum);
			}
			Cell = Row.getCell(ColNum, org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}
			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(filepath);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}

	// This method is to write in the Excel cell, Row num and Col num are the
	// parameters
	public void setRowData(String filepath, String[] arrResult, int RowNum, int ColNum) throws Exception {
		try {
			Row = ExcelWSheet.getRow(RowNum);
			if (Row == null) {
				Row = ExcelWSheet.createRow(RowNum);
			}
			for (int i = 0; i < arrResult.length; i++) {
				Cell = Row.getCell(ColNum + i, org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL);
				if (Cell == null) {
					Cell = Row.createCell(ColNum + i);
					Cell.setCellValue(arrResult[i]);
				} else {
					Cell.setCellValue(arrResult[i]);
				}
			}
			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(filepath);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}

	// Get Column Index by name
	public int getColumnIndex(Integer rownum, String value) {
		int columnIndex = -1;
		try {
			int totalColumn = getLastColumnIndex();
			for (int i = 0; i < totalColumn; i++) {
				Cell = ExcelWSheet.getRow(rownum).getCell(i);
				String CellData = Cell.getStringCellValue().trim();
				if (CellData.equals(value)) {
					columnIndex = i;

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return columnIndex;
	}

	// Get data on excel sheet
	public List<String[]> getExcelSheet(String filePath, String sheetName, int startRow, int startCol) {

		List<String[]> dataSet = new ArrayList<String[]>();

		try {
			setExcelFile(filePath, sheetName);

			int totalRows = ExcelWSheet.getLastRowNum() + 1 - startRow;
			int totalCols = 0;
			try {
				totalCols = getLastColumnIndex() + 1 - startCol;
			} catch (Exception e) {

				e.printStackTrace();
			}

			int cj = 0;
			for (int i = startRow; i < totalRows; i++) {
				String[] row = new String[totalCols];
				for (int j = startCol; j < totalCols; j++) {
					row[cj++] = getCellData(i, j).toString();

				}
				dataSet.add(row);
				cj = 0;
			}
			// close file
			ExcelFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return dataSet;
	}
}