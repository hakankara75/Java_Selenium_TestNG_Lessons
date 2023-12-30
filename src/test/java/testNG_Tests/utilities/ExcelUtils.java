package testNG_Tests.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    Workbook workbook;
    Sheet sheet;
    String path;
    //Excel'de islem yapabilmek icin constructor olusturacagim
    public ExcelUtils(String path, String sheetName)  { //acilacak dosya yolunu ve sayfa ismini verecegim
        this.path=path; //bu classdaki path kullan
        try {
            FileInputStream fise= new FileInputStream(path);
            workbook = WorkbookFactory.create(fise);
            sheet = workbook.getSheet(sheetName);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Satir ve sütun sayilari girildiğinde, o hücredeki veriyi return eder
    public String getCellData(int rowNum,int colNum){
        Cell cell = sheet.getRow(rowNum).getCell(colNum);
        return cell.toString();
    }
    //Exceldeki satir sayisini return eder
    public int rowCount(){
        return  sheet.getLastRowNum();
    }
    //Exceldeki sütun sayisini return eder
    public int columnCount(){
        return sheet.getRow(0).getLastCellNum();
    }

    //============Exceldeki datalari 2 boyutlu array seklinde alir===
    public String[][] getDataArray() {
        String[][] data = new String[rowCount()][columnCount()];
        for (int i = 0; i < rowCount(); i++) {
            for (int j = 0; j < columnCount(); j++) {
                String value = getCellData(i, j);
                data[i][j] = value;
            }
        }
        return data;
    }

    //==============Sutun isimlerini verir==================//
    public List<String> getColumnsNames() {
        List<String> columns = new ArrayList<>();
        for (Cell cell : sheet.getRow(0)) {
            columns.add(cell.toString());
        }
        return columns;
    }
    //=========Deger, Satir, Sutun girindiginde, O satır ve sutuna girilen veriyi ekler===============//
    public void setCellData(String value, int rowNum, int colNum) {
        Cell cell;
        Row row;
        FileOutputStream fileOutputStream = null;

        try {
            row = sheet.getRow(rowNum);
            if (row == null) {
                row = sheet.createRow(rowNum);
            }

            cell = row.getCell(colNum);
            if (cell == null) {
                cell = row.createCell(colNum);
            }

            cell.setCellValue(value);

            fileOutputStream = new FileOutputStream(path);
            workbook.write(fileOutputStream);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (workbook != null) {
                    workbook.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //    Bu metot ustdeki metotla birlikde calisir. Overload eder. Parametreleri farklidir
    public void setCellData(String value, String columnName, int row) {
        int column = getColumnsNames().indexOf(columnName);
        setCellData(value, row, column);
    }

    //    Exceldeki datalari basliksiz olarak 2 boyutlu array seklinde return eder
    public String[][] getDataArrayWithoutFirstRow() {
        String[][] data = new String[rowCount()][columnCount()];
        for (int i =1; i <= rowCount(); i++) {
            for (int j = 0; j < columnCount(); j++) {
                String value = getCellData(i, j);
                data[i-1][j] = value;
            }
        }
        return data;
    }

    public static void excellSayfaAdiVerme(String sayfaAdi, String dosyaYolu) throws IOException {


               FileInputStream inputStream = new FileInputStream(new File(dosyaYolu));
               Workbook workbook = new XSSFWorkbook(inputStream);
               workbook.createSheet(sayfaAdi);
               FileOutputStream outputStream = new FileOutputStream(dosyaYolu);
               workbook.write(outputStream);
               workbook.close();
               outputStream.close();

    }
}
