package Utilities;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ReadExcelXLS {
    private static String excelPath = ".//src//main//resources//Feature.xls";
    private static String featureFilePath = ".//src//main//resources//";


    public void excelRead() throws IOException {
        {

            String sheetName = "";
            try {
                POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(excelPath));
                HSSFWorkbook wb = new HSSFWorkbook(fs);
                int numberOfSheets = wb.getNumberOfSheets();

                for (int k = 0; k < numberOfSheets - 1; k++) {
                    int counter = 0;
                    sheetName = wb.getSheetName(k);
                    HSSFSheet sheet = wb.getSheetAt(k);
                    HSSFRow row;
                    HSSFCell cell;

                    int rows; // No of rows
                    rows = sheet.getPhysicalNumberOfRows();

                    int cols = 0; // No of columns
                    int tmp = 0;

                    for (int i = 0; i < rows; i++) {
                        row = sheet.getRow(i);
                        if (row != null) {
                            tmp = sheet.getRow(i).getPhysicalNumberOfCells();
                            if (tmp > cols) cols = tmp;
                        }
                    }
                    outerloop:
                    for (int r = 0; r < rows; r++) {
                        try {
                            row = sheet.getRow(r);
                            List<String> list = new LinkedList<>();
                            if (row.getCell((short) 0).toString() != null && row.getCell((short) 1).toString() != null) {
                                list.add(row.getCell((short) 0).toString() + " ");
                                list.add(" " + row.getCell((short) 1).toString());


                            }
                        } catch (Exception e) {
                        }

                    }
                }

            } catch (Exception ioe) {

            }

        }
    }
}
