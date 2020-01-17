package be.helha.aemt.control;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

import be.helha.aemt.ejb.EventManagerEJB;
import be.helha.aemt.entity.Address;
import be.helha.aemt.entity.Event;

@ApplicationScoped
@Named
public class EventControl implements Serializable {
	private static final long serialVersionUID = -7120088471496101019L;
	
	@EJB
	private EventManagerEJB gestion;
	
	private Event event = new Event();
	private Date dateEventToConvert;
	
	private Part currentImage;
	private File currentImageFile;
	private byte[] currentImageByteArray = new byte[0];
	
	public Event post() {
		
		try {
			convertCurrentImageToByteArray();
			event.setIdEvent(-1);
			event.setImageEvent(currentImageByteArray);
			event.setDateEvent(dateEventToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
			event.setAddressEvent(new Address(0, "Mons", "Chaussée de Binche", "159", 7000));
			System.out.println(event +"" +  currentImageByteArray);
			return gestion.post(event);
		} catch (IOException e) {
			System.out.println("une erreur est survenue lors de la conversion de l'image");
		}
		
		return event;
	}
	
	public List<Event> queryAll(){
		return gestion.queryAll();
	}
	
	public Event queryById(int id) {
		event = gestion.queryById(id);
		return event;
	}

	public Event queryEquals(Event event) {
		this.event = gestion.queryEquals(event);
		return this.event;
	}

	public Event queryEquals() {
		this.event = gestion.queryEquals(event);
		return this.event;
	}

	public int queryIdFromEquals(Event event) {
		return gestion.queryIdFromEquals(event);
	}

	public int queryIdFromEquals() {
		return gestion.queryIdFromEquals(event);
	}
	
	public boolean update() {
		return gestion.update(event);
	}
	
	public boolean delete() {
		return gestion.delete(event);
	}

	/*****************************
	   Getters & setters
	 *****************************/

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Date getDateEventToConvert() {
		return dateEventToConvert;
	}

	public void setDateEventToConvert(Date dateEventToConvert) {
		this.dateEventToConvert = dateEventToConvert;
	}

	public Part getCurrentImage() {
		return currentImage;
	}

	public void setCurrentImage(Part currentImage) {
		this.currentImage = currentImage;
	}

	public File getCurrentImageFile() {
		return currentImageFile;
	}

	public void setCurrentImageFile(File currentImageFile) {
		this.currentImageFile = currentImageFile;
	}

	public byte[] getCurrentImageByteArray() {
		return currentImageByteArray;
	}

	public void setCurrentImageByteArray(byte[] currentImageByteArray) {
		this.currentImageByteArray = currentImageByteArray;
	}
	
	public void convertCurrentImageToByteArray() throws IOException {
		currentImageByteArray = new byte[(int) currentImage.getSize()];
		 currentImage.getInputStream().read(currentImageByteArray);
	}
	
	public byte[] showImage() {
		return currentImageByteArray;
	}
	
	public byte[] showImage(byte[] image) {
		return image;
	}
}
