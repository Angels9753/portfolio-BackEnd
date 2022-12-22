
package com.portfolio.cay.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String institucionPr;
    private String subtituloPr;
    private String descripcionPr;
    private String webPr;
    private String urlLogoPr;
    
    //Constructores

    public Proyecto() {
    }

    public Proyecto(String institucionPr, String subtituloPr, String descripcionPr, String webPr, String urlLogoPr) {
        this.institucionPr = institucionPr;
        this.subtituloPr = subtituloPr;
        this.descripcionPr = descripcionPr;
        this.webPr = webPr;
        this.urlLogoPr = urlLogoPr;
    }

     //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstitucionPr() {
        return institucionPr;
    }

    public void setInstitucionPr(String institucionPr) {
        this.institucionPr = institucionPr;
    }

    public String getSubtituloPr() {
        return subtituloPr;
    }

    public void setSubtituloPr(String subtituloPr) {
        this.subtituloPr = subtituloPr;
    }

    public String getDescripcionPr() {
        return descripcionPr;
    }

    public void setDescripcionPr(String descripcionPr) {
        this.descripcionPr = descripcionPr;
    }

    public String getWebPr() {
        return webPr;
    }

    public void setWebPr(String webPr) {
        this.webPr = webPr;
    }

    public String getUrlLogoPr() {
        return urlLogoPr;
    }

    public void setUrlLogoPr(String urlLogoPr) {
        this.urlLogoPr = urlLogoPr;
    }

   
    
}
