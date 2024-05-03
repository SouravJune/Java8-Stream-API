package com.souravjune.programs;

import java.util.*;
import java.util.stream.Collectors;

/** Question: Java 8 Program to Convert List to Map Using Stream API */
public class ConvertListToMap {

    public static void main(String[] args) {

        List<String> items = List.of("apple", "banana", "cherry");

        /* This is converting a list of strings into a map where each string is a key and its length is the value. */
        Map<String, Integer> itemMap = items.stream()
                .collect(Collectors.toMap(item -> item, String::length));

        System.out.println("***** List to Map: *****");
        itemMap.forEach((key, value) -> System.out.println(key + ": " + value));

        List<User> userList = Arrays.asList(
                new User("Xeon", "192.168.1.1"),
                new User("Dave", "192.168.1.2"),
                new User("Xeon", "192.168.1.3"),
                new User("Dave", "192.168.1.4"),
                new User("Bob", "192.168.1.5"),
                new User("Fuse", "192.168.1.6")
        );

        /* This is converting a list of User objects into a map.
            If there are duplicate keys (usernames), it concatenates the old and new values (IP addresses). */
        Map<String, String> collect = userList.stream()
                .collect(Collectors.toMap(
                        User::getName, User::getIpAddress,
                        (oldValue, newValue) -> oldValue + ", " + newValue));

        System.out.println("***** List to Map: *****");
        collect.forEach((key, value) -> System.out.println(key + ": " + value));

        /* This is similar to the previous one, but it preserves the insertion order by using a LinkedHashMap. */
        Map<String, String> collect1 = userList.stream()
                .collect(Collectors.toMap(
                        User::getName, User::getIpAddress,
                        (oldValue, newValue) -> oldValue + ", " + newValue,
                        LinkedHashMap::new));

        System.out.println("***** List to Map: *****");
        collect1.forEach((key, value) -> System.out.println(key + ": " + value));

        /* If there are duplicate keys (usernames), it concatenates the old and new values (IP addresses).
           But it sorts the keys (usernames) by using a TreeMap. */
        Map<String, String> collect2 = userList.stream()
                .collect(Collectors.toMap(
                        User::getName, User::getIpAddress,
                        (oldValue, newValue) -> oldValue + ", " + newValue,
                        TreeMap::new));

        System.out.println("***** List to Map: *****");
        collect2.forEach((key, value) -> System.out.println(key + ": " + value));

    }
}

class User{

    private String name;
    private String ipAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public User(String name, String ipAddress) {
        this.name = name;
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}

