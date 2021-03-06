package com.company;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Camera {

    private final List<Photograph> memoryCard = new ArrayList<>(16);
    private double zoom;
    private String date;
    private int memorySize;

    public Camera() {
        zoom = 1.0;
        date = "19000101";
    }

    public Camera(List<Photograph> memory, String date) {
        memoryCard.add(new Photograph(memory, date));
        memorySize = memoryCard.size();

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

    public Integer getMemory(){
        return memorySize;
    }

    public void setMemory(int memory){
        this.memorySize = memory;
    }

    public void setZoom(double zoom) {
        if(zoom >= 0 && zoom <= 1)
            this.zoom = zoom;
    }

    public boolean takePhoto(Photograph p) {
        if(memorySize < memoryCard.size()) {
            memoryCard.add(p);
            memorySize++;

            return true;
        }
        else
            return false;
    }

    public boolean takePhoto(int num) {
        Photograph in_p = new Photograph(num, this.getDate());
        for(int i=0; i < in_p.getSize().length; i++) {
            in_p.setPixel(i, (int)(Math.random()*255) + 1); //(int) [0,1)*255 => (int) [0,255) => {0,1, ..., 254}
        }

        return takePhoto(in_p);
    }

    public int getPhotoSize(int idx) {
        if(idx >= 0 && idx < memoryCard.size() && memoryCard.get(idx) != null)
            return memoryCard.get(idx).getSize().length;
        else
            return -1;
    }


    public String getPhotoDate(int idx) {
        if(idx >= 0 && idx < memoryCard.size() && memoryCard.get(idx) != null)
            return memoryCard.get(idx).getDate();
        else
            return "00000000";
    }

}
