@echo off
:: If you already have a valid JAVA_HOME environment variable set, feel free to comment the below two lines
set path=allure\bin;%path%
allure generate --clean --output allure-results
pause
exit