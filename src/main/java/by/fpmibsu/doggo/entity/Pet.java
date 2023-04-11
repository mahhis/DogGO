package by.fpmibsu.doggo.entity;

import by.fpmibsu.doggo.entity.enums.Breed;
import by.fpmibsu.doggo.entity.enums.Color;

import java.util.List;

public class Pet {

    private String name;
    private String weight;
    private Integer age;

    private User owner;
    private Breed breed;

    private List<Color> color;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public List<Color> getColor() {
        return color;
    }

    public void setColor(List<Color> color) {
        this.color = color;
    }

}
