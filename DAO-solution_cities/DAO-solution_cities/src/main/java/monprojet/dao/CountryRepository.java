package monprojet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import monprojet.dao.CountryNamePopulation;
import monprojet.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query(value = "SELECT SUM(c.population) FROM City c WHERE c.country.id = :countryId")
    public Long calculatePopulationByCountryId(Integer countryId);
    @Query("SELECT count.name, cit.population FROM Country count JOIN count.cities cit GROUP BY country.id")
    List<CountryNamePopulation> findCountryPopulation();


    }


