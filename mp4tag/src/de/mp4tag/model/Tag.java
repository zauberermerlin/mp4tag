package de.mp4tag.model;

import java.io.File;

import de.mp4tag.view.Hauptfenster;

public class Tag {

	private Tag datenfelder;
	private String tagSlugName;
	private String tagErstelltAm;
	private String tagReleaseAm;


	/*
	 * ============================================================
	 * Getters und Setters
	 * ============================================================
	 */	

	public String getTagSlugName() {
		return tagSlugName;
	}


	public void setTagSlugName(String tagSlugName) {
		this.tagSlugName = tagSlugName;
	}


	public String getTagErstelltAm() {
		return tagErstelltAm;
	}


	public void setTagErstelltAm(String tagErstelltAm) {
		this.tagErstelltAm = tagErstelltAm;
	}


	public String getTagReleaseAm() {
		return tagReleaseAm;
	}


	public void setTagReleaseAm(String tagReleaseAm) {
		this.tagReleaseAm = tagReleaseAm;
	}


	/*
	 * ============================================================
	 * Hier beginnen die Funktionen
	 * ============================================================
	 */
	
	
	
	/**
	 * 
	 * @return
	 */
	public Tag datenHolen() {
		
	
		
		
		return datenfelder;
	}
	
	
	public void datenInDateiSchreiben(File fdatei) {
		
	}


	
	
}
