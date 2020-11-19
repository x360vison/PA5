//MIT License, modified
//Copyright (c) [2020] [Nicholas Lipari, PhD]
//
//Permission is hereby granted, free of charge, to any person obtaining a copy
//of this software and associated documentation files (the "Software"), to deal
//in the Software without restriction, including without limitation the rights
//to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//copies of the Software, and to permit persons to whom the Software is
//furnished to do so, subject to the following conditions:
//
//THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
//SOFTWARE.

package com.company;

import java.util.List;

public class Photograph {

    private int[] pixelArray;
    private String date = "01011900";

    public Photograph() {
        pixelArray = new int[100];
    }

    public Photograph(List<Photograph> memory, String date) {
        if(memory.size() >= 4)
            pixelArray = new int[memory.size()];
        else 
            pixelArray = new int[4];

        if(date.length() == 8)
            this.date = date;
        else 
            this.date = "01011900";
    }

    public Photograph(int num, String date) {

    }

    public void setPixel(int location, int value) {
        if(location >= 0 && location <= pixelArray.length && value >= 0 && value <= 255)
            pixelArray[location] = value;
    }

    public String getDate() {
        return date;
    }

    public int getSize() {
        return pixelArray.length;
    }

    public static Photograph createAll255sPhotograph() {
        Photograph p = new Photograph(100, "19000101");
        for(int i=0; i < p.pixelArray.length; i++) {
            p.pixelArray[i] = 255;
        }

        return p;
    }

    public static Photograph createMinimumPhotograph() {
        return new Photograph(4, "19000102");
    }

    public static Photograph create7x7Checkerboard() {
        Photograph p = new Photograph(49, "19000103");
        for(int i=0; i < p.pixelArray.length; i++) {
            if(i%2 == 0)
                p.pixelArray[i] = 255;
            else
                p.pixelArray[i] = 0;
        }

        return p;
    }

}
