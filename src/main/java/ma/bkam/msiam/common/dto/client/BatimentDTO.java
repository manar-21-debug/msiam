package ma.bkam.msiam.common.dto.client;


public class BatimentDTO  {

    private long id;
    private String nomBatiment;
    private String abrev;
    private SiteDTO site;

    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets nom batiment.
     *
     * @return the nom batiment
     */
    public String getNomBatiment() {
        return nomBatiment;
    }

    /**
     * Sets nom batiment.
     *
     * @param nomBatiment the nom batiment
     */
    public void setNomBatiment(String nomBatiment) {
        this.nomBatiment = nomBatiment;
    }

    /**
     * Gets abrev.
     *
     * @return the abrev
     */
    public String getAbrev() {
        return abrev;
    }

    /**
     * Sets abrev.
     *
     * @param abrev the abrev
     */
    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    /**
     * Gets site.
     *
     * @return the site
     */
    public SiteDTO getSite() {
        return site;
    }

    /**
     * Sets site.
     *
     * @param site the site
     */
    public void setSite(SiteDTO site) {
        this.site = site;
    }


}

