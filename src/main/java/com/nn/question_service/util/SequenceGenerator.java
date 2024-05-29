package com.nn.question_service.util;

import com.nn.question_service.data.models.entity.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Component
public class SequenceGenerator {

    @Autowired
    private MongoOperations mongoOperations;

    public  String getSequence(String sequenceId){
        Query query = new Query(Criteria.where("_id").is(sequenceId));
        Update update = new Update().inc("count",1);
        Sequence counter = mongoOperations
                            .findAndModify(query,update,options().returnNew(true)
                                                                 .upsert(true),Sequence.class);
        return Objects.nonNull(counter)?String.valueOf(counter.getCount()):"1";
    }
}
