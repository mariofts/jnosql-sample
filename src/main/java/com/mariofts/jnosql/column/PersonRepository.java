package com.mariofts.jnosql.column;

import static org.jnosql.diana.api.column.query.ColumnQueryBuilder.select;

import java.util.Optional;

import javax.inject.Inject;

import org.jnosql.artemis.cassandra.column.CassandraTemplate;
import org.jnosql.artemis.column.ColumnTemplate;
import org.jnosql.diana.api.column.ColumnQuery;
import org.jnosql.diana.api.column.query.ColumnQueryBuilder;

public class PersonRepository {

    @Inject
    private CassandraTemplate template;


    public Person save(Person person) {
        return template.insert(person);
    }

    public Optional<Person> findById(Long id) {
//        ColumnQuery columnQuery = select().from("Person").where("id").eq(id).build();
//        return template.singleResult(columnQuery);
        return template.find(Person.class, id);
    }
}
