package com.oreilly.demo.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "officers")
public class Officer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  Integer id;
    @Enumerated(EnumType.STRING)
        private  Rank rank;
        private  String firstName;
        private  String lastName;

        public Officer(){

        }

        public Officer(Integer id, Rank rank, String firstName, String lastName){
            this.id = id;
            this.rank = rank;
            this.firstName = firstName;
            this.lastName = lastName;

        }
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Rank getRank() {
            return rank;
        }

        public void setRank(Rank rank) {
            this.rank = rank;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public boolean equals(Object obj){
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (Officer) obj;
            return Objects.equals(this.id, that.id) &&
                    Objects.equals(this.rank, that.rank) &&
                    Objects.equals(this.firstName, that.firstName) &&
                    Objects.equals(this.lastName, that.lastName);
        }

        @Override
    public int hashCode(){
            return Objects.hash(id,rank,firstName,lastName);
        }

        @Override
    public String toString(){
            return "Officers[" + "id=" + id + ", " + "rank=" + rank +
                    ", " + "firstname" + firstName + ", " + "lastname" + lastName + "]";
        }

    }

