#12 Fast testing system

Company:	External courses<br>
Company Location:	Ukraine, Kiev<br>
Duration:	01/06/2019 – 20/06/2019<br>
Description:	Student Quick Testing System. The student is registered by e-mail, his success is attached to him and he will receive messages about the result of tests. In the system there is a catalog of tests on topics, an authorized student can take tests. At the end of the test , form with errors will be displayed for student . All data on progress and courses are displayed on the Administrator page as a summary table for all Students.
Position:	Full-Stack developer<br>
Tools & Technologies:	IDE : Intellij IDEA<br>
WEB Server : Apache Tomcat 9<br>
Version Control System : Git<br>
Project builder : Apache Maven<br>
Database manage : MySQL workbench<br>
Backend programming language : Java 8.<br>
Frontend : CSS, HTML, JSTL, JSP, Bootstrap<br>
Testing : JUnit, Mockito<br>
Database connection : JDBC, DAO<br>
Web technology : Servlets , Filters , Sessions<br>
Logging : Log4j<br>
Connection pool<br>
<hr>
Participation	Project contains :<br>
- User role system : user , admin<br>
- Test catalog : catalog of test for passing<br>
- Validation off all input (backend)<br>
- i18n (En , Uk), l10n<br>
- implemented paging<br>
- implemented filtering<br>
- implementing sorting<br>
- realising according to SOLID;<br>
- Code covered by comments<br>
Project architecture (MVC) :<br>
Model :<br>
- Entities and DAO with services<br>
View:<br>
- JSP, HTML, JSTL<br>
Controller:<br>
- Servlet controller<br>
Used patterns :<br>
- Builder<br>
- Abstract Factory<br>
- Template Method<br>
- Command<br>
<hr>
Запуск :

1. Для запуска вам понадобятся jdk, git, maven.

2. Вставить URL в src\main\resources\application.properties 'jdbc:mysql://localhost:3306/spring'

3. В корневой папке проекта откройте терминал и введите команду (mvnw spring-boot:run)

4. Открыть браузер и перейти по ссылке http://localhost:8080/
