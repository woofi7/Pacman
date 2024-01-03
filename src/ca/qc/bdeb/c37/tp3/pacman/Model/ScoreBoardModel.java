package ca.qc.bdeb.c37.tp3.pacman.Model;

/**
 *
 * @author Nicolas
 */
public class ScoreBoardModel {
    private int score;
    private int scoreMultiplier = 1;

    public ScoreBoardModel() {
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScoreMultiplier(int scoreMultiplier) {
        this.scoreMultiplier = scoreMultiplier;
    }

    public int getScoreMultiplier() {
        return scoreMultiplier;
    }
}
