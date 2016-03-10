@echo off  
set localdir=%~dp0  
call mvn -DskipTest=true clean install 
pause  