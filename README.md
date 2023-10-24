## Проект-пример Спринта 4

Пример UI автотестов для [Сервиса QA Scooter](https://qa-scooter.praktikum-services.ru/).
Использует JUnit 4 и Selenium в качестве основных зависимостей.

`OrderStatus` - автотесты, написанные с использованием Before/After конструкций.

`OrderStatusWithRule` - автотесты, написанные с помощью Rule (факультативно).

`Utils.randomString` - пример самописной функции для генерации случайной строки.
Вместо нее можно использовать любую понравившуюся библиотеку для генерации случайных значений.

Опции при создании `WebDriver`:
```
ChromeOptions options = new ChromeOptions();
options.addArguments("--remote-allow-origins=*");
```
требуются из-за проблем с подключением к Хрому в новых версиях selenium/chromedriver.
