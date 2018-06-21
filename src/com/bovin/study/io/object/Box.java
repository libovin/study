package com.bovin.study.io.object;

import java.io.Serializable;

/**
 * Box
 *
 * @author Bovin
 * Create on 2018/6/21
 */
public class Box implements Serializable {
    private int width;
    private int height;
    private String name;

    public Box(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "["+name+": ("+width+", "+height+") ]";
    }
}

