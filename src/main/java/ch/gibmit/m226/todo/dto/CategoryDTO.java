package ch.gibmit.m226.todo.dto;

import java.io.Serializable;

/**
 * Created by zehnder on 21/04/16.
 */
public class CategoryDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7887824545487907788L;
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
