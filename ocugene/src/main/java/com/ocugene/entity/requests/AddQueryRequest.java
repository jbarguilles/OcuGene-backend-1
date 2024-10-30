package com.ocugene.entity.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ocugene.entity.Query;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddQueryRequest {

    @JsonProperty("email")
    private String email;

    @JsonProperty("message")
    private String message;

    public Query mapToQuery(){
        Query query = new Query();

        query.setEmail(this.email);
        query.setMessage(this.message);
        query.setRespondedFlag(false);

        return query;
    }

}
