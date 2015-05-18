package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.esprit.entities.CategoryEvent;
import edu.esprit.interfaces.CategoryEventServiceLocal;

@ManagedBean
@ViewScoped
public class CategoryEventBean {

	private CategoryEvent categoryEvent;
	private List<CategoryEvent> categoryEvents;
	private Boolean visibility = false;
	@EJB
	CategoryEventServiceLocal categoryEventServiceLocal;

	@PostConstruct
	public void initModel() {
		categoryEvent = new CategoryEvent();
		setCategoryEvents(categoryEventServiceLocal.findAllCategoryEvents());
	}

	public void doSelect() {
		setVisibility(true);
	}

	public void doSave() {
		categoryEventServiceLocal.addCategoryEvent(categoryEvent);
	}

	public CategoryEvent getCategoryEvent() {
		return categoryEvent;
	}

	public void setCategoryEvent(CategoryEvent categoryEvent) {
		this.categoryEvent = categoryEvent;
	}

	public List<CategoryEvent> getCategoryEvents() {
		return categoryEvents;
	}

	public void setCategoryEvents(List<CategoryEvent> categoryEvents) {
		this.categoryEvents = categoryEvents;
	}

	public Boolean getVisibility() {
		return visibility;
	}

	public void setVisibility(Boolean visibility) {
		this.visibility = visibility;
	}
}
