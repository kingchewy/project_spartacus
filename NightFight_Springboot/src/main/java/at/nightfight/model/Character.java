package at.nightfight.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name="t_character_test")
public class Character {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlAttribute
	private Long id;

/*	@Column(name="user_id")
	@XmlAttribute
	private Long user_id;*/

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private User user;
	
	@NonNull
	@Column(length=25, nullable=false)
	@XmlAttribute
	private String race;

	@NonNull
	@Column(length=45, nullable=false)
	@XmlAttribute
	private String name;

	@NonNull
	@Column
	@XmlAttribute
	private int lvl;

	@NonNull
	@Column
	@XmlAttribute
	private int xp;

	@NonNull
	@Column
	@XmlAttribute
	private int hp;

	@NonNull
	@Column
	@XmlAttribute
	private float damage_resistance;

	@NonNull
	@Column
	@XmlAttribute
	private float strength;

	@NonNull
	@Column
	@XmlAttribute
	private float accuracy;

	@NonNull
	@Column
	@XmlAttribute
	private float agility;

/*	@OneToOne(
			mappedBy = "character"
			*//*cascade = CascadeType.ALL,
			fetch = FetchType.LAZY*//*
	)
	private Inventory inventory;*/

	// METHODS
	public void setNewCharacterAttributes(){
		this.lvl = 1;
		this.xp = 0;

		setDefaultValuesByRace();
	}

	private void setDefaultValuesByRace(){
		switch (this.race){
			case "human":
				this.hp = 2100;
				this.damage_resistance = 300;
				this.strength = 430;
				this.accuracy = 334;
				this.agility = 345;
				break;
			case "robot":
				this.hp = 3500;
				this.damage_resistance = 500;
				this.strength = 340;
				this.accuracy = 42;
				this.agility = 23;
				break;
			case "monster":
				this.hp = 3100;
				this.damage_resistance = 345;
				this.strength = 600;
				this.accuracy = 150;
				this.agility = 250;
				break;
		}

	}
}