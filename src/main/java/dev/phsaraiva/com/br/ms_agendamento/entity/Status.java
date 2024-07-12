package dev.phsaraiva.com.br.ms_agendamento.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_status")
public class Status {

    @Id
    private long statusID;

    private String description;

    public Status() {
    }

    public Status(Long id , String description){
        this.statusID = id;
        this.description= description;
    }


    public long getStatusID() {
        return statusID;
    }

    public void setStatusID(long statusID) {
        this.statusID = statusID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Values{
        PENDING(1L , "pending"),
        SUCCESS(2L , "success"),
        ERROR(3L , "error"),
        CANCELED(4L , "canceled");

        private Long id;
        private String description;

        Values(Long id , String description){
            this.id = id;
            this.description= description;
        }

        public Status toStatus(){
            return new Status( id , description);
        }
    }

    
}
