package edu.uchicago.mhmcdonald;

import edu.uchicago.mhmcdonald.domain.Season;
import edu.uchicago.mhmcdonald.domain.Episode;
import edu.uchicago.mhmcdonald.repository.EpisodeRepository;
import edu.uchicago.mhmcdonald.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Arrays;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;



@SpringBootApplication
public class ProWebserviceApplication implements CommandLineRunner {

	@Autowired
	private SeasonRepository seasonRepository;

	@Autowired
	private EpisodeRepository episodeRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProWebserviceApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        Season[] seasons = new Season[6];
        seasons[0] = new Season(1, "Season 1");
        seasons[1] = new Season(2,"Season 2");
        seasons[2] = new Season(3, "Season 3");
        seasons[3] = new Season(4, "Season 4");
        seasons[4] = new Season(5, "Season 5");
        seasons[5] = new Season(6, "Season 6");

        seasonRepository.save(Arrays.asList(seasons));

        Episode[] episodes = new Episode[5];
        episodes[0] = new Episode("Bourdain looks at the Congo as one of the more industrialized powers in Africa now largely crumbled to nothingness and chaos with Tim Butcher author of Blood River.", seasons[0], "http://static-api.guidebox.com/new_thumbs/thumbnails_episodes/15696-8-1-1370761200-1054908778-large-400x225.jpg", 8, "Congo");
        episodes[1] = new Episode("Few cities have experienced such a dramatic economic rise and fall of Detroit. In this episode of Parts Unknown, Bourdain explores the past, present and future of the Motor City. He steps into the lives of Detroit natives and sees the glory days of the past at the famed Packard Plant, the current state of the city's urban decay, and the promise of the future in the citizens who are rebuilding their communities.", seasons[1], "http://static-api.guidebox.com/new_thumbs/thumbnails_episodes/15696-8-2-1384070400-9384480598-large-400x225.jpg", 8, "Detroit");
        episodes[2] = new Episode("Parts Unknown takes a close look at the mash-up of cultures that comprise this uniquely American state by sampling its food – a combination of Spanish, Mediterranean, Mexican, Pueblo and even chuck-wagon influences. New Mexico is also a land of drugs, guns, monster vehicles, and possibly extraterrestrials. It may also be the perfect place to investigate the underside of the Western cowboy ideal.", seasons[1], "http://static-api.guidebox.com/new_thumbs/thumbnails_episodes/15696-3-2-1380438000-5576674333-large-400x225.jpg", 3, "New Mexico");
        episodes[3] = new Episode("In the Season 3 premiere of Anthony Bourdain Parts Unknown Tony explores Punjab -- one of the most beautiful and relatively unknown areas of India. Punjab is the Sikh Holy Land and is also India's agricultural breadbasket.", seasons[2], "http://static-api.guidebox.com/thumbs03_14/thumbnails_episodes/15696-1-3-1397372400-1010416160-large-400x225.jpg", 1, "Punjab");
        episodes[4] = new Episode("Bourdain and his crew head to the Chiang Mai province of Northern Thailand along with celebrated chef and Thai food specialist Andy Ricker (Pok Pok restaurants) to explore the country's distinctive eating and drinking scene that varies by region and season.", seasons[2], "http://static-api.guidebox.com/041014/thumbnails_episodes/15696-7-3-1401606000-5346590746-large-400x225.jpg", 7, "Thailand");

        episodeRepository.save(Arrays.asList(episodes));
    }


}
