package nightfight.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Entity
@Table(name="t_race")
@XmlAccessorType(XmlAccessType.FIELD)
public class Race {
	
	@Id
	@XmlAttribute
	private String race;
	
	@Column(length=1000, nullable=false)
	@XmlAttribute
	private String story;
	
	public Race () {
		
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	@Override
	public String toString() {
		return "Race [race=" + race + ", story=" + story + "]";
	}
	
	
}
