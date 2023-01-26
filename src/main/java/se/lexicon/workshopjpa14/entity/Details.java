package se.lexicon.workshopjpa14.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detailsId;

    @Column(unique = true, length = 100)
    private String email;

    @Column(length = 80)
    private String name;

    private LocalDate birtDate;


    //constructor

    public Details() {
    }

    public Details(String email, String name, LocalDate birtDate) {
        this.email = email;
        this.name = name;
        this.birtDate = birtDate;
    }



    //Getter and Setter
    public int getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(int detailsId) {
        this.detailsId = detailsId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirtDate() {
        return birtDate;
    }

    public void setBirtDate(LocalDate birtDate) {
        this.birtDate = birtDate;
    }


    //Equal & hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Details details = (Details) o;
        return detailsId == details.detailsId && Objects.equals(email, details.email) && Objects.equals(name, details.name) && Objects.equals(birtDate, details.birtDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detailsId, email, name, birtDate);
    }


    //toString

    @Override
    public String toString() {
        return "Details{" +
                "detailsId=" + detailsId +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", birtDate=" + birtDate +
                '}';
    }
}
