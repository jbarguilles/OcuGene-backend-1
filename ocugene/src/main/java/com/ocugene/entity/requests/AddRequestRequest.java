package com.ocugene.entity.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ocugene.entity.Request;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddRequestRequest {

    @JsonProperty("username")
    String username;

    @JsonProperty("email")
    String email;

    @JsonProperty("password")
    String password;

    @JsonProperty("firstName")
    String firstName;

    @JsonProperty("lastName")
    String lastName;

    @JsonProperty("contactNumber")
    String contactNumber;

    @JsonProperty("userType")
    String userType;

    @JsonProperty("supportingDocuments")
    String supportingDocuments;

    @JsonProperty("institution")
    String institution;

    @JsonProperty("message")
    String message;

    @JsonProperty("status")
    String status;

    public Request mapToRequest() {
        Request request = new Request();

        request.setUsername(this.username);
        request.setEmail(this.email);
        request.setPassword(this.password);

        request.setFirstName(this.firstName);
        request.setLastName(this.lastName);
        request.setContactNumber(this.contactNumber);

        request.setUserType(this.userType);
        request.setSupportingDocuments(this.supportingDocuments);
        request.setInstitution(this.institution);
        request.setMessage(this.message);
        request.setStatus("pending");

        return request;
    }
}
