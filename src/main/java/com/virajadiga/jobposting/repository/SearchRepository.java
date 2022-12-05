package com.virajadiga.jobposting.repository;

import com.virajadiga.jobposting.model.JobPost;

import java.util.List;

public interface SearchRepository {
    List<JobPost> searchByText(String searchText);
}
