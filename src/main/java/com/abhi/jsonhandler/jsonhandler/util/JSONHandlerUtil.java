package com.abhi.jsonhandler.jsonhandler.util;

import com.abhi.jsonhandler.jsonhandler.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;

public class JSONHandlerUtil {

    private static Logger logger;
    /**
     * Contains the list of userDto objects
     */
    private static List<UserDto> userDtoList;
    /**
     * json file as File object
     */
    private static File file;


    public JSONHandlerUtil(String fileName) throws URISyntaxException {
        userDtoList = new ArrayList<>();
        file = getFile(fileName);
        logger = Logger.getLogger(JSONHandlerUtil.class.getCanonicalName());
    }

    /**
     * Reads the json file and converts it into UserDto objects. Adds these UserDto objects into an ArrayList.
     * @return void
     */
    public static void loadJsonAsObject() throws IOException {
        userDtoList.addAll(Arrays.asList(getObjectMapper().readValue(file, UserDto[].class)));
    }

    /**
     * Prints the current state of userDto Objects ArrayList into console.
     * @return void
     */
    public static void jsonObjectPrinter() {
        logger.info("\no/p json=> \n"+userDtoList);
    }

    /**
     * Sorts the userDto ArrayList in accordance with the comparator input provided.
     * @param sortBy - a comparator with appropriate sort type.
     * @return void
     */
    public static void jsonSorter(Comparator<UserDto> sortBy){
        userDtoList.sort(sortBy);
    }

    /**
     * Loads the json file with the specified file name and returns a file object for the same.
     * @param fileName - The name of the json file.
     * @return File
     */
    private static File getFile(String fileName) throws URISyntaxException {
        return Paths.get(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource(fileName)).toURI()).toFile();
    }

    /**
     * Loads the json file with the specified file name and returns a file object for the same.
     * @return ObjectMapper
     */
    private static ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }
}
