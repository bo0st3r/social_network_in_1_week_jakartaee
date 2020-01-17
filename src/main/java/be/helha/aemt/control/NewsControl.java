package be.helha.aemt.control;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.imageio.ImageIO;
import javax.inject.Named;
import javax.servlet.http.Part;

import be.helha.aemt.ejb.NewsManagerEJB;
import be.helha.aemt.entity.News;

@ApplicationScoped
@Named
public class NewsControl implements Serializable {
	private static final long serialVersionUID = 7039981650663567402L;

	@EJB
	private NewsManagerEJB gestion;
	
	private News news = new News();
	private Part currentImage;
	private File currentImageFile;
	private byte[] currentImageByteArray = new byte[0];
	
	public News post() {
		try {
			convertCurrentImageToByteArray();
			news.setPicture(currentImageByteArray);
			news.setPostingDate(LocalDate.now());
			
			return gestion.post(news);
		} catch (IOException e) {
			System.out.println("une erreur est survenue lors de la conversion du fichier");
		}
		return news;
	}

	public List<News> queryAll(){
		return gestion.queryAll();
	}
	
	public News queryById(int id) {
		news = gestion.queryById(id);
		return news;
	}

	public int queryIdFromEquals(News news) {
		return gestion.queryIdFromEquals(news);
	}
	
	public int queryIdFromEquals() {
		return gestion.queryIdFromEquals(news);
	}
	
	public boolean update() {
		return gestion.update(news);
	}
	
	public boolean delete() {
		return gestion.delete(news);
	}

	/*****************************
	   Getters & setters
	 *****************************/

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
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
}
