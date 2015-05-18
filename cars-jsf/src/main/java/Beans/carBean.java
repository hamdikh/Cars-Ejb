package Beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import services.interfaces.RentalServicesLocal;
import domain.Car;
import domain.CarType;

@ManagedBean
@ViewScoped
public class carBean {

	@EJB
	private RentalServicesLocal rentalServicesLocal;

	private Car car;
	private List<Car> cars;
	private List<Car> responseCarTypes;
	private CarType carType = new CarType();
	private List<CarType> carTypes;
	private Boolean visibility = false;

	public carBean() {
	}

	@PostConstruct
	public void initModel() {
		car = new Car();
		cars = rentalServicesLocal.findAllCars();
		carTypes = rentalServicesLocal.findAllCarTypes();
	}

	public void doSelect() {
		System.out.println("Faza----" + car.getId());
		visibility = true;
	}

	public void doSearch() {
		setResponseCarTypes(rentalServicesLocal.findCarsByCarTpe(carType));
		System.out.println(cars.size());
		visibility = true;
	}

	public String doSaveOrUpdate() {
		rentalServicesLocal.updateCar(car);
		visibility = false;
		return "";
	}

	public String doDeleteCar() {
		System.out.println(car.getId());
		rentalServicesLocal.deleteCar(car.getId());
		visibility = false;
		return "";
	}

	public String doAddCar() {
		rentalServicesLocal.addCar(car);
		return "";
	}

	public String doUpdateCar() {
		rentalServicesLocal.updateCar(car);
		return "";
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

	public List<CarType> getCarTypes() {
		return carTypes;
	}

	public void setCarTypes(List<CarType> carTypes) {
		this.carTypes = carTypes;
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public Boolean getVisibility() {
		return visibility;
	}

	public void setVisibility(Boolean visibility) {
		this.visibility = visibility;
	}

	public List<Car> getResponseCarTypes() {
		return responseCarTypes;
	}

	public void setResponseCarTypes(List<Car> responseCarTypes) {
		this.responseCarTypes = responseCarTypes;
	}
}
