package CaseStudy.CaseStudy.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import java.io.Serializable;

@Data
@Entity
@Table(name= "customers")
public class Customer  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @NaturalId
    private String email;

    @NaturalId
    private String mobilePhone;

    private String country;
    private String city;
    private  String address;
}



