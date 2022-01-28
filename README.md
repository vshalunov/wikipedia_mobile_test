# Проект по автоматизации тестирования UI для [Wikipedia](https://ru.wikipedia.org/wiki/)

## <img width="4%" title="Functional" src="images/logo/functional.png"> Покрытый функционал

### UI

- :white_check_mark: Отображение результатов поиска в приложении Wikipedia
- :white_check_mark: Отображение определенной страницы в приложении Wikipedia
- :white_check_mark: Проверка первых четырех экранов Getting Started
- 
## <img width="4%" title="Technologies" src="images/logo/technologies.png"> Технологический стек

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Allure TestOps" src="images/logo/Allure_TestOps.svg">
<img width="6%" title="Rest Assured" src="images/logo/Rest-Assured.svg">
<img width="6%" title="BrowserStack" src="images/logo/Browserstack.svg">
<img width="6%" title="Appium" src="images/logo/Appium.svg">
</p>

> В данном проекте автотесты написаны на <code>Java</code> с использованием фреймворка <code>Selenide</code> и <code>Appium</code> для UI проверок, и библиотеки <code>REST Assured</code> для отображения видео в отчете
>
> <code>JUnit 5</code> используется для модульного тестирования
>
> <code>Gradle</code> используется для автоматизированной сборки проекта
>
> <code>Jenkins</code> выполняет запуск тестов
>
> <code>BrowserStack</code> выполняет запуск приложения на удаленном мобильном устройстве
>
> <code>Allure Report</code> формирует отчет о запуске тестов
>
> Автотесты интегрируются с тест-менеджмент системой <code>Allure TestOps</code>

## <img width="4%" title="Jira" src="images/logo/ITerm2_v3_icon.png"> Запуск тестов из терминала

<details>
<summary>Подробнее</summary>

### :rocket: Запуск тестов

```
gradle clean ${TASK}
```

> <details>
> <summary>:exclamation: Для запуска тестов необходимы файлы, в которых прописаны определенные параметры: </summary>
> <details>
> <summary> <code>browserstack.properties</code> </summary>
>
> + <code>userName</code> и <code>accessKey</code> – расположены в настройках <code>BrowserStack</code> для <code>App Automate</code>
> + <code>appUrl</code> – ссылка на тестируемое приложение
> + <code>deviceName</code> – наименование мобильного устройства, на котором будут запускаться тесты
> + <code>osVersion</code> – версия операционной системы мобильного устройства
> + <code>remoteURL</code> – URL удаленного сервера, на котором будут запускаться тесты 
> </details>
>
> <details>
> <summary> <code>local.properties</code> </summary>
>
> + <code>deviceName</code> – наименование мобильного устройства, на котором будут запускаться тесты
> + <code>platformName</code> – имя платформы, на которой будут запускаться тесты
> + <code>version</code> – версия операционной системы мобильного устройства
> + <code>locale</code> – локализация приложения (<code>en</code>,<code>ru</code> и т.д.)
> + <code>language</code> – язык приложения (<code>en</code>,<code>ru</code> и т.д.)
> + <code>appPackage</code> – идентификатор пакета приложения
> + <code>appActivity</code> – название основной активности приложения
> + <code>app</code> – путь до тестируемого приложения
> + <code>remoteURL</code> – URL удаленного сервера, на котором будут запускаться тесты
> </details>
>
> <details>
> <summary> <code>realDevice.properties</code> </summary>
>
> + <code>deviceName</code> – наименование мобильного устройства, на котором будут запускаться тесты
> + <code>platformName</code> – имя платформы, на которой будут запускаться тесты
> + <code>version</code> – версия операционной системы мобильного устройства
> + <code>locale</code> – локализация приложения (<code>en</code>,<code>ru</code> и т.д.)
> + <code>language</code> – язык приложения (<code>en</code>,<code>ru</code> и т.д.)
> + <code>appPackage</code> – идентификатор пакета приложения
> + <code>appActivity</code> – название основной активности приложения
> + <code>app</code> – путь до тестируемого приложения
> + <code>remoteURL</code> – URL удаленного сервера, на котором будут запускаться тесты
> </details>
>
> <details>
> <summary> <code>selenoid.properties</code> </summary>
>
> + <code>deviceName</code> – наименование мобильного устройства, на котором будут запускаться тесты
> + <code>platformName</code> – имя платформы, на которой будут запускаться тесты
> + <code>version</code> – версия операционной системы мобильного устройства
> + <code>locale</code> – локализация приложения (<code>en</code>,<code>ru</code> и т.д.)
> + <code>language</code> – язык приложения (<code>en</code>,<code>ru</code> и т.д.)
> + <code>appPackage</code> – идентификатор пакета приложения
> + <code>appActivity</code> – название основной активности приложения
> + <code>appURL</code> – ссылка на тестируемое приложение
> + <code>selenoidURL</code> – URL удаленного сервера, на котором будут запускаться тесты
> + <code>videoStorageURL</code> – адрес хранилища видео выполненных тестов
> </details>
>
> </details>

### :rocket: Параметры сборки

> <details>
> <summary><code>TASK</code> - список тестов, сгруппированных по параметру тега. В зависимости от выбранного параметра, будут запускаться определенные группы тестов</summary>
>
> + <code>browserstack</code> - запуск тестов с тегом <code>browserstack</code> на платформе <code>BrowserStack</code>
> + <code>selenoid</code> - запуск тестов с тегом <code>selenoid</code> на удаленном сервере <code>Selenoid</code>
> + <code>real</code> - запуск приложения на реальном устройстве при его подключении через <code>USB</code>
> + <code>local</code> - запуск приложения на локальном эмуляторе мобильного Android-устройства в <code>Android Studio IDE</code>
> </details>

</details>

## <img width="4%" title="Allure Report" src="images/logo/Allure_Report.svg"> Формирование отчета Allure

<details>
<summary>Подробнее</summary>

> <details>
> <summary>:exclamation:</summary>
>
> + Предварительно необходимо установить _Allure_
> </details>

```
allure serve build/allure-results
```

</details>

## <img width="4%" title="Jenkins" src="images/logo/Jenkins.svg"> Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/zlwqa-wikipedia_mobile_test/)

<details>
<summary>Подробнее</summary>

### :triangular_flag_on_post:     Для запуска тестов в Jenkins необходимо выполнить следующие шаги:

1. Открыть сборку [Jenkins](https://jenkins.autotests.cloud/job/zlwqa-wikipedia_mobile_test/)
2. Нажать на таск <code>"Собрать с параметрами"</code>
3. Указать [значения параметров](#rocket-параметры-сборки)
4. Нажать на кнопку <code>"Собрать"</code>

<p align="center">
<img title="Jenkins parameters" src="images/screens/jenkins_parameters.png">
</p>

### :triangular_flag_on_post: Для формирования отчета о прохождении тестов в Allure Report необходимо выполнить следующий шаг:

5. После выполнения сборки нажать на любую ссылку/иконку <code>"Allure Report"</code>

<p>
<img title="Allure Report" src="images/screens/jenkins_allure_report.png">
</p>

</details>

## <img width="4%" title="Allure Report" src="images/logo/Allure_Report.svg"> Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/zlwqa-wikipedia_mobile_test/allure/)

<details>
<summary>Подробнее</summary>

> <code>Allure-framework</code> используется в качестве инструмента для построения отчетов о прогоне автотестов.
> Он позволяет получить информацию о ходе выполнения тестов, а также прикрепить скриншоты, логи и видео к формируемому отчету.
> Имеется возможность указать различные теги, приоритеты и прочую сопутствующую информацию для тестов.

### :dart: Главная страница Allure-отчета

<p align="center">
<img title="Allure Overview" src="images/screens/allure_overview.png">
</p>

### :dart: Информация о тестовом прогоне в графическом виде

<p align="center">
<img title="Allure Graphs" src="images/screens/allure_graphs.png">
</p>

### :dart: Группировка тестов по проверяемому функционалу

<p align="center">
<img title="Allure Behaviors" src="images/screens/allure_behaviors.png">
</p>

</details>

## <img width="4%" title="Allure TestOps" src="images/logo/Allure_TestOps.svg"> Интеграция тестов c тест-менеджмент системой [Allure TestOps](https://allure.autotests.cloud/project/936/dashboards)

<details>
<summary>Подробнее</summary>

> <code>Allure TestOps</code> - это платформа управления качеством программного обеспечения, объединяющая автоматическое и ручное тестирование, которая позволяет управлять всем, что связано с тестированием, в одном месте.

### :test_tube:     Основной дашборд

<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/allure_overview_dashboard.png">
</p>

### :test_tube:     Запуски тестов

<p align="center">
<img title="Allure Launches" src="images/screens/allure_launches.png">
</p>

### :test_tube:     Результаты запуска тестов

<p align="center">
<img title="Allure Results" src="images/screens/allure_results.png">
</p>

### :test_tube: Сгруппированные тест-кейсы по проверяемому функционалу

<p align="center">
<img title="Allure Test Cases" src="images/screens/allure_testcases.png">
</p>

</details>

## <img width="4%" title="Browserstack" src="images/logo/Browserstack.svg"> Пример запуска теста в Browserstack

<details>
<summary>Подробнее</summary>

> Для каждого теста записывается и прилагается видео прогона.

<p align="center">
  <img title="Browserstack Video" src="images/gif/wikipedia_video.gif">
</p>

</details>

## <img width="4%" title="Selenoid" src="images/logo/Selenoid.svg"> Пример запуска теста в Selenoid

<details>
<summary>Подробнее</summary>

> Для каждого теста записывается и прилагается видео прогона.

<p align="center">
  <img title="Selenoid Video" src="images/gif/wikipedia_selenoid.gif">
</p>

</details>

<details>
<summary>:heartbeat: </summary>

### Спасибо за идею оформления [jjfhj](https://github.com/jjfhj)

</details>

