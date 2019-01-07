package at.technikumwien.clients;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Entity
@Table(name="t_clients")
@NamedQueries({
	@NamedQuery(name="Clients.selectAll", query="SELECT n FROM Clients n"),
	@NamedQuery(name="Clients.selectSearched", query="SELECT n FROM Clients n WHERE n.name LIKE :name")
})
@XmlAccessorType(XmlAccessType.FIELD)
public class Clients {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlAttribute
	private Long id;
	
	@Column(length=100, nullable=false)
	@XmlAttribute
	private String name;
	
	@Column(length=1000, nullable=false)
	@XmlAttribute
	private String fav_color;
	
	public Clients() {}

	public Clients(String name, String text) {
		this.name = name;
		this.fav_color = text;
	}	
	
	public Clients(Long id, String name, String text) {
		this.id = id;
		this.name = name;
		this.fav_color = text;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return fav_color;
	}

	public void setText(String text) {
		this.fav_color = text;
	}

	@Override
	public String toString() {
		return "Clients [id=" + id + ", name=" + name + ", text=" + fav_color + "]";
	}
}