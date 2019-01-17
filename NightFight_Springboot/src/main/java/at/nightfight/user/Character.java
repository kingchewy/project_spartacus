package at.nightfight.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//==== Lombok ====
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

//==== JPA ====
@Entity
@Table(name="t_character")
public class Character {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlAttribute
	private Long id;

	@Column(name="user_id")
	@XmlAttribute
	private Long user_id;
	
	@NonNull
	@Column(length=25, nullable=false)
	@XmlAttribute
	private String race;

	@NonNull
	@Column(length=45, nullable=false)
	@XmlAttribute
	private String name;
	
	@Column
	@XmlAttribute
	private int lvl;
	
	@Column
	@XmlAttribute
	private int xp;
	
	@Column
	@XmlAttribute
	private int hp;
	
	@Column
	@XmlAttribute
	private float damage_resistance;
	
	@Column
	@XmlAttribute
	private float strength;
	
	@Column
	@XmlAttribute
	private float hit_rate;
	
	@Column
	@XmlAttribute
	private float agility;
}