package com.company;

import javax.persistence.*;

/**
 * Created by v.pelenskyi on 08.07.2015.
 */
@Entity
@Table(name  = "Cartridge")
public class Cartridge extends DataBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name= "id_company")
    private Company company;

    public Company getCompany() {
        return company;
    }

    @Column (name = "model_cartridge")
    private String modelCartridge;

    @Column (name = "rq_link")
    private String rqLink;

    @Column (name = "number_link")
    private String numberLink;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Company getIdDataBase() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getModelCartridge() {
        return modelCartridge;
    }

    public void setModelCartridge(String modelCartridge) {
        this.modelCartridge = modelCartridge;
    }

    public String getRqLink() {
        return rqLink;
    }

    public void setRqLink(String rqLink) {
        this.rqLink = rqLink;
    }

    public String getNumberLink() {
        return numberLink;
    }

    public void setNumberLink(String numberLink) {
        this.numberLink = numberLink;
    }

    @Override
    public String toString() {
        return "Cartridge{" +
                "id=" + id +
                ", company=" + company +
                ", modelCartridge='" + modelCartridge + '\'' +
                ", rqLink='" + rqLink + '\'' +
                ", numberLink='" + numberLink + '\'' +
                '}';
    }
}
