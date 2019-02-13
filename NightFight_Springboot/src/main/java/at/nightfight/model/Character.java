package at.nightfight.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

//==== Lombok ====
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

//==== JPA ====
@Entity
@Table(name="z_character")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Character {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "character_id")
	private Long characterId;

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
	private float armor;

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

	@NonNull
	private float discs;

/*	@JsonIdentityInfo(
			generator = ObjectIdGenerators.PropertyGenerator.class,
			property = "id"
	)*/
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "z_character_characteritem",
			joinColumns = { @JoinColumn(name = "character_id")},
			inverseJoinColumns = { @JoinColumn(name = "character_item_id")}
	)
	private List<Item> ownedItems;

/*	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private EquippedGear equippedGear;*/

	@OneToOne(mappedBy = "character", cascade = CascadeType.ALL)
	private EquippedGear equippedGear;


	// METHODS
	public void setNewCharacterAttributes(){
		this.lvl = 1;
		this.xp = 0;
		this.discs = 0;

		setDefaultValuesByRace();
	}

	private void setDefaultValuesByRace(){
		switch (this.race){
			case "human":
				this.hp = 2100;
				this.armor = 300;
				this.strength = 430;
				this.accuracy = 334;
				this.agility = 345;
				break;
			case "robot":
				this.hp = 3500;
				this.armor = 500;
				this.strength = 340;
				this.accuracy = 42;
				this.agility = 23;
				break;
			case "monster":
				this.hp = 3100;
				this.armor = 345;
				this.strength = 600;
				this.accuracy = 150;
				this.agility = 250;
				break;
		}
	}

	public boolean isOwnedItem(Item item){
		return ownedItems.stream().anyMatch(item1 -> item1.getId() == item.getId());
	}

	public boolean hasTheMoney(float money){
		return this.discs >= money;
	}

	public void pay(Long money){
		discs -= money;
	}

	public void addItem(Item item){
		ownedItems.add(item);
	}
}