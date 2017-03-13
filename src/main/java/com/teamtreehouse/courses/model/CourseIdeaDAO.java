package com.teamtreehouse.courses.model;

import java.util.List;

/**
 * Created by Casey Morris on 3/13/17.
 */
public interface CourseIdeaDAO {
    boolean add(CourseIdea idea);

    List<CourseIdea> findAll();
}
