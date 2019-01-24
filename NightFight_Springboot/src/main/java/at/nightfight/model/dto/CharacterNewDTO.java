package at.nightfight.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CharacterNewDTO {

    private Long userId;

    private String race;

    private String name;

    public CharacterNewDTO() {
    }

    public CharacterNewDTO(Long userId, String race, String name) {
        this.userId = userId;
        this.race = race;
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
