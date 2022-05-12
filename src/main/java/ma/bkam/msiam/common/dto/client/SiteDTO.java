package ma.bkam.msiam.common.dto.client;


public class SiteDTO{

    private long id;
    private  String nomSite;
    private String abrev;
    private VilleDTO ville;
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
     * Gets nom site.
     *
     * @return the nom site
     */
    public String getNomSite() {
        return nomSite;
    }

    /**
     * Sets nom site.
     *
     * @param nomSite the nom site
     */
    public void setNomSite(String nomSite) {
        this.nomSite = nomSite;
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
     * Gets ville.
     *
     * @return the ville
     */
    public VilleDTO getVille() {
        return ville;
    }

    /**
     * Sets ville.
     *
     * @param ville the ville
     */
    public void setVille(VilleDTO ville) {
        this.ville = ville;
    }


    }