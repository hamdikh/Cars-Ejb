package Beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import services.interfaces.RentalServicesLocal;
import domain.CarType;

@ManagedBean
@ViewScoped
public class carTypeBean {

	@EJB
	private RentalServicesLocal rentalServicesLocal;

	private CarType carType = new CarType();
	private List<CarType> carTypes = new ArrayList();
	private DataModel<CarType> dataModel = new ListDataModel();

	public void doSelect(){
		System.out.println(dataModel.getRowData());
	}
	
	public void doCreateCarType() {
		rentalServicesLocal.addCarType(carType);
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public List<CarType> getCarTypes() {
		carTypes = rentalServicesLocal.findAllCarTypes();
		return carTypes;
	}

	public void setCarTypes(List<CarType> carTypes) {
		this.carTypes = carTypes;
	}

	public DataModel<CarType> getDataModel() {
		dataModel.setWrappedData(rentalServicesLocal.findAllCarTypes());
		return dataModel;
	}

	public void setDataModel(DataModel<CarType> dataModel) {
		this.dataModel = dataModel;
	}

}
