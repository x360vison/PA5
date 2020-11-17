package com.company;
import java.util.ArrayList;
public class Camera {

    private ArrayList<Photograph> memory = new ArrayList<Photograph>();
    private double zoom;
    private String date;

    public Camera() {
        zoom = 1.0;
        date = "19000101";
    }

    public Camera(int num, String date) {
        if(num < 16)
            num = 16;

        memory = new  ArrayList<Photograph>();
        int memorySize = memory.size();

        zoom = 1.0;

        this.date = date;
    }


    public String getDate() {
        return date;
    }

    public double getZoom() {
        return zoom;
    }

    public void setDate(String date) {
        if(date.length() == 8)
            this.date = date;
    }

    public void setZoom(double zoom) {
        if(zoom >= 0 && zoom <= 1)
            this.zoom = zoom;
    }

    public boolean takePhoto(Photograph p) {
        if(numPhotographs < memory.size()) {
            memory.get(numPhotographs) = p;
            numPhotographs++;

            return true;
        }
        else
            return false;
    }

    public boolean takePhoto(int num) {
        Photograph in_p = new Photograph(num, this.getDate());

        for(int i=0; i < in_p.getSize(); i++) {
            in_p.setPixel(i, (int)(Math.random()*255) + 1); //(int) [0,1)*255 => (int) [0,255) => {0,1, ..., 254}
        }

        return takePhoto(in_p);
    }

    public int getPhotoSize(int idx) {
        if(idx >= 0 && idx < memory.length && memory[idx] != null)
            return memory[idx].getSize();
        else
            return -1;
    }


    public String getPhotoDate(int idx) {
        if(idx >= 0 && idx < memory.length && memory[idx] != null)
            return memory[idx].getDate();
        else
            return "00000000";
    }

    private class ArrayList<T> {
        public int memorySize() {
        }
    }
}
