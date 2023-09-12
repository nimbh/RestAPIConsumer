package org.example;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Consumer {
    public static void main(String[] args) {

        String url_get = "https://reqres.in/api/users/2";

        RestTemplate rt = new RestTemplate();

        //получение данных с API
        //GET
        String response_get = rt.getForObject(url_get, String.class);
        System.out.println(response_get);

        System.out.println();

        //POST
        //Задаем значения, которые отправляем в post request
        Map<String, String> jsonToSend = new HashMap<>();
        jsonToSend.put("name", "TODD");
        jsonToSend.put("job", "Artist");

        //помещаем в ссылку
        HttpEntity<Map<String, String>> request_post = new HttpEntity<>(jsonToSend);

        //ссылк на сам post request в API
        String url_post = "https://reqres.in/api/users";

        //отправляем
        String response_post = rt.postForObject(url_post, request_post, String.class);

        System.out.println(response_post);//результат отправленного запроса на создание нового человека
    }
}
