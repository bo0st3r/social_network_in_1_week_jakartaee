package be.helha.aemt.control;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

@SessionScoped
@Named
public class AddAnnoucementBean implements Serializable {
	private static final long serialVersionUID = -5902319438023134916L;
	
	private String currentForm = "Evenement" ;
	private boolean currentFormEvent = true;

	public String getCurrentForm() {
		return currentForm;
	}

	public void setCurrentForm(String currentForm) {
		this.currentForm = currentForm;
	}
	
	public boolean isCurrentFormEvent() {
		return currentFormEvent;
	}

	public void setCurrentFormEvent(boolean currentFormEvent) {
		this.currentFormEvent = currentFormEvent;
	}

	public boolean updateForm(boolean inverse) {
		
		currentFormEvent = inverse?(!currentForm.equals("Evenement")):(currentForm.equals("Evenement"));
		return currentFormEvent;
	}
}
