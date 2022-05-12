package ma.bkam.msiam.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.bkam.msiam.common.dto.SignInDTO;
import ma.bkam.msiam.common.dto.UserDTO;
import ma.bkam.msiam.common.dto.client.BatimentDTO;
import ma.bkam.msiam.common.dto.client.SiteDTO;
import ma.bkam.msiam.common.dto.client.VilleDTO;
import ma.bkam.msiam.common.dto.client.ZoneDTO;
import ma.bkam.msiam.service.UserService;
import ma.bkam.msiam.swagger.SwaggerDocConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Api(tags = { SwaggerDocConst.USER_CONTROLLER_TAG})
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/add")
    @ApiOperation(SwaggerDocConst.CREATE)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){
        return ResponseEntity.status(HttpStatus.OK).body(service.create(user));
    }

    @PostMapping("/add/password")
    @ApiOperation(SwaggerDocConst.CREATE_PASSWORD)
    public ResponseEntity<UserDTO> createPassword(@RequestBody UserDTO user,String motDePasse){
        return ResponseEntity.status(HttpStatus.OK).body(service.ajoutPassword(user,motDePasse));
    }

    @GetMapping("/getAll")
    @ApiOperation(SwaggerDocConst.LIST)
    public ResponseEntity<List<UserDTO>> getAllUsers(){

        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }
    @ApiOperation(SwaggerDocConst.GET_ZONE_BY_LIBELLE)
    @GetMapping(value=("/getZonebylibelle/{libelle}"), produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<ZoneDTO>> getZonesbylibelle(@PathVariable String libelle) {
        return ResponseEntity.ok()
                .body(service.getZonebyLibelle(libelle));
    }

    @ApiOperation(SwaggerDocConst.GET_ALL_ZONES)
    @GetMapping(value=("/getAllZones"), produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ZoneDTO>> getZones() {
        return ResponseEntity.ok()
                .body(service.getallZones());
    }
    @ApiOperation(SwaggerDocConst.GET_ZONE_BY_LIBELLE)
    @GetMapping(value=("/getVilleByLibelle/{libelle}"), produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<VilleDTO>> getVilleByLibelle(@PathVariable String libelle) {
        return ResponseEntity.ok()
                .body(service.getVilleByLibelle(libelle));
    }

    @ApiOperation(SwaggerDocConst.GET_ALL_VILLES)
    @GetMapping(value=("/getAllVilles"), produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VilleDTO>> getVilles() {
        return ResponseEntity.ok()
                .body(service.getAllVilles());
    }

    @ApiOperation(SwaggerDocConst.GET_SITE_BY_LIBELLE)
    @GetMapping(value=("/getSiteByLibelle/{libelle}"), produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<SiteDTO>> getSiteByNom(@PathVariable String libelle) {
        return ResponseEntity.ok()
                .body(service.getSiteByName(libelle));
    }

    @ApiOperation(SwaggerDocConst.GET_ALL_SITES)
    @GetMapping(value=("/getAllSites"), produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SiteDTO>> getSites() {
        return ResponseEntity.ok()
                .body(service.getAllSites());
    }


    @ApiOperation(SwaggerDocConst.GET_BATIMENT_BY_LIBELLE)
    @GetMapping(value=("/getBatimentByNom/{libelle}"), produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<BatimentDTO>> getBatimentByNom(@PathVariable String libelle) {
        return ResponseEntity.ok()
                .body(service.getBatimentByName(libelle));
    }



    @ApiOperation(SwaggerDocConst.GET)
    @GetMapping(value=("/getUserById/{id}"), produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<UserDTO>> getUserById(@PathVariable long id) {
        return ResponseEntity.ok()
                .body(service.getbyID(id));
    }

    @ApiOperation(SwaggerDocConst.GET_ALL_BATIMENT)
    @GetMapping(value=("/getAllBatiment"), produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BatimentDTO>> getAllBatiment() {
        return ResponseEntity.ok()
                .body(service.getAllBatiments());
    }

    @ApiOperation(SwaggerDocConst.AUTHENTICATE_THE_USER)
    @PostMapping(value=("/authenticateTheUser"), produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> authenticateTheUser(@RequestBody SignInDTO signin) {
        return ResponseEntity.ok()
                .body(service.SignIn(signin));
    }





}


