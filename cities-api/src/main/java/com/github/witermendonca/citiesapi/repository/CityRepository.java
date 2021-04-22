package com.github.witermendonca.citiesapi.repository;

import com.github.witermendonca.citiesapi.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    //select distance from city 1 to city 2 in miles using extension Postgres Earth distance
    @Query(value = "SELECT ((SELECT lat_lon FROM cidade WHERE id=?1) <@> "
            + "(SELECT lat_lon FROM cidade WHERE id=?2)) as distance", nativeQuery = true)
    Double distanceByPoints(final Long cityId1, final Long cityId2);

    //select distance from city 1 to city 2 in meters using extension Postgres Cube
    @Query(value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance", nativeQuery = true)
    Double distanceByCube(final Double lat1, final Double lon1, final Double lat2, final Double lon2);
}
