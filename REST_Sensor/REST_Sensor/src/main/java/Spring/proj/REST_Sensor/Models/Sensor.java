package Spring.proj.REST_Sensor.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="sensor")
//@Getter
//@Setter
//Конфликт ломбока и хибернейт
public class Sensor implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    @NotEmpty(message="Название сенсора не может быть пустым")
    @Size(min=3,max=30,message="Название сенсора должно быть от 3 до 30 символов")
    private String name;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
