@echo off
set currentDirectory=%cd%

tasklist /FI "IMAGENAME eq tomcat8.exe" | find /I /N "tomcat8.exe" > NUL
if "%ERRORLEVEL%"=="0" net stop tomcat8

sqlplus / as sysdba @%currentDirectory%\userScript.sql 
exit|sqlplus team1test/team1test @%currentDirectory%\dbScript.sql
exit|sqlplus team1test/team1test @%currentDirectory%\insertScript.sql

net start tomcat8

mvn clean install
pause