package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXReader {
    private static String file = "C:\\Users\\upadh\\Desktop\\PallaviDubey_AP000219.xlsx";

    @SuppressWarnings("resource")
    public static void write(int roww, int columnn, String value) throws Exception {
        File myFile = new File(file);
        FileInputStream fis = new FileInputStream(myFile);
        XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);

        Iterator<Row> rowIterator = mySheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            if (row.getRowNum() == roww) {
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getColumnIndex() == columnn) {
                        cell.setCellValue(value);
                    }
                }
            } else {

            }

        }
        fis.close();
        FileOutputStream out = new FileOutputStream(("C:\\Users\\upadh\\Desktop\\PallaviDubey_AP000219.xlsx"));
        myWorkBook.write(out);
        //   out.close();
        //	myWorkBook.close();

    }

    public static Integer checkValueinRow(String voterid) throws Exception {
        File myFile = new File(file);
        FileInputStream fis = new FileInputStream(myFile);
        XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);
        int row1 = 0;
        Iterator<Row> rowIterator = mySheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();
            // System.out.println(row.getPhysicalNumberOfCells());
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if (cell.getStringCellValue().equals(voterid)) {
                    row1 = row.getRowNum();
                }

            }

        }
        return row1;
    }

}
