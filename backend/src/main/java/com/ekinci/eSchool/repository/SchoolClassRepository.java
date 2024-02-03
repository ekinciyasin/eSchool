package com.ekinci.eSchool.repository;

import com.ekinci.eSchool.model.model.SchoolClass;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass,Long> {

}
