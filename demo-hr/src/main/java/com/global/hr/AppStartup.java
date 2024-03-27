package com.global.hr;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartup implements CommandLineRunner, ApplicationRunner {
    @Override
    public void run(String...args)throws Exception{
        System.out.println("amr osama mohamed hassan");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("run from application runner");
    }
}
