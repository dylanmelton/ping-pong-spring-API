package PingPong.PingPong.domain;

import java.util.Objects;

public class PingPong {
    public Integer id;
    public String player1;
    public String player2;
    public Integer player1_score;
    public Integer player2_score;



    public PingPong(){

    }

    public PingPong(String player1, String player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public PingPong(Integer id, String player1, String player2, Integer player1_score, Integer player2_score) {
        this.id = id;
        this.player1 = player1;
        this.player2 = player2;
        this.player1_score = player1_score;
        this.player2_score = player2_score;
    }

    public void update(PingPong pingPong) {
        if (!Objects.isNull(pingPong.player1)){
            player1 = pingPong.player1;
        }
        if (!Objects.isNull(pingPong.player2)){
            player2 = pingPong.player2;
        }
        if (!Objects.isNull(pingPong.player1_score)){
            player1_score = pingPong.player1_score;
        }
        if (!Objects.isNull(pingPong.player2_score)){
            player2_score = pingPong.player2_score;
        }
    }

}

