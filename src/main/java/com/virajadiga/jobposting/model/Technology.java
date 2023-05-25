package com.virajadiga.jobposting.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Technology")
public class Technology {
    private String _id;
    private String name;

    public Technology() {

    }

    public Technology(String name) {
        this.name = name;
    }

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
