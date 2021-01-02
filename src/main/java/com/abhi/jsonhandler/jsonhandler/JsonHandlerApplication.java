package com.abhi.jsonhandler.jsonhandler;

import com.abhi.jsonhandler.jsonhandler.util.JSONHandlerUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
public class JsonHandlerApplication {



    public static void main(String[] args) throws URISyntaxException, IOException {
        SpringApplication.run(JsonHandlerApplication.class, args);
        JSONHandlerUtil jsonHandlerUtil = new JSONHandlerUtil("sample.json");
        jsonHandlerUtil.loadJsonAsObject();
        jsonHandlerUtil.jsonObjectPrinter();
        jsonHandlerUtil.jsonSorter(new SortByUsername());
        JSONHandlerUtil.jsonObjectPrinter();
    }

}


