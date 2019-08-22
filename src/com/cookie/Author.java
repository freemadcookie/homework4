package com.cookie;

public class Author {
    private String authorName;
    private String authorAddress;

    public String getName() {
        return authorName;
    }

    public String getAddress() {
        return authorAddress;
    }

    public void setName(String name) {
        authorName = name;
    }

    public void setAddress(String address) {
        authorAddress = address;
    }
}
