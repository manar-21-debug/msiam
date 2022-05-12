package ma.bkam.msiam.common.dto;

import ma.bkam.msiam.dao.model.UserEntity;

public class UserDTO extends GenericDTO{
    private String nom;
    private String prenom;
    private String adressEmail;
    private String numeroTelephone;
    private String profil;
    private String entite;
    private String fonction;
    private String zone;
    private String ville;
    private String site;
    private String batiment;
    private String motDePasse;
    private String status;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdressEmail() {
        return adressEmail;
    }

    public void setAdressEmail(String adressEmail) {
        this.adressEmail = adressEmail;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getEntite() {
        return entite;
    }

    public void setEntite(String entite) {
        this.entite = entite;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getBatiment() {
        return batiment;
    }

    public void setBatiment(String batiment) {
        this.batiment = batiment;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public UserEntity convertToEntity() {
        UserEntity user=new UserEntity();
        user.setId(this.id);
        user.setNom(this.nom);
        user.setPrenom(this.prenom);
        user.setAdressEmail(this.adressEmail);
        user.setNumeroTelephone(this.numeroTelephone);
        user.setProfil(this.profil);
        user.setEntite(this.entite);
        user.setFonction(this.fonction);
        user.setZone(this.zone);
        user.setVille(this.ville);
        user.setSite(this.site);
        user.setBatiment(this.batiment);
        user.setMotDePasse(this.motDePasse);
        user.setStatus(this.status);
        return user;
    }
}
