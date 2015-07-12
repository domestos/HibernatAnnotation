package com.company;


import javax.persistence.*;
import java.util.List;

/**
 * Created by v.pelenskyi on 08.07.2015.
 */
@Entity //вказуЇмо, що цей клас описуЇ таблицю
@Table(name  = "Company") //вказуЇмо €ку саме таблицю в баз≥ даних ми описуЇмо
//оск≥льки назва класу ≥ ≥м€ таблиц≥ може в≥др≥зн€тись
public class Company extends DataBase {

    @Id // вказуЇ, що ц€ перем≥нна буде ун≥кальним
    @Column(name = "id") //€кщо ≥м'€ перем≥нноњ не сп≥впадаЇ з ≥менем в таблиц≥
    @GeneratedValue(strategy = GenerationType.AUTO) //автоматично генеруЇ ≥d
    //казую, зо ц€ зм≥нна(поле) буде мати залежн≥сть зперем≥ннуою  id_company
    private int id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
    private List<Cartridge> Cartridges;

    @Column(name="name_company")
    private String nameCompany;

    @Column(name = "mob_number")
    private String mobCumber;



    //Getter and Setter


    public List<Cartridge> getCartridges() {
        return Cartridges;
    }

    public void setCartridges(List<Cartridge> cartridges) {
        Cartridges = cartridges;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getMobCumber() {
        return mobCumber;
    }

    public void setMobCumber(String mobCumber) {
        this.mobCumber = mobCumber;
    }


    //And Getter and Setter


    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", Cartridges=" + Cartridges +
                ", nameCompany='" + nameCompany + '\'' +
                ", mobCumber='" + mobCumber + '\'' +
                '}';
    }
}//and Class
