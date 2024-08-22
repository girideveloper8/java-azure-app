package com.demo.controller;

import com.demo.model.Cast;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/strangerthings/v1/")
public class OhioController {

    List<Cast> list = List.of(new Cast("Millie Bobby Brown", "Eleven"), new Cast("Finn Wolfhard", "Mike wheealer"), new Cast("Natalia Dyer", "Nancy"));


    @GetMapping("/")
    public String  welcome() {

        return "Welcome to the Stranger Things series";

    }

    @GetMapping("/getCastDetails")
    public List<Cast> getCastofstrangerthings() {

        return list;

    }
}
