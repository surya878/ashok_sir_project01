package com.nt.surya.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.surya.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Serializable> {

}
