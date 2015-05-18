package Beans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import services.interfaces.RentalServicesLocal;
import domain.Car;
import domain.Customer;

@ManagedBean
@ViewScoped
public class ContractBean {

	private Car car;
	private List<Car> cars;
	private Integer days;

	@ManagedProperty("#{identity.identifiedUser}")
	private Customer customer;
	@EJB
	RentalServicesLocal rentalServicesLocal;

	@PostConstruct
	public void initModel() {
		car = new Car();
		cars = rentalServicesLocal.findAllCars();
		days = 0;
	}

	public String DoSave() {
		rentalServicesLocal.createContract(customer, car, new Date(), days);
		return "/customer/home?faces-redirect=true";
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

}
