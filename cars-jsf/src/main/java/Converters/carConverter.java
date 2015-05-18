package Converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import services.interfaces.RentalServicesLocal;
import domain.Car;

@FacesConverter("carcvt")
public class carConverter implements Converter {

	@Inject
	private RentalServicesLocal rentalServicesLocal;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Car car = null;
		if (!value.trim().equals("")) {
			car = rentalServicesLocal.findCarById(Integer.parseInt(value));
		}
		return car;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		String eqString = null;
		if (value == null || value.equals("")) {
			eqString = "";
		} else {
			eqString = ((Car) value).getId().toString();
		}
		return eqString;
	}
}
