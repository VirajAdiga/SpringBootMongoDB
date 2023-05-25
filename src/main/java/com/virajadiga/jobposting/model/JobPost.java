package com.virajadiga.jobposting.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "JobPost")
public class JobPost {
    private String _id;
    private String profile;
    private String desc;
    private int exp;
    private Technology[] technologies;

    public JobPost() {

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public Technology[] getTechnologies() {
        return technologies;
    }

    public void setTechnologies(Technology[] technologies) {
        this.technologies = technologies;
    }

    @Override
    public String toString() {
        return "JobPost{" +
                "profile='" + profile + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
