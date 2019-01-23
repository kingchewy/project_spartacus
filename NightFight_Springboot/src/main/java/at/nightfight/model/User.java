package at.nightfight.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

//==== Lombok ====
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

//==== JPA ====
@Entity
@Table(name="t_user_test", uniqueConstraints = {
		@UniqueConstraint(columnNames = {
				"username"
		}),
		@UniqueConstraint(columnNames = {
				"email"
		})
})
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@NonNull
	@Column(length=40, nullable=false)
	@XmlAttribute
	private String name;

	@NotBlank
	@Size(min=3, max = 50)
	private String username;

	@NaturalId
	@NotBlank
	@Column(length=50, nullable=false)
	@XmlAttribute
	@Email
	private String email;
	
	@NotBlank
	@Column(length=255, nullable=false)
	@XmlAttribute
	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();



	@Column(nullable = true)
	@XmlAttribute
	private Boolean blocked;

	@NonNull
	@Column
	@XmlAttribute
	private LocalDate created;
	
/*	@OneToMany
	@JoinColumn(
		name="user_id",
		referencedColumnName=("id")
	)
	private List<Character> characters;*/
	@OneToMany(mappedBy = "user")
	private List<Character> characters;


	public User(String name, String username, String email, String password) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
	}
}