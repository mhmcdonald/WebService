package edu.uchicago.mhmcdonald.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by markmcdonald on 8/17/16.
 * This class defines Season. I could have included Season as a variable of Episode, but this project required a
 * one to many relationship in the H2 database.
 */

/*this class describes the seasons. At latest development date there were 7 seasons of Parts Unkown Available
 this could have just as easily been included as an attribute of episode, but Prof Gerber required a one to
many relationship in the H2 tables */
@Entity
public class Season {

    @Id
    @GeneratedValue
    private Long id;
    //primary key, system generated
    private Integer seasonNum;
    //simple season indicator, ie "1"
    private String seasonName;
    //written out, as "Season 1"

    //season object constructor
    public Season(Integer seasonNum, String seasonName){
        this.seasonNum = seasonNum;
        this.seasonName = seasonName;
    }

    //no arg constructor
    public Season(){
    }

    //various getter and setter methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSeasonNum() {
        return seasonNum;
    }

    public void setSeasonNum(Integer seasonNum) {
        this.seasonNum = seasonNum;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }
}
