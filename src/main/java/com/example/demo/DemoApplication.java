package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	static final Logger logger = LoggerFactory.getLogger("Data is valid?");

	public static void main(String[] args) {
		var app = new SpringApplication(DemoApplication.class);
		app.run(args);
	}

	@Override
	@Validated
	public void run(String[] args) {
		var in = new Scanner(System.in);
		System.out.println("What is your birthday?");
		var birthday = LocalDate.parse(in.next());
		System.out.println("What is your name?");
		String name = in.next();
		System.out.println("What is your surname?");
		String sname = in.next();
		System.out.println("What is your sex?");
		Sex sex = Sex.valueOf(in.next());
		Person person = new Person(birthday, name, sname, sex);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		var violations = validator.validate(person);
		if (violations.isEmpty()) {
			logger.info("YES");
		}
		for (ConstraintViolation<Person> violation : violations) {
			logger.info("NO");
		}
	}
}

