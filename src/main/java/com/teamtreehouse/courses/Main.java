package com.teamtreehouse.courses;

import com.teamtreehouse.courses.model.CourseIdeaDAO;
import com.teamtreehouse.courses.model.SimpleCourseIdeaDAO;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

/**
 * Created by monkeyhome1 on 3/11/17.
 */
public class Main {
    public static void main(String[] args){
        // Simple IdeaDAO is a prototype and will not be used for live environment
        CourseIdeaDAO dao = new SimpleCourseIdeaDAO();

        get("/", (req, res)-> {
            Map<String, String> model = new HashMap<>();
            model.put("username", req.cookie("username"));
           return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/sign-in", (req,res)->{
            Map<String, String> model = new HashMap<>();
            String username = req.queryParams("username");
            res.cookie("username",username);

            model.put("username", username);
            return new ModelAndView(model, "sign-in.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
