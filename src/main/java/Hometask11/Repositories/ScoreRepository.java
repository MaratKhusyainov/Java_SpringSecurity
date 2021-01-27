package Hometask11.Repositories;


import Hometask11.Entities.Score;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository  extends CrudRepository<Score,Long> {

}
