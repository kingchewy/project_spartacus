@echo off

cd ..
call mvn clean install -P deploy-nightfight-to-wildfly
start http://localhost:8080/news/

pause