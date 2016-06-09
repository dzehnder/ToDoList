package ch.gibmit.m226.todo.dto;

import java.io.Serializable;

/**
 * Created by zehnder on 21/04/16.
 */
public class CategoryDTO implements Serializable {

	private static final long serialVersionUID = 7887824545487907788L;
	private String name;

    /**
     * constructor sets the name of the category
     * @param name
     */
    public CategoryDTO(String name) {
        this.name = name;
    }

    /**
     * get the name of the category
     * @return the name of the category
     */
    public String getName() {
        return name;
    }

    /**
     * set a new name for the category
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }
}
