package com.BankingSystem.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.BankingSystem.Controller.Entity.Appointment;

public interface AppointmentDao extends CrudRepository<Appointment, Long> {

    List<Appointment> findAll();
}
