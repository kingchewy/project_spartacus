package nightfight.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


@Entity
@Table(name="t_user")
@NamedQuery(name="User.selectAll", query="SELECT n FROM User n")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlAttribute
	private Long id;
	
	@NotNull
	@Column(length=45, nullable=false)
	@XmlAttribute
	private String name;
	
	@Column(length=50, nullable=false)
	@XmlAttribute
	private String eMail;
	
	@Column(length=100, nullable=false)
	@XmlAttribute
	private String password;
	
	@Column(nullable=false)
	@XmlAttribute
	private int blocked;
	
	@Column(nullable=true)
	@XmlAttribute
	private String created;
	
	
	public User() {
		System.out.println("create constructor");
	}
	
	public User(String name) {
		this.name = name;
	}

	public User(String name, String eMail) {
		this.name = name;
		this.eMail = eMail;
	}	
	
	public User(Long id, String name, String eMail) {
		this.id = id;
		this.name = name;
		this.eMail = eMail;
	}
	public User(Long id, String name, String eMail, int blocked) {
		this.id = id;
		this.name = name;
		this.eMail = eMail;
		this.blocked = blocked;
	}	
	public User(Long id, String name, String eMail, int blocked, String created) {
		this.id = id;
		this.name = name;
		this.eMail = eMail;
		this.blocked = blocked;
		this.created = created;
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


	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBlocked() {
		return blocked;
	}

	public void setBlocked(int blocked) {
		this.blocked = blocked;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "User: [id=" + id + ", name=" + name + ", eMail=" + eMail + ", password=" + password + ", blocked=" + blocked + ", created=" + created + "]";
	}
}