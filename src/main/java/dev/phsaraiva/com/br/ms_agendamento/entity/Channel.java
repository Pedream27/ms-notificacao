package dev.phsaraiva.com.br.ms_agendamento.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_channel")
public class Channel {

    @Id
    private long channelId;

    private String description;

    public Channel() {
    }

    public Channel(long id, String description2) {
        this.channelId = id;
        this.description = description2;
    }

    public long getChannelId() {
        return channelId;
    }

    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Values {
        EMAIL(1L, "email"),
        SMS(2L, "sms"),
        WHATSAPP(3L, "whatsapp");

        private Long id;
        private String description;

        Values(Long id, String description) {
            this.id = id;
            this.description = description;

        }

        public String getDiscription(){
            return this.description;
        }
        public Long toIdChannel (){
            return id;
        }

        public Channel toChannel(){
            return new Channel(id , description);
        }

    }

}
