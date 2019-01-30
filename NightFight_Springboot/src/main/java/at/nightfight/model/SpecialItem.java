package at.nightfight.model;

import lombok.*;

import javax.persistence.*;

//==== Lombok ====
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

//==== JPA ====
@Entity
@Table(name="z_special_item")
public class SpecialItem extends Item{

    @NonNull
    private String name;

    @Enumerated(EnumType.STRING)
   // @NonNull
    @Column(name = "special_item_type")
    private SpecialItemType specialItemType;

}
