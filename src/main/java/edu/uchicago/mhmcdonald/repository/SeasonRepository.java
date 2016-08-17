package edu.uchicago.mhmcdonald.repository;

import edu.uchicago.mhmcdonald.domain.Season;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by markmcdonald on 8/17/16.
 */
public interface SeasonRepository extends CrudRepository<Season, Long> {
}
