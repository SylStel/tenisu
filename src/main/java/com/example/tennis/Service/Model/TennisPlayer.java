package com.example.tennis.Service.Model;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TennisPlayer {
    private int id;
    private String firstname;
    private String lastname;
    private String shortname;
    private String sex;
    private Country country;
    private String picture;
    private PlayerData data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public PlayerData getData() {
        return data;
    }

    public void setData(PlayerData data) {
        this.data = data;
    }


    public static class Country {
        private String picture;
        private String code;

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    public static class PlayerData {
        private int rank;
        private int points;
        private int weight;
        private int height;
        private int age;
        private int[] last;

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int[] getLast() {
            return last;
        }

        public void setLast(int[] last) {
            this.last = last;
        }
    }

    public String convertToJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getTennisPlayerInfo() {
        StringBuilder info = new StringBuilder();

        String lineBreak = "<br>";
        info.append("id : ").append(this.getId()).append(lineBreak);
        info.append("firstname : ").append(this.getFirstname()).append(lineBreak);
        info.append("lastname : ").append(this.getLastname()).append(lineBreak);
        info.append("shortname : ").append(this.getShortname()).append(lineBreak);
        info.append("sex : ").append(this.getSex()).append(lineBreak);

        if (this.getCountry() != null) {
            info.append("country.picture : ").append(this.getCountry().getPicture()).append(lineBreak);
            info.append("country.code : ").append(this.getCountry().getCode()).append(lineBreak);
        }

        info.append("picture : ").append(this.getPicture()).append(lineBreak);

        if (this.getData() != null) {
            info.append("data.rank : ").append(this.getData().getRank()).append(lineBreak);
            info.append("data.points : ").append(this.getData().getPoints()).append(lineBreak);
            info.append("data.weight : ").append(this.getData().getWeight()).append(lineBreak);
            info.append("data.height : ").append(this.getData().getHeight()).append(lineBreak);
            info.append("data.age : ").append(this.getData().getAge()).append(lineBreak);

            info.append("data.last : [");
            int[] last = this.getData().getLast();
            for (int i = 0; i < last.length; i++) {
                info.append(last[i]);
                if (i < last.length - 1) {
                    info.append(", ");
                }
            }
            info.append("]\n");
        }

        return info.toString();
    }

}
