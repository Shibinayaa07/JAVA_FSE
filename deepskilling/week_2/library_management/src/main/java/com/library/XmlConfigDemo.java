package com.library;

import com.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfigDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService setterService = context.getBean("bookServiceSetter", BookService.class);
        BookService constructorService = context.getBean("bookServiceConstructor", BookService.class);

        setterService.addBook("Spring in Action");
        System.out.println("Setter injection books: " + setterService.getAllBooks());
        System.out.println("Constructor injection books: " + constructorService.getAllBooks());

        context.close();
    }
}
