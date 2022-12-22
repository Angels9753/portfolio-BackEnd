
package com.portfolio.cay.Dto;

import jakarta.validation.constraints.NotBlank;

public class dtoProyecto {
    @NotBlank
    private String institucionPr;
    @NotBlank
    private String subtituloPr;
    private String descripcionPr;
    @NotBlank
    private String webPr;
    @NotBlank
    private String urlLogoPr;

    public dtoProyecto() {
    }

    public dtoProyecto(String institucionPr, String subtituloPr, String descripcionPr, String webPr, String urlLogoPr) {
        this.institucionPr = institucionPr;
        this.subtituloPr = subtituloPr;
        this.descripcionPr = descripcionPr;
        this.webPr = webPr;
        this.urlLogoPr = urlLogoPr;
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
