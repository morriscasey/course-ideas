package com.teamtreehouse.courses;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

/**
 * Created by monkeyhome1 on 3/11/17.
 */
public class Main {
    public static void main(String[] args){
        get("/", (req, res)-> {
           return new ModelAndView(null, "index.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
