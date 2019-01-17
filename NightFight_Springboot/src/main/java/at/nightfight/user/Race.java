package at.nightfight.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//==== Lombok ====
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

//==== JPA ====
@Entity
@Table(name="t_race")

//==== JAXB ====
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Race {
	
	@Id
	@Column(length=20, nullable=false)
	@XmlAttribute
	private String race;
	
	@Column(length=1000, nullable=false)
	@XmlAttribute
	private String story;
}