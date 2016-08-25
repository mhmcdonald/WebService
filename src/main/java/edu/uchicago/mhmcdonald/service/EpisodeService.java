package edu.uchicago.mhmcdonald.service;

import edu.uchicago.mhmcdonald.domain.Episode;


/**
 * Created by markmcdonald on 8/17/16.
 * EpisodeService interface defines the CRUD methods
 */
public interface EpisodeService {
    Iterable<Episode> list();
    Episode create(Episode episode);
    Episode read(long id);
    Episode update(long id, Episode episode);
    void delete(long id);

    Episode getEpisodeById(Long id);
    Episode saveEpisode(Episode episode);
}
