package ma.bkam.msiam.common.dto.client;

public class VilleDTO {

    private long id;
    private String abrev;
    private String libelle;
    private ZoneDTO zone;

    /**
     * Gets zone.
     *
     * @return the zone
     */
    public ZoneDTO getZone() {
        return zone;
    }

    /**
     * Sets zone.
     *
     * @param zone the zone
     */
    public void setZone(ZoneDTO zone) {
        this.zone = zone;
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
     * Gets libelle.
     *
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Sets libelle.
     *
     * @param libelle the libelle
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


}
