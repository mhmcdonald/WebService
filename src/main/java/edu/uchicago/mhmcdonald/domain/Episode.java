package edu.uchicago.mhmcdonald.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;

/**
 * Created by markmcdonald on 8/17/16.
 */

//this is my Episode class. It defines the granular level of detail that makes up the tv show's episode objects
@Entity
public class Episode {
    @Id
    @GeneratedValue
    private Long id;
    //long id is simply a system generated value. It acts as the H2's primary key so no duplicates are allowed

    @Min(1)
    private Integer episodeNum;
    //this is the episode number within a season
    @NotEmpty
    private String episodeName;
    //episode name corresponds with a particular location where the show is set

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    //this is not very useful, but I used it because Prof Gerber used it in his example. Could be removed.
    @NotEmpty
    @Column(columnDefinition = "TEXT")
    private String episodeDesc;
    //The show description is a few sentences of text describing what happens in the episode.

    @ManyToOne
    private Season season;
    //there is a many to one relationship between episodes and seasons (apprx 10 episodes per a given season)
    @NotEmpty
    private String imgurl;
    //included a screen snippet of each episode to be viewed on the detail page of the site

    //this is the constructor method with the args
    public Episode(String episodeDesc, Season season, String imgurl, Integer episodeNum, String episodeName) {
        this.episodeDesc = episodeDesc;
        this.season = season;
        this.imgurl = imgurl;
        this.episodeNum = episodeNum;
        this.episodeName = episodeName;
        this.createTime = new Date();
    }

    //no arg constructor
    public Episode() {

    }

    //various getter and setter methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEpisodeNum() {
        return episodeNum;
    }

    public void setEpisodeNum(Integer episodeNum) {
        this.episodeNum = episodeNum;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getEpisodeDesc() {
        return episodeDesc;
    }

    public void setEpisodeDesc(String episodeDesc) {
        this.episodeDesc = episodeDesc;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", episodeNum=" + episodeNum +
                ", episodeName='" + episodeName + '\'' +
                ", createTime=" + createTime +
                ", episodeDesc='" + episodeDesc + '\'' +
                ", season=" + season +
                ", imgurl='" + imgurl + '\'' +
                '}';
    }
}
