package com.BankingSystem.Service;

import java.util.List;

import com.BankingSystem.Controller.Entity.Appointment;

public interface AppointmentService {
	Appointment createAppointment(Appointment appointment);

	List<Appointment> findAll();

	Appointment findAppointment(Long id);

	void confirmAppointment(Long id);
}
