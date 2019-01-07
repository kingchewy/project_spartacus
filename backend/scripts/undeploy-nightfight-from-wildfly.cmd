@echo off

cd ..
call mvn clean install -P undeploy-nightfight-from-wildfly

pause