package com.gitub.kejn.mongodbstarter.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor(onConstructor = @__({@PersistenceConstructor}))
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Document
public class Customer {

    @Id
    private String id;
    private String firstName;
    private String lastName;

    public Customer(String firstName, String lastName) {
        this(null, firstName, lastName);
    }

}
