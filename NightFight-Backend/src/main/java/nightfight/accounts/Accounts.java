package nightfight.accounts;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


@Entity
@Table(name="user_accounts")
@NamedQuery(name="Accounts.selectAll", query="SELECT n FROM Accounts n")
@XmlAccessorType(XmlAccessType.FIELD)
public class Accounts {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlAttribute
	private Long id;
	
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
	
	@Column(nullable=false)
	@XmlAttribute
	private String created;
	
	public Accounts() {}

	public Accounts(String name, String text) {
		this.name = name;
		this.eMail = text;
	}	
	
	public Accounts(Long id, String name, String text) {
		this.id = id;
		this.name = name;
		this.eMail = text;
	}
	public Accounts(Long id, String name, String text, int blocked) {
		this.id = id;
		this.name = name;
		this.eMail = text;
		this.blocked = blocked;
	}	
	public Accounts(Long id, String name, String text, int blocked, String date) {
		this.id = id;
		this.name = name;
		this.eMail = text;
		this.blocked = blocked;
		this.created = date;
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

	public String getEmail() {
		return eMail;
	}

	public void setEmail(String text) {
		this.eMail = text;
	}

	@Override
	public String toString() {
		return "Clients [id=" + id + ", name=" + name + ", eMail=" + eMail + ", password=" + password + ", blocked=" + blocked + ", created=" + created + "]";
	}
}