package com.abhi.jsonhandler.jsonhandler;

import com.abhi.jsonhandler.jsonhandler.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

@SpringBootApplication
public class JsonHandlerApplication {

    public static void main(String[] args) throws URISyntaxException, IOException {
        SpringApplication.run(JsonHandlerApplication.class, args);
        File jsonFile = getFile("sample.json");
        jsonObjectPrinter(jsonReader(jsonFile));
        jsonSorter(jsonReader(jsonFile));
        //System.out.println("O/P JSON =>\n"+jsonSorter(jsonReader(jsonFile)));
    }


    private static File getFile(String fileName) throws URISyntaxException {
        return Paths.get(Thread.currentThread().getContextClassLoader().getResource(fileName).toURI()).toFile();
    }

    public static List<UserDto> jsonReader(File file) throws IOException {
        ArrayList<UserDto> userDtoList = new ArrayList<>();
        UserDto[] userDtos =  getObjectMapper().readValue(file, UserDto[].class);
        userDtoList.addAll(Arrays.asList(userDtos));
        return userDtoList;
    }


    private static void jsonObjectPrinter(List<UserDto> userDtoList) throws JsonProcessingException {
        System.out.println("i/p json=> \n"+userDtoList);
    }

    public static void jsonSorter(List<UserDto> jsonDtoList) throws JsonProcessingException {
        Collections.sort(jsonDtoList, new SortByUsername());
        jsonObjectPrinter(jsonDtoList);
    }

    private static ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }
}


