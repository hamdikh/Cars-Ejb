package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import edu.esprit.entities.CategoryEvent;
import edu.esprit.interfaces.CategoryEventServiceLocal;

@FacesConverter("catevtcv")
public class CategoryEventConverter implements Converter {

	@Inject
	private CategoryEventServiceLocal categoryEventServiceLocal;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		CategoryEvent categoryEvent = null;
		if (!value.trim().equals("")) {
			categoryEvent = categoryEventServiceLocal
					.findCategoryEventByType(value);
		}
		return categoryEvent;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		String eqString = null;
		if (value == null || value.equals("")) {
			eqString = "";
		} else {
			eqString = ((CategoryEvent) value).getTypeEvenement();
		}
		return eqString;
	}
}
