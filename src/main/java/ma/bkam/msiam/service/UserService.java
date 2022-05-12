package ma.bkam.msiam.service;


import ma.bkam.msiam.common.dto.SignInDTO;
import ma.bkam.msiam.common.dto.UserDTO;
import ma.bkam.msiam.common.dto.client.BatimentDTO;
import ma.bkam.msiam.common.dto.client.SiteDTO;
import ma.bkam.msiam.common.dto.client.VilleDTO;
import ma.bkam.msiam.common.dto.client.ZoneDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public UserDTO create(UserDTO user);
    public List<UserDTO> getAll();

    public Optional<UserDTO> getbyID(long id);
    public Optional<BatimentDTO> getUsersByBatiments(UserDTO user);
    public Optional<VilleDTO> getUsersByVille(UserDTO user);
    public Optional<SiteDTO> getUsersBySite(UserDTO user);
    public Optional<ZoneDTO> getZoneByUser(UserDTO user);

    public Optional<ZoneDTO> getZonebyLibelle(String libelle);
    public List<ZoneDTO> getallZones();

    public Optional<VilleDTO> getVilleByLibelle(String libelle);
    public List<VilleDTO> getAllVilles();


    public Optional<SiteDTO> getSiteByName(String libelle);
    public List<SiteDTO> getAllSites();


    public Optional<BatimentDTO> getBatimentByName(String libelle);
    public List<BatimentDTO> getAllBatiments();

    public UserDTO ajoutPassword(UserDTO user,String motDePasse);

    public String SignIn(SignInDTO signIn);







}
