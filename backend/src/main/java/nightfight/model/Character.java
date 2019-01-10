package nightfight.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="t_character")
@XmlAccessorType
public class Character {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlAttribute
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	//@JoinColumn(name = "user_id", nullable = false)
	//@JsonIgnore
	private User user;
	
	@XmlAttribute
	@Column(length=50, nullable=false)
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "race", nullable = false)
	//@JsonIgnore
	private Race race;
	
	@XmlAttribute
	private Long lvl;
	
	@XmlAttribute
	private Long xp;
	
	@XmlAttribute
	private Long hp;
	
	@XmlAttribute
	private Long armor;
	
	@XmlAttribute
	private Long strength;
	
	@XmlAttribute
	private Long hitRate;
	
	@XmlAttribute
	private Long agility;
	
	
	public Character() {
		System.out.println(this.race);
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setAccount(User user) {
		this.user = user;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Race getRace() {
		return race;
	}


	public void setRace(Race race) {
		this.race = race;
	}


	public Long getLvl() {
		return lvl;
	}


	public void setLvl(Long lvl) {
		this.lvl = lvl;
	}


	public Long getXp() {
		return xp;
	}


	public void setXp(Long xp) {
		this.xp = xp;
	}


	public Long getHp() {
		return hp;
	}


	public void setHp(Long hp) {
		this.hp = hp;
	}


	public Long getArmor() {
		return armor;
	}


	public void setArmor(Long armor) {
		this.armor = armor;
	}


	public Long getStrength() {
		return strength;
	}


	public void setStrength(Long strength) {
		this.strength = strength;
	}


	public Long getHitRate() {
		return hitRate;
	}


	public void setHitRate(Long hitRate) {
		this.hitRate = hitRate;
	}


	public Long getAgility() {
		return agility;
	}


	public void setAgility(Long agility) {
		this.agility = agility;
	}


	@Override
	public String toString() {
		return "Character [id=" + id + ", user=" + user + ", name=" + name + ", race=" + race + ", lvl=" + lvl
				+ ", xp=" + xp + ", hp=" + hp + ", armor=" + armor + ", strength=" + strength + ", hitRate=" + hitRate
				+ ", agility=" + agility + "]";
	}
	
	
}
