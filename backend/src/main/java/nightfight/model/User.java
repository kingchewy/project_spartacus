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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="t_user")
@NamedQuery(name="User.selectAll", query="SELECT n FROM User n")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

	@Override
	public String toString() {
		return "User: [id=" + id + ", name=" + name + ", eMail=" + eMail + ", password=" + password + ", blocked=" + blocked + ", created=" + created + "]";
	}
}