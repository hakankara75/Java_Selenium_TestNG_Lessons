package testNG_Tests.test;

public class Selenium_TestNG_26XML_File_ParalelTest_Test {
    /*
    xml file istenen testlerin koşulmasını sağlar.
    metot, class, package veya bunların birden fazlası olabilir
    koşturmak istemediğiniz testleri hariç tutabilirsiniz
     */
/*
Belirli grup oluşturup koşturmak için testlerimiz arasından seçim yaparız.
belirli classlar package altındaki classlarda seçim yapacağız.
önce xml dosyası oluştururuz.
https://testng.org/doc/documentation-main.html#testng-xml sitesine gideriz
"You can specify package names instead of class names:" kısmındaki kodları
"You can also specify groups and methods to be included and excluded:" kısmındaki kodları
bir araya getireceğim.

PARALLEL TEST
Birden fazla browser açarak testleri run etmeye denir.
Zamanda tasarruf için parallel test koşulur.
1- Class seviyesinde koşmak için package seçilir.
xml dosyası oluşturulur.
xml dosyası içine ayar yapılır.

2- methods seviyesinde koşmak için package seçilir.
xml dosyası oluşturulur.
xml dosyası içine ayar yapılır.

3- tests seviyesinde koşmak için koşulacak classlar toplu olarak seçilir.
üzerinde sağ klik yapıp xml dosyası oluşturulur.
xml dosyası içine ayar yapılır.

4- koşulacak testler junitdeki gibi kendi içinde driver objesi oluşturulur.
çünkü testng Driver class'tan method import ederek kullanır.
Driver class da singelton pattern olduğu için ilk açılan browser driveri kullanır.
diğer açılan 3 browser kullanamayacağı için hata verir.
 */

}
