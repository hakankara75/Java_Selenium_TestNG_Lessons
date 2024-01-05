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
Birden fazla testin aynı anda birden fazla browser açılarak koşulmasıdır.
Böylelik test run süresi kısalmış.

TestNG frameworkunde Driver class singleton pattern olduğundan dolayı paralel testte kullanılamaz
bu nedenle Junit deki gibi her bir test metodu içinde driver objesi oluşturulur

paralel test class seviyesinde yapılacaksa package seçilip xml dosyası açılır
paralel test test seviyesinde yapılacaksa classlar seçilip xml dosyası açılır

 */

}
