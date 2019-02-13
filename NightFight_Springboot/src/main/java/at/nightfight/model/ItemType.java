package at.nightfight.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ItemType {
    @JsonProperty("WEAPON")
    WEAPON,
    @JsonProperty("ARMOR")
    ARMOR,
    @JsonProperty("SPECIAL")
    SPECIAL
}
