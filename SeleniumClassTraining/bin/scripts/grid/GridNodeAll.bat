c:
cd "C:\temp\Jul19weekdays\webdrivertraining\lib"
java ^
-Dwebdriver.gecko.driver="C:\temp\Jul19weekdays\webdrivertraining\test\resources\geckodriver64bit.exe" ^
-Dwebdriver.chrome.driver="C:\temp\Jul19weekdays\webdrivertraining\test\resources\chromedriver.exe" ^
-Dwebdriver.ie.driver="C:\temp\Jul19weekdays\webdrivertraining\test\resources\IEDriverServer.exe" ^
-jar selenium-server-standalone-3.141.59.jar -role node ^
-hub http://192.168.0.103:4444/grid/register ^
-browser "browserName=firefox,maxInstances=1,platform=Windows" ^
-browser "browserName=chrome,maxInstances=9" ^
-browser "browserName=internet explorer,maxInstances=5" ^
-browser "browserName=safari,maxInstances=150" ^
-maxSession 20
pause