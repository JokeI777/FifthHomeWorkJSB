Домашнее задание по теме валидация:   
Реализовать приложение  в котором выполняется валидация (проверка) входных данных для заполнения структуры Person. Входные данные поступают в приложение либо через стандартный ввод (через ввод в командной строке), либо посредством http запросов (т.е. нужно создавать контроллер). То есть пользователь вводит дату рождения, имя, фамилию, пол. Далее идет заполнение Person, после чего происходит валидация.   
Правила проверки:   
- дата рождения должна быть меньше текущей   
- дата рождения должна быть больше чем текущая дата - 100 лет   
- дата рождения обязательна к заполнению   
- максимальная длина имени 125 символов   
- имя обязательно к заполнению   
- максимальная длина фамилии 150 символов   
- фамилия не обязательная к заполнению   
- пол обязательно для заполнения   
Ошибки валидации можно выводить как в конце заполнения так и по мере ввода данных.   
   
Структура Person:   
```
class Person {   
   LocalDate birthday; // дата рождения    
   String name; // имя   
   String sname; // фамилия   
   Sex sex; // пол   
}   
    
enum Sex {   
   MALE,   
   FEMALE   
}   
```
Пример считывание данных из командной строки (только для этого задания. В реальных условиях этого делать не нужно так как spring boot не предназначен для такого):   
```
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
 
   public static void main(String[] args) {
 
       var app = new SpringApplication(DemoApplication.class);
       app.run(args);
   }
 
   @Override
   public void run(String... args) {
 
       var in = new Scanner(System.in);
 
       System.out.println("What is your name?");
       String name = in.next();
       System.out.println("Hello " + name + " welcome to spring boot" );
   }
}
```
    
Success post request:   
![Success_POST](https://github.com/JokeI777/FifthHomeWorkJSB/blob/master/HMV5JSB_POST.png)
