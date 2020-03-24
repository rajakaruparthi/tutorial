package com.spring.hospital.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.hospital.jpa.UserJpa;
import com.spring.hospital.model.Address;
import com.spring.hospital.model.Appointment;
import com.spring.hospital.model.User;
import com.spring.hospital.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserJpa uJpa;

	List<User> users;
	User us1;

	public UserServiceImpl() {
		Address a = new Address();
		Appointment apt1 = new Appointment();
		apt1.setAptTime("12:30");
		apt1.setAptReason("Caugh");
		Appointment apt2 = new Appointment();
		apt2.setAptTime("12:30");
		apt2.setAptReason("Fever");
		List<Appointment> aptList = new ArrayList<Appointment>();
		aptList.add(apt1);
		aptList.add(apt2);
		a.setAddress_line_1("temp1");
		a.setAddress_line_2("address_line_2");
		a.setCity("city");
		a.setPhone("phone num");
		a.setZipcode("zipcode");
		a.setState("state");
		a.setUa_id(1);
		us1 = new User();
		us1.setAddress(a);
		us1.setEmail("raja@shsu.edu");
	}

	@Override
	public List<User> getUser() {
		System.out.println("Came here in the get user" + us1.getAddress());
		addUser();
		List<User> users = uJpa.findAll();
		return users;
	}

	@Override
	public Response addUser() {
		System.out.println(us1.getAddress().getAddress_line_1());
		uJpa.save(us1);
		return Response.ok().build();
	}

	@Override
	public Response deleteUSer() {
		uJpa.deleteById(1);
		return Response.ok().build();
	}

	@Override
	public User getUserById(Integer id) {
		Optional<User> findById = uJpa.findById(id);
		return findById.get();
	}

	@Override
	public Response editUser(User usr) {
		// TODO Auto-generated method stub
		uJpa.save(usr);
		return null;
	}

	@Override
	public boolean checkIfAutorized(Integer id) {
		boolean existsById = uJpa.existsById(id);
		return existsById;
	}

}
