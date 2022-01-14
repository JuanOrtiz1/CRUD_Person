package com.co.jpom.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.co.jpom.interview.model.*;
public interface PersonRepository extends JpaRepository<Person,Long>{

}
