package com.abhi.jsonhandler.jsonhandler;

import com.abhi.jsonhandler.jsonhandler.dto.UserDto;

import java.util.Comparator;

public class SortByUsername implements Comparator<UserDto> {
    @Override
    public int compare(UserDto o1, UserDto o2) {
        return o2.getUsername().compareTo(o1.getUsername());
    }
}
