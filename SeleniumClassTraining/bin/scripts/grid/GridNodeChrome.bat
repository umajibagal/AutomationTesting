c:
cd "C:\eclipse-workspace\SeleniumClassTraining\lib"
java ^
-Dwebdriver.chrome.driver="C:\eclipse-workspace\SeleniumClassTraining\test\resources\chromedriver.exe" ^
-jar selenium-server-standalone-3.141.59.jar -role node ^
-hub http://192.168.0.100:4444/grid/register ^
-browser "browserName=chrome,maxInstances=3" ^
-maxSession 3
pause