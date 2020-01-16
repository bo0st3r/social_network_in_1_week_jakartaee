package be.helha.aemt.control;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import be.helha.aemt.ejb.MemberManagerEJB;
import be.helha.aemt.entity.FormerStudent;
import be.helha.aemt.enumeration.Major;

@SessionScoped
@Named
public class SignUpBean implements Serializable {
	private static final long serialVersionUID = 2679425544218802727L;
	public static final List<SelectItem> SELECTABLE_MAJORS = selectMajors();

	@EJB
	private MemberManagerEJB gestion;

	private FormerStudent former = new FormerStudent();
	private Date birthDateToConvert;
	private String pswConfirm;
	private String mailConfirm;

	public SignUpBean() {
		former.setGraduationYear(2009);
	}

	public void registerMember() {
		if (former.getUsername() != null) {
			if (birthDateToConvert != null) {
				LocalDate date = birthDateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				former.setBirthDate(date);
			}
			former = new FormerStudent();
		}
	}

	public boolean doPswsMatch() {
		if (former.getPassword() != null && pswConfirm != null)
			return former.getPassword().equals(pswConfirm);
		return false;
	}

	public void validatePasswordConfirmation(FacesContext context, UIComponent component, Object value) {
		// Retrieve the temporary value from the password field
		String confirmPassword = (String) value;

		if (former.getPassword() == null || confirmPassword == null) {
			((UIInput) component).setValid(false);
			FacesMessage msg = new FacesMessage("Les 2 mots de passe sont requis.");
			context.addMessage(component.getClientId(context), msg);
		} else if (!former.getPassword().equals(confirmPassword)) {
			((UIInput) component).setValid(false);
			FacesMessage msg = new FacesMessage("La confirmation ne correspond pas.");
			context.addMessage(component.getClientId(context), msg);
		}
	}

	public void validateMailConfirmation(FacesContext context, UIComponent component, Object value) {
		// Retrieve the temporary value from the password field
		String confirmMail = (String) value;

		if (former.getMail() == null || confirmMail == null) {
			((UIInput) component).setValid(false);
			FacesMessage msg = new FacesMessage("Les 2 mails sont requis.");
			context.addMessage(component.getClientId(context), msg);

		} else if (!former.getMail().equals(confirmMail)) {
			((UIInput) component).setValid(false);
			FacesMessage msg = new FacesMessage("La confirmation ne correspond pas.");
			context.addMessage(component.getClientId(context), msg);
		} else if (mailExists()) {
			((UIInput) component).setValid(false);
			FacesMessage msg = new FacesMessage("Ce mail est déjà utilisé.");
			context.addMessage(component.getClientId(context), msg);
		}
	}

	public boolean mailExists() {
		System.out.println("gestion: " + gestion);
		return gestion.findIdByMail(former.getMail()) > 0;
	}

	public boolean doMailsMatch() {
		if (former.getMail() != null && mailConfirm != null)
			return former.getMail().equals(mailConfirm);
		return false;
	}

	public FormerStudent getFormer() {
		return former;
	}

	public void setFormer(FormerStudent former) {
		this.former = former;
	}

	public Date getBirthDateToConvert() {
		return birthDateToConvert;
	}

	public void setBirthDateToConvert(Date birthDateToConvert) {
		this.birthDateToConvert = birthDateToConvert;
	}

	private static List<SelectItem> selectMajors() {
		ArrayList<SelectItem> selectables = new ArrayList<SelectItem>();
		for (Major major : Major.values()) {
			selectables.add(new SelectItem(major, major.toString()));
		}

		return selectables;
	}

	public List<SelectItem> getSelectableMajors() {
		return SELECTABLE_MAJORS;
	}

	public String getPswConfirm() {
		return pswConfirm;
	}

	public void setPswConfirm(String pswConfirm) {
		this.pswConfirm = pswConfirm;
	}

	public String getMailConfirm() {
		return mailConfirm;
	}

	public void setMailConfirm(String mailConfirm) {
		this.mailConfirm = mailConfirm;
	}
}
