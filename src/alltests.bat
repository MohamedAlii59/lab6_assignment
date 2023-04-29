@echo off
javac *.java
java Main data.arxml
echo Successfully executed.
echo ======================
javac *.java
java Main data.arx
echo ======================
javac *.java
java Main em.arxml
echo ======================
pause