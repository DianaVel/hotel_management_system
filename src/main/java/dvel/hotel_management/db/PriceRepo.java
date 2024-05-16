package dvel.hotel_management.db;

import dvel.hotel_management.domain.Price;
import dvel.hotel_management.domain.RoomType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PriceRepo extends CrudRepository<Price, Double> {
    Set<RoomType> findRoomTypesByPriceIsBetween(double minPrice, double maxPrice);
}
