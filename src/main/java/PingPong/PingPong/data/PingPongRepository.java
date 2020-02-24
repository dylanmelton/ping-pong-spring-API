package PingPong.PingPong.data;

import PingPong.PingPong.domain.PingPong;

public interface PingPongRepository {
    Iterable<PingPong> findAll();

    PingPong findById(Integer id);

    PingPong save(PingPong pingPong);

    void delete(Integer id);
}
