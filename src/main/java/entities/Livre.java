package entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "livre")
public class Livre {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "titre", nullable = false, length = 250)
	private String titre;
	
	@Column(name = "prix")
	private double prix;
	
	@Column(name = "dateEdition")
	private Date dateEdition;
	
	@ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name="CATEGORY_ID" )
	
	private Category category;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Livre(String titre, double prix, Date dateEdition, Category category) {

		this.titre = titre;
		this.prix = prix;
		this.dateEdition = dateEdition;
		this.category = category;
	}
	public Livre() {

	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Date getDateEdition() {
		return dateEdition;
	}
	public void setDateEdition(Date dateEdition) {
		this.dateEdition = dateEdition;
	}
	public Category getCategory() {
		return category;
	}
	public void setIdCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", prix=" + prix + ", dateEdition=" + dateEdition + ", category="
				+ category + "]";
	}
}
