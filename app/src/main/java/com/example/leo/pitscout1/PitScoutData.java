package com.example.leo.pitscout1;

/**
 * Created by leo on 1/20/17.
 */

public class PitScoutData {
    private int _id;
    private String team_num;
    private String shoots_low;
    private String shoots_high;
    private String picks_up;
    private String loads_gears;
    private String climbs;
    private String defense_type;
    private String ball_cap;

    public PitScoutData()
    {
    }
    public PitScoutData(String team_num, String shoots_low, String shoots_high,
                    String picks_up, String loads_gears, String climbs,
                    String defense_type, String ball_cap)
    {

        this.team_num=team_num;
        this.shoots_low=shoots_low;
        this.shoots_high=shoots_high;
        this.picks_up=picks_up;
        this.loads_gears=loads_gears;
        this.climbs=climbs;
        this.defense_type=defense_type;
        this.ball_cap=ball_cap;
    }

    public void setId(int id) {
        this._id = _id;
    }
    public int getId() {
        return _id;
    }

    public String getTeam_num() {
        return team_num;
    }
    public void setTeam_num(String team_num) {
        this.team_num = team_num;
    }

    public String getShoots_low() {
        return shoots_low;
    }
    public void setShoots_low(String shoots_low) {
        this.shoots_low = shoots_low;
    }

    public String getShoots_high() {
        return shoots_high;
    }
    public void setShoots_high(String shoots_high) {
        this.shoots_high = shoots_high;
    }

    public String getPicks_up() {
        return picks_up;
    }
    public void setPicks_up(String picks_up) {
        this.picks_up = picks_up;
    }

    public String getLoads_gears() {
        return loads_gears;
    }
    public void setLoads_gears(String loads_gears) {
        this.loads_gears = loads_gears;
    }

    public String getClimbs() {
        return climbs;
    }
    public void setClimbs(String climbs) {
        this.climbs = climbs;
    }

    public String getDefense_type() {
        return defense_type;
    }
    public void setDefense_type(String defense_type) {
        this.defense_type = defense_type;
    }

    public String getBall_cap() {
        return ball_cap;
    }
    public void setBall_cap(String ball_cap) {
        this.ball_cap = ball_cap;
    }

}