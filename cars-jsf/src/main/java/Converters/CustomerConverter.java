package Converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import services.interfaces.UserServicesLocal;
import domain.Customer;

@FacesConverter("cuscv")
public class CustomerConverter implements Converter {
	@Inject
	private UserServicesLocal userServicesLocal;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Customer customer = null;
		if (!value.trim().equals("")) {
			customer = userServicesLocal.findCustomerById(Integer
					.valueOf(value));
		}
		return customer;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		String eqString = null;
		if (value == null || value.equals("")) {
			eqString = "";
		} else {
			eqString = ((Customer) value).getId().toString();
		}
		return eqString;
	}
}
