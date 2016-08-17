package edu.uchicago.mhmcdonald.service;

import edu.uchicago.mhmcdonald.domain.Episode;
import edu.uchicago.mhmcdonald.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by markmcdonald on 8/17/16.
 */
public class EpisodeServiceImpl implements EpisodeService {

    private EpisodeRepository episodeRepository;

    @Autowired
    public EpisodeServiceImpl(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    @Override
    public Iterable<Episode> list() {
        return episodeRepository.findAll();
    }

    @Override
    public Episode create(Episode episode) {
        return episodeRepository.save(episode);
    }
//not sure about this one!
    @Override
    public Episode read(Episode episode) {
        return episodeRepository.findOne(episode.getId());
    }

    @Override
    public Episode update(long id, Episode episode) {
        Episode episodeInitial = episodeRepository.findOne(id);
            episodeInitial.setEpisodeName(episode.getEpisodeName());
            episodeInitial.setEpisodeDesc(episode.getEpisodeDesc());
            episodeInitial.setEpisodeNum(episode.getEpisodeNum());
            episodeInitial.setSeason(episode.getSeason());
            episodeInitial.setImgurl(episode.getImgurl());

        return episodeRepository.save(episodeInitial);
    }

    @Override
    public void delete(long id) {
    episodeRepository.delete(id);
    }
}
