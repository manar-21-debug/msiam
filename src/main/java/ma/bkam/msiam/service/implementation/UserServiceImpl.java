package ma.bkam.msiam.service.implementation;

import ma.bkam.msiam.common.client.ZoneApi;
import ma.bkam.msiam.common.dto.SignInDTO;
import ma.bkam.msiam.common.dto.UserDTO;
import ma.bkam.msiam.common.dto.client.BatimentDTO;
import ma.bkam.msiam.common.dto.client.SiteDTO;
import ma.bkam.msiam.common.dto.client.VilleDTO;
import ma.bkam.msiam.common.dto.client.ZoneDTO;
import ma.bkam.msiam.common.email.EmailSender;
import ma.bkam.msiam.common.helper.EmailValidator;
import ma.bkam.msiam.common.utils.Utilities;
import ma.bkam.msiam.dao.model.UserEntity;
import ma.bkam.msiam.dao.repository.UserRepository;
import ma.bkam.msiam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private EmailValidator emailValidator;

    private EmailSender emailSender;

    private ZoneApi api;

    @Autowired
    private UserRepository repository;

    public UserServiceImpl(ZoneApi api) {
        this.api = api;
    }



    @Override
    public UserDTO create(UserDTO user) {
        checkUser(user);
        Optional<BatimentDTO> batiment=getBatimentByName(user.getBatiment());
        Optional<SiteDTO> site=getSiteByName(user.getSite());
        Optional<VilleDTO> ville=getVilleByLibelle(user.getVille());
        Optional<ZoneDTO> zone=getZonebyLibelle(user.getZone());
        if(batiment.isPresent() && site.isPresent() && ville.isPresent() && zone.isPresent()){
            Optional<UserEntity> theExisted=repository.getUserByEmail(user.getAdressEmail());
            if(theExisted.isPresent()){
                throw Utilities.raiseError("Email Already Token");
            }
            return repository.save(user.convertToEntity()).convertToDto();

        }
        throw Utilities.raiseError("Your informations or not Right");



    }


    @Override
    public List<UserDTO> getAll() {
        return repository.findAll().stream().map(UserEntity::convertToDto).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> getbyID(long id) {

        Optional<UserEntity> theExisted=repository.findById(id);
        if(theExisted.isPresent()){
            return Optional.ofNullable(theExisted.get().convertToDto());
        }throw Utilities.raiseError("user not found");
    }

    @Override
    public Optional<BatimentDTO> getUsersByBatiments(UserDTO user) {
        return getBatimentByName(user.getBatiment());
    }

    @Override
    public Optional<VilleDTO> getUsersByVille(UserDTO user) {
        return getVilleByLibelle(user.getVille());
    }

    @Override
    public Optional<SiteDTO> getUsersBySite(UserDTO user) {
        return getSiteByName(user.getSite());
    }

    @Override
    public Optional<ZoneDTO> getZoneByUser(UserDTO user) {
        return getZonebyLibelle(user.getZone());
    }


    @Override
    public Optional<ZoneDTO> getZonebyLibelle(String libelle) {

        ResponseEntity<Optional<ZoneDTO>> response= api.getByLibelle(libelle);
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();

        }
        throw Utilities.raiseError("NO_DATA");
    }

    @Override
    public List<ZoneDTO> getallZones() {
        ResponseEntity<List<ZoneDTO>> response= api.getAllZones();
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();

        }
        throw Utilities.raiseError("NO_DATA");
    }

    @Override
    public Optional<VilleDTO> getVilleByLibelle(String libelle) {
        ResponseEntity<Optional<VilleDTO>> response= api.getVilleByLibelle(libelle);
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();

        }
        throw Utilities.raiseError("NO_DATA");
    }

    @Override
    public List<VilleDTO> getAllVilles() {
        ResponseEntity<List<VilleDTO>> response= api.getAllVilles();
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();

        }
        throw Utilities.raiseError("NO_DATA");
    }

    @Override
    public Optional<SiteDTO> getSiteByName(String libelle) {
        ResponseEntity<Optional<SiteDTO>> response= api.getSiteByName(libelle);
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();

        }
        throw Utilities.raiseError("NO_DATA");
    }

    @Override
    public List<SiteDTO> getAllSites() {
        ResponseEntity<List<SiteDTO>> response= api.getAllSites();
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();

        }
        throw Utilities.raiseError("NO_DATA");
    }

    @Override
    public Optional<BatimentDTO> getBatimentByName(String libelle) {
        ResponseEntity<Optional<BatimentDTO>> response= api.getBatimentByName(libelle);
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();

        }
        throw Utilities.raiseError("NO_DATA");
    }

    @Override
    public List<BatimentDTO> getAllBatiments() {
        ResponseEntity<List<BatimentDTO>> response= api.getAllBatiments();
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();

        }
        throw Utilities.raiseError("NO_DATA");    }

    @Override
    public UserDTO ajoutPassword(UserDTO user, String motDePasse) {
       Optional<UserDTO> utilisateur= getbyID(user.getId());
       if(utilisateur.isPresent()){
           String encodedString = encodePassword(motDePasse);
           user.setMotDePasse(encodedString);
           UserDTO userDTO = repository.save(user.convertToEntity()).convertToDto();
           return userDTO;

       }
       throw Utilities.raiseError("No User with this informations");


    }

    @Override
    public String SignIn(SignInDTO signIn) {
        Optional<UserEntity> user=repository.getUserByEmail(signIn.getEmail());
        String encodedString = encodePassword(signIn.getPassword());

        if(user.isPresent() && user.get().getMotDePasse().equals(encodedString)){

            return "Authenticated Succefully";

        }throw Utilities.raiseError("Something Went Wrong ");
    }


    public String encodePassword(String motDePasse){
        String encodedString = Base64.getEncoder().encodeToString(motDePasse.getBytes());

        return encodedString;
    }

    public String decodePassword(String motDePasse){

        byte[] result = DatatypeConverter.parseBase64Binary(motDePasse);

        return new String(result);
    }

    public void checkUser(UserDTO user){
        if(Objects.isNull(user)
        || Utilities.isNullOrEmpty(user.getNom())
        || Utilities.isNullOrEmpty(user.getPrenom())
        || Utilities.isNullOrEmpty(user.getProfil())
        || Utilities.isNullOrEmpty(user.getEntite())
        || Utilities.isNullOrEmpty(user.getFonction())
        || Utilities.isNullOrEmpty(user.getZone())
        || Utilities.isNullOrEmpty(user.getVille())
        || Utilities.isNullOrEmpty(user.getSite())
        || Utilities.isNullOrEmpty(user.getBatiment())
        ){
            throw Utilities.raiseError("Missing Body Values");
        }
    }
}
