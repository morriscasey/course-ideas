package com.teamtreehouse.courses;

import static spark.Spark.*;

/**
 * Created by monkeyhome1 on 3/11/17.
 */
public class Main {
    public static void main(String[] args){

        get("/hello", (req, res) -> "Hello World");
        get("/", (req, res)-> "Hello");
    }
}
