package edu.uchicago.mhmcdonald.domain;

import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by markmcdonald on 8/17/16.
 */
@Entity
public class Episode {
    @Id
    @GeneratedValue
    private Long id;

    private Integer episodeNum;

    private String episodeName;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(columnDefinition = "TEXT")
    private String episodeDesc;

    @ManyToOne
    private Season season;

    private String imgurl;

    public Episode(String episodeDesc, Season season, String imgurl, Integer episodeNum, String episodeName) {
        this.episodeDesc = episodeDesc;
        this.season = season;
        this.imgurl = imgurl;
        this.episodeNum = episodeNum;
        this.episodeName = episodeName;
        this.createTime = new Date();
    }

    public Episode(){

    }

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
