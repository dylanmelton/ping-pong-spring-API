package PingPong.PingPong.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import PingPong.PingPong.domain.PingPong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcPingPongRepository implements PingPongRepository {
    private JdbcTemplate jdbc;

    @Autowired
    public void JdbcPingPongRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Iterable<PingPong> findAll() {
        return jdbc.query("SELECT * from ping_pong", this::mapRowToPingPong);
    }

    public PingPong findById(Integer id) {
        return jdbc.queryForObject("SELECT id," + "player1," + "player2," + "player1_score," + "player2_score FROM ping_pong WHERE id=?"
                , this::mapRowToPingPong, id);
    }

    private PingPong mapRowToPingPong(ResultSet rs, int rowNum) throws SQLException {
        return new PingPong(rs.getInt("id"), rs.getString("player1"), rs.getString("player2"),
                rs.getInt("player1_score"), rs.getInt("player2_score"));
    }

    public PingPong save(PingPong pingPong) {
        if (Objects.isNull (pingPong.id)) {
            return jdbc.queryForObject("INSERT INTO ping_pong (player1," + "player2," + "player1_score,"
                            + "player2_score) VALUES (?, ?, ?, ?) "
                            + "RETURNING id," + "player1," + "player2," + "player1_score," + "player2_score",
                    this::mapRowToPingPong, pingPong.player1, pingPong.player2, pingPong.player1_score,
                    pingPong.player2_score);
        } else {
            return jdbc.queryForObject("UPDATE ping_pong SET player1 = ?, " + "player2 = ?, " + "player1_score = ?, "
                            + "player2_score = ?" + "WHERE id = ? RETURNING id," + "player1," + "player2," + "player1_score," + "player2_score",
                    this::mapRowToPingPong, pingPong.player1, pingPong.player2, pingPong.player1_score,
                    pingPong.player2_score, pingPong.id);
        }

    }
    public void delete(Integer id){
        jdbc.update("DELETE from ping_pong WHERE id = ?", id);
    }
}


