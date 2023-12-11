package testNG_Tests.test;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Selenium_TestNG_18_Excel_Test {

    @Test
    public void excel() throws IOException {

        // FileInputStream
        FileInputStream fileInputStream=new FileInputStream("src/test/java/testNG_Tests/resources/isimler.xlsx");

        //fileInputStream ile dosyayi aciyoruz
        Workbook workbook= WorkbookFactory.create(fileInputStream);

        //sheet ile dosyada verilen sayfa acilir
        Sheet sheet=workbook.getSheet("isimler");

        //row ile verilen satira gidilir
        Row row=sheet.getRow(0); //0. satir header yani baslik

        Cell cell=row.getCell(0);
        System.out.println("cell = " + cell);

        Cell cell1=row.getCell(1);
        System.out.println("cell = " + cell1);

    }

    @Test
    public void assertExcelData() throws IOException {
        //3. satir 1. sutundaki verinin "ela" oldugunu dogrula
        FileInputStream fileInputStream=new FileInputStream("src/test/java/testNG_Tests/resources/isimler.xlsx");
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sheet=workbook.getSheet("isimler");

        Row row=sheet.getRow(3);
        Cell cell=row.getCell(1);

        String expectedData= "ela";
        String actualData= String.valueOf(cell);

        assertEquals(expectedData, actualData);
    }

    @Test
    public void endOfTheRow() throws IOException { //veri olan son satir numarasini alacagiz bu testte

        //belgedeki toplam satir sayisini veren kodu yaz

        FileInputStream fileInputStream=new FileInputStream("src/test/java/testNG_Tests/resources/isimler.xlsx");
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sheet=workbook.getSheet("isimler");

        int totalRow= sheet.getLastRowNum(); //son satir numarasi alinir
        System.out.println("totalRow = " + totalRow);


    }

    @Test
    public void returnExcelToMap() throws IOException { //excel deki datalari map yapacagiz

        Map<String, String> adSoyad= new HashMap<>();

        FileInputStream fileInputStream=new FileInputStream("src/test/java/testNG_Tests/resources/isimler.xlsx");
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sheet=workbook.getSheet("isimler");

        int endRowNumber= sheet.getPhysicalNumberOfRows();
        System.out.println("endRowNumber = " + endRowNumber);

        String isim="";
        String soyisim="";

        for (int i = 1; i < endRowNumber; i++) {

            isim= sheet.getRow(i).getCell(0).toString();
            soyisim= sheet.getRow(i).getCell(1).toString();
            adSoyad.put(isim,soyisim);

        }

        System.out.println("adSoyad = " + adSoyad);
    }


    @Test
    public void writeToExcel() throws IOException {

        //excel dosyasinda yeni bir sayfa acip ad ve soyad kaydedin
        FileInputStream fileInputStream=new FileInputStream("src/test/java/testNG_Tests/resources/isimler.xlsx");
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sheet=workbook.createSheet("adSoyad"); //dosyada yeni sayfa acip ona isim verdim

        //header olusturdum
        Cell ad=sheet.createRow(0).createCell(0);
        ad.setCellValue("AD");

        //isimleri excel e kaydettim
        sheet.createRow(1).createCell(0).setCellValue("ilkay"); //1. satir 0. sutuna isim girildi
        sheet.createRow(2).createCell(0).setCellValue("orhan"); //2. satir 0. sutuna isim girildi
        sheet.createRow(3).createCell(0).setCellValue("orhan"); //2. satir 0. sutuna isim girildi

        //header olusturdum
        Cell soyad=sheet.getRow(0).createCell(1);
        soyad.setCellValue("SOYAD");

        //soyadlar excel e kaydettim
        sheet.getRow(1).createCell(1).setCellValue("abdulkadiroğlu"); //1. satir 0. sutuna isim girildi
        sheet.getRow(2).createCell(1).setCellValue("kiğılı"); //2. satir 0. sutuna isim girildi
        sheet.getRow(3).createCell(1).setCellValue("ahıskalı"); //2. satir 0. sutuna isim girildi


        FileOutputStream writeExcel=new FileOutputStream("src/test/java/testNG_Tests/resources/isimler.xlsx");
        workbook.write(writeExcel);

        //dosyayi islem bittikten sonra kapattik
        fileInputStream.close();
        writeExcel.close();
        workbook.close();






    }
}
