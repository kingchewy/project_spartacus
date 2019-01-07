package nightfight.accounts;

import java.sql.Date;

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
	private String email;
	
	@Column(length=100, nullable=false)
	@XmlAttribute
	private String password;
	
	@Column(nullable=false)
	@XmlAttribute
	private int blocked;
	
	@Column(nullable=false)
	@XmlAttribute
	private Date created;
	
	public Accounts () {}
	}
