package ch.gibmit.m226.todo.dto;

/**
 * Created by zehnder on 21/04/16.
 */
public class CategoryDTO {

    private String name;

    public CategoryDTO(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
