package de.goe.webflux.webfluxdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.goe.webflux.webfluxdemo.functional.greeting.GreetingWebClient;
import de.goe.webflux.webfluxdemo.withannotation.employee.Employee;
import de.goe.webflux.webfluxdemo.withannotation.employee.EmployeeWebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class WebfluxDemoApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(WebfluxDemoApplication.class, args);

//        final GreetingWebClient client = new GreetingWebClient();
//        System.out.println(client.getResult());

        final EmployeeWebClient client = new EmployeeWebClient();
        final Mono<Employee> employeeMono = client.employee("1");
        employeeMono.subscribe(System.out::println);

        final Flux<Employee> employeesFlux = client.employees();
        employeesFlux.subscribe(System.out::println);
    }
}
