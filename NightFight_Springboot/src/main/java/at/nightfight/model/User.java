package at.nightfight.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name="t_user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@NonNull
	@Column(length=40, nullable=false)
	@XmlAttribute
	private String name;

	@NonNull
	@Column(length=50, nullable=false)
	@XmlAttribute
	private String email;
	
	@NonNull
	@Column(length=255, nullable=false)
	@XmlAttribute
	private String password;
	
	@Column(nullable=false)
	@XmlAttribute
	private Boolean blocked;
	
	@Column
	@XmlAttribute
	private LocalDate created;
	
	@OneToMany
	@JoinColumn(
		name="user_id",
		referencedColumnName=("id")
	)
	private List<Character> characters;
}