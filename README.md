# Number Converter 

This simple REST api in MVC design using spring framework.
There is one functionality: converting numbers in one notation to another.<br>
You can pass some number in (currently only) decimal notation, select desired notation which the number will be converted to and press button **convert**.<br>
In case of some error; incorrect format of passed number or overflow there will appear appropriate information on screen.

### There is defined set of handled notations:
  1. decimal
  2. hexadecimal
  3. binary
  4. octal
  5. roman [ad.](#ad1)
<!-- ![](https://render.githubusercontent.com/render/math?math=e%5E%7Bi%20%5Cpi%7D%20%3D%20-1&mode=inline) -->

  ... might be more in future versions
  
### Configuration
With default configuration in __**application.properties**__ api will be running on __localhost:8080__ or __localhost:8080/converter__
  
### Used technologies/dependencies:
  1. java 1.8.0_302
  2. maven 3.5.4
  3. spring boot 2.2.2
  4. lombok 1.18.20
 
 ## How to run application
 
 It can be done using **spring-boot-starter-web** dependency
 ```shell
 mvn spring-boot:run
 ```
 
 In order to get **jar** package execute
 ```shell
 mvn package
 ```
 and in order to run api execute
 ```shell
 java -jar target/numberConverterREST-1.0.1.jar
 ```
 or
 ```shell
 java -cp target/numberConverterREST-1.0.1.jar org.springframework.boot.loader.JarLauncher
 ```
 if version is changed there will be necessity to use other version (in name of jar file) in commands above.
 
 
 <br><br>
 #### Annotations
 <a id="ad1">ad.1</a>
 currently roman characters corresponding to numbers over thousand are not handled, it means **V, X, L, C, D, M** with overline wich means multiplying by thousand, e.g. **V** with overline means 5000 when signle **V** means 5; so converting big numbers to roman may reults in e.g. MMMMMMMMMMMMMMMMMCXIX;

 
