package com.teamtreehouse.courses;

import com.teamtreehouse.courses.model.CourseIdea;
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
        staticFileLocation("/public");

        // Simple IdeaDAO is a prototype and will not be used for live environment
        CourseIdeaDAO dao = new SimpleCourseIdeaDAO();

        get("/", (req, res)-> {
            Map<String, String> model = new HashMap<>();
            model.put("username", req.cookie("username"));
           return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/ideas", (req,res)->{
            Map<String, Object> model = new HashMap<>();
            model.put("ideas", dao.findAll());
            return new ModelAndView(model, "ideas.hbs");
        }, new HandlebarsTemplateEngine());
        post("/sign-in", (req,res)->{
            Map<String, String> model = new HashMap<>();
            String username = req.queryParams("username");
            res.cookie("username",username);

            model.put("username", username);
            return new ModelAndView(model, "sign-in.hbs");
        }, new HandlebarsTemplateEngine());

        post("/ideas", (req, res)->{
          String title = req.queryParams("title");
          // TODO:jcm - This username tied to the cookie. need to change.
          CourseIdea courseIdea = new CourseIdea(title, req.cookie("username"));
          dao.add(courseIdea);
          res.redirect("/ideas");
          return null;
        });
    }
}
