package org.example.kursweb.Models;

public class Order {

    private int id;
    private String name;
    private String description;
    private double price;
    private int ready;
    private String worker_name;

    public Order() {
    }

    public Order(int id, String name, String description, double price, int ready, String worker_name) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.ready = ready;
        this.worker_name = worker_name;
    }

    public int getReady() {
        return ready;
    }

    public void setReady(int ready) {
        this.ready = ready;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getWorker_name() {
        return worker_name;
    }

    public void setWorker_name(String worker_name) {
        this.worker_name = worker_name;
    }
}