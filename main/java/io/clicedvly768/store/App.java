package io.clicedvly768.store;

public class App {
    private String name;
    private String category;
    private String description;

    public App(String name, String category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }
}