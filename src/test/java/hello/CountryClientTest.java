package hello;

import hello.wsdl.GetCountryResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryClientTest {

    @Autowired
    private CountryClient countryClient;

    @Test
    public void testCountry(){
        GetCountryResponse response = countryClient.getCountry("Spain");
        assertThat(response.getCountry().getCapital() == "Madrid");
    }
}
