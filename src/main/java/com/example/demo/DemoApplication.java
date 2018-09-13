package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args){
        SpringApplication.run(DemoApplication.class , args);
    }


    public static class User {
        private List<String> names;
        private Integer id;

        @Deprecated
        public String getName(){
            return Optional.ofNullable(names).orElseGet(ArrayList::new).stream().findAny().orElse(null);
        }

        @Deprecated
        public void setName(String name){
            if (name == null)
                this.names = Collections.singletonList(name);
        }


        public List<String> getNames() {
            return names;
        }

        public void setNames(List<String> names){
            this.names = names;
        }

        public Integer getId(){
            return id;
        }

        public void setId(Integer id){
            this.id = id;
        }

    }

    @RequestMapping(value = "/hello" ,method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void hello(@RequestBody User user){
        System.out.println(user.toString());
    }
}
