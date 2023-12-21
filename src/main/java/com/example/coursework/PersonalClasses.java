package com.example.coursework;

public class PersonalClasses {
    int id_trainer;
    String trainer_name;
    String tr_number;
    String tr_job;
    int id_schedule;

    public PersonalClasses(int id_trainer, String trainer_name, String tr_number, String tr_job, int id_schedule) {
        this.trainer_name = trainer_name;
        this.tr_number = tr_number;
        this.tr_job = tr_job;
        this.id_schedule = id_schedule;
        this.id_trainer = id_trainer;
    }

    public PersonalClasses(String trainer_name, String tr_number, String tr_job) {
        this.trainer_name = trainer_name;
        this.tr_number = tr_number;
        this.tr_job = tr_job;
    }

    public int getId_trainer() {
        return id_trainer;
    }

    public void setId_trainer(int id_trainer) {
        this.id_trainer = id_trainer;
    }

    public String getTrainer_name() {
        return trainer_name;
    }

    public void setTrainer_name(String trainer_name) {
        this.trainer_name = trainer_name;
    }

    public String getTr_number() {
        return tr_number;
    }

    public void setTr_number(String tr_number) {
        this.tr_number = tr_number;
    }

    public String getTr_job() {
        return tr_job;
    }

    public void setTr_job(String tr_job) {
        this.tr_job = tr_job;
    }

    public int getId_schedule() {
        return id_schedule;
    }

    public void setId_schedule(int id_schedule) {
        this.id_schedule = id_schedule;
    }
}
