package testNG_Tests.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {
    @DataProvider (name= "search")
    public static Object[][] search() {
        return new Object[][]{{"ardahan"}, {"gazyağı"}, {"semaver"}};
    }
    @DataProvider
    public static Object[][] login() {
        return new Object[][]{{"hakan", "123423423"}, {"sevcan", "3243DFGdfg"}, {"erbil", "dfg345DF."}};
    }

    @DataProvider
    public static Object[][] loginPhp() {
        return new Object[][]{{"hakan", "kara", "5555555555", "hakan@gmial.com","34kdfg" },
                {"ayşe", "kara", "5555555555", "aaaaa@gmial.com","A34kdfg" },
                {"hatice", "kara", "5555555555", "hatce@gmial.com","ADFGdfkgdlı9g" }};
    }
    @DataProvider
    public static Object[][] excel() {
        //excel dosya yolunu veririm
        String path= "src/test/resources/userData.xlsx";

        //okunacak excel deki sheet ismini veririm
        String sheet= "positive";

        //ExcelUtils classtan obje oluştur
        ExcelUtils excelUtils=new ExcelUtils(path,sheet);

        //return için excelUtils.getDataArrayWithoutFirstRow() metodu kullanılır.
        return excelUtils.getDataArrayWithoutFirstRow();

    }

}
