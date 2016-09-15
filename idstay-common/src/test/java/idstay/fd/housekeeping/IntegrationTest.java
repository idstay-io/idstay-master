package idstay.fd.housekeeping;

import idstay.TestConfig;
import idstay.hotel.member.Crew;
import idstay.hotel.member.CrewService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
public class IntegrationTest {
    @Autowired
    CrewService crewService;

    @Autowired
    HousekeepingHistoryService housekeepingHistoryService;


    @Test
    public void aTest() {
        Crew min = new Crew("@min", Locale.ENGLISH, true);
        Crew chan = new Crew("@chan", Locale.ENGLISH, false);
        crewService.save(min);
        crewService.save(chan);

        assertThat(crewService.getAllCrews().size(), is(1));
    }

    @Test
    public void bTest() {
        Optional<List<HousekeepingHistory>> list = housekeepingHistoryService.findHistory(new Date(), new Date());
    }
}
