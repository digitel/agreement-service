package org.tmf.openapi.agreement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import org.tmf.openapi.agreement.domain.Agreement;

@Repository
public interface AgreementRepository extends MongoRepository<Agreement, String>, QuerydslPredicateExecutor<Agreement> {

}
