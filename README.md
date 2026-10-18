# Mobile Framework

Java 21 mobile automation project using Maven, TestNG, Appium, and Android.

## GitHub Actions

The `Mobile CI` workflow runs for pushes, pull requests, and manual dispatches. It:

1. Compiles and packages the project with Maven.
2. Starts an Android emulator and Appium server.
3. Runs `basicTests.NotInstalledApp` against `src/main/Apps/app-qa-release.apk`.
4. Uploads Surefire reports and the Appium log when the Android test job completes.

Run the same build locally with:

```shell
mvn --batch-mode --no-transfer-progress verify
```
