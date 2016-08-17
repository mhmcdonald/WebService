package edu.uchicago.mhmcdonald.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by markmcdonald on 8/17/16.
 */
@Entity
public class Season {

    @Id
    @GeneratedValue
    private Long id;

    private Integer seasonNum;

    private String seasonName;

    public Season(Integer seasonNum, String seasonName){
        this.seasonNum = seasonNum;
        this.seasonName = seasonName;
    }

    public Season(){
    }

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
