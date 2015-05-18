package Converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import services.interfaces.RentalServicesLocal;
import domain.CarType;

@FacesConverter("dtc")
public class CarTypeConverter implements Converter {

	@Inject
	private RentalServicesLocal rentalServicesLocal;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		CarType carType = null;
		if (!value.trim().equals("")) {
			carType = rentalServicesLocal.findCarTypeByName(value);
		}
		return carType;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		String eqString = null;
		if (value == null || value.equals("")) {
			eqString = "";
		} else {
			eqString = ((CarType) value).getName();
		}
		return eqString;
	}
}
