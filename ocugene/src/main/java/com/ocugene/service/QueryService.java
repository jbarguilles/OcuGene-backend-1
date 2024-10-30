package com.ocugene.service;

import com.ocugene.entity.Query;
import com.ocugene.entity.requests.AddQueryRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QueryService {

    Query addQuery(AddQueryRequest addQueryRequest);
    List<Query> getAllQueries();

}
