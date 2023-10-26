package com.example.UMS.exceptions.errorobject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorObjectRepository extends JpaRepository<ErrorObject, Long> {
}
