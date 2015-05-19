package Beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;

import services.interfaces.RentalServicesLocal;
import domain.CarType;

@ManagedBean
@ViewScoped
public class carTypeBean {

	@EJB
	private RentalServicesLocal rentalServicesLocal;

	private CarType carType = new CarType();
	private List<CarType> carTypes;
	private CarType rescarTypes;
	private DataModel<CarType> dataModel;
	private String word;
	private Boolean visibility = false;

	@PostConstruct
	public void initModel() {
		word = "";
		carTypes = rentalServicesLocal.findAllCarTypes();
		// setRescarTypes(new CarType());

	}

	public void doSelect() {
		System.out.println(dataModel.getRowData());
	}

	public void doSearch() {
		rescarTypes = rentalServicesLocal.findCarTypeByName(word);
		visibility = true;
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

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Boolean getVisibility() {
		return visibility;
	}

	public void setVisibility(Boolean visibility) {
		this.visibility = visibility;
	}

	public CarType getRescarTypes() {
		return rescarTypes;
	}

	public void setRescarTypes(CarType rescarTypes) {
		this.rescarTypes = rescarTypes;
	}

}
