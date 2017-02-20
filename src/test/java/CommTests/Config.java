package CommTests;


public interface Config {

    final String baseUrl            = System.getProperty("baseUrl", "https://comsearch.dev.surgeforward.com/#/");
    final String browser            = System.getProperty("browser", "chrome");
    final String host               = System.getProperty("host","localhost");// or browserstack
    final String browserVersion     = System.getProperty("browserVersion","55");
    final String platform           = System.getProperty("platform","Windows");
    final String os_version         = System.getProperty("os_version","10");




//////////////////////////     SUPPORTED BROWSERS      \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//    ("browser", "chrome");  ("browserVersion","55");  ("browserVersion","54");
//    ("browser", "Firefox");  ("browserVersion","50");  ("browserVersion","49");
//    ("browser", "IE");  ("browserVersion","11");
//    ("browser", "Edge");  ("browserVersion","14"); ("browserVersion","13");
//
//////////////////////////     SUPPORTED OS's           \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//    ("platform","Windows"); ---> ("os_version","10"); ("os_version","8.1");  ("os_version","8");  ("os_version","7");  ("os_version","XP");
//    ("platform","OS X"); ---> ("os_version","El Capitan");  ("os_version","Yosemite");
//
//
//      IE10
//      IE11
//      Edge (latest 2 versions)
//      Chrome (latest 2 versions)
//      Firefox (latest 2 versions)
//      Safari (latest 2 versions)
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
