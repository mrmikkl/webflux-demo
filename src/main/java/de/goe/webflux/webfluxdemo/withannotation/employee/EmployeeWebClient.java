package de.goe.webflux.webfluxdemo.withannotation.employee;

import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class EmployeeWebClient
{
    WebClient client = WebClient.create("http://localhost:8080");

    public Mono<Employee> employee(final String pId)
    {
        return client.get()
                .uri("/employees/{id}", pId)
                .retrieve()
                .bodyToMono(Employee.class);
    }

    public Flux<Employee> employees()
    {
        return client.get()
                .uri("/employees")
                .retrieve()
                .bodyToFlux(Employee.class);
    }
}
