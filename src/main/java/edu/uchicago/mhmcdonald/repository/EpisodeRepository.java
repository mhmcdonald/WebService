package edu.uchicago.mhmcdonald.repository;

import edu.uchicago.mhmcdonald.domain.Episode;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by markmcdonald on 8/17/16.
 */
public interface EpisodeRepository extends CrudRepository<Episode, Long> {
}
