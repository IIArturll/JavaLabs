<h1>Labs:</h1>
<h2>Variant 30:</h2>
<h3>Сервис должен принимать два параметра (делимое и делитель) и вернуть результат деления предоставленных
параметров (частное, остаток) </h3>

<h2><a href="https://github.com/IIArturll/JavaLabs/tree/8d242be19804fe07524d62b132940a83ac8337d5">
lab1( Intro ):</a></h2>
<h4>
  <ul>
    <li>1. Создать и запустить локально простой веб/REST сервис, используя любой открытый (например, в открытом доступе 
      в сети  интернет) пример с использованием Java stack: Spring (Spring Boot) / maven / gradle / Jersey / Spring MVC.</li> 
    <li>Добавить GET ендпоинт, принимающий входные параметры в качестве queryParams в URL и возвращающий результат в виде 
      JSON согласно варианту.</li>
  </ul>
</h4>
 
<h2><a href="https://github.com/IIArturll/JavaLabs/tree/ed32e1e683eb8213229dac74970bfb9c6c88db3e">
lab2( Error logging/handling )</a></h2>
<h4>
    <ul>
        <li> Добавить валидацию входных параметров с возвращением 400 ошибки</li>
        <li> Добавить обработку внутренних unchecked ошибок с возвратом 500 ошибки</li> 
        <li> Добавить логирование действий и ошибок</li> 
        <li> Написать unit test</li>
    </ul>
</h4> 

<h2><a href="https://github.com/IIArturll/JavaLabs/tree/bd6af0f8665093dbffdc116e2e5996ac6950dfab">
lab3( Collections intro, project structure )</a></h2>
<h4>    
    <ul>
        <li>Добавить простейший кэш в виде in-memory Map для сервиса. Map должна содержаться в отдельном бине/классе, 
            который должен добавляться в основной сервис с помощью dependency injection механизм Spring</li>
    </ul>
</h4>

<h2><a href="https://github.com/IIArturll/JavaLabs/tree/96d8438bc0cb44917f2a664ab1d777a5fdc4a511">
lab4( Concurrency )</a></h2>
<h4>
    <ul>
        <li> Добавить сервис для подсчёта обращений к основному сервису. Счётчик должен быть реализован в виде 
        отдельного класса, доступ к которому должен быть синхронизирован.</li> 
        <li> Используя jmeter/postman или любые другие средвста сконфигурировать нагрузочный тест и убедиться, что 
        счётчик обращений работает правильно при большой нагрузке.</li> 
   </ul>
</h4>

<h2><a href="https://github.com/IIArturll/JavaLabs/tree/c69c6a34a22ea1980475471ad39e84b227c040f6">
lab5( Functional programming with Java 8 )</a></h2>
<h4>
    <ul>
        <li> Преобразовать исходный сервис для работы со списком параметров для bulk операций используя Java 8лямбда
        выражения.</li> 
        <li> Добавить POST метод для вызова bulk операции и передачи списка параметров в виде JSON</li> 
    </ul>
</h4>

<h2><a href="https://github.com/IIArturll/JavaLabs/tree/944c76ab5ef78f78143789d31ddb488422dd2b96">
lab6( Functional filtering and mapping )</a></h2>
<h4>
    <ul>
        <li>Добавить аггрегирующий функционал (подсчёт макс, мин, средних значений) для входных параметров и результатов 
        с использованием Java 8 map/filters функций. Расширить результат POST соотвественно.</li> 
    </ul>
</h4>

<h2><a href="https://github.com/IIArturll/JavaLabs/tree/09a316ddb5656593e2d37fdf96434ec1f47f906b">
lab7( Data persistence )</a></h2>
<h4>
    <ul>
        <li>Добавить возможность сохранения всех результатов вычислений в базе данных или файле, используя стандартные
        persistence фреймворки Java (Spring Data/Hibernate/MyBatis)</li>
    </ul>
</h4>

<h2><a href="https://github.com/IIArturll/JavaLabs/tree/23c0577c494ea5ef9989dc3cf69653e94d59b546">
lab8( Asynchronous calls )</h2>
<h4>
    <ul>
        <li> Добавить возможность асинхронного вызова сервиса используя future, возвращать статус вызова REST сервиса
        не дожидаясь результатов подсчётов. Результаты подсчётов должны быть представлены в БД по предопределённой ID</li> 
    </ul>
</h4>
