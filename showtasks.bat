call runcrud.bat
if "%ERRORLEVEL%" == "0" goto chromeLauncher
echo.
echo runcrud.bat has errors - breaking work
goto fail

:chromeLauncher
echo Google Chrome launched
start chrome  http://localhost:8009/crud/tasks/
if "%ERRORLEVEL%" == "0" goto end

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.