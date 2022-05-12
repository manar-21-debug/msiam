package ma.bkam.msiam.common.client;

import ma.bkam.msiam.common.dto.client.BatimentDTO;
import ma.bkam.msiam.common.dto.client.SiteDTO;
import ma.bkam.msiam.common.dto.client.VilleDTO;
import ma.bkam.msiam.common.dto.client.ZoneDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@PropertySource(value = "classpath:application.properties")
@FeignClient(
        name = "zoneapi",
        url = "${url.ms.zoneApi}")
public interface ZoneApi {


    @GetMapping(value = "zone/getByLibelle/{libelle}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<ZoneDTO>> getByLibelle(
            @PathVariable String libelle);

    @GetMapping(value = "zone/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ZoneDTO>> getAllZones();



    @GetMapping(value = "ville/getByLibelle/{libelle}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<VilleDTO>> getVilleByLibelle(
            @PathVariable String libelle);

    @GetMapping(value = "ville/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VilleDTO>> getAllVilles();


    @GetMapping(value = "site/getByLibelle/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<SiteDTO>> getSiteByName(
            @PathVariable String nom);

    @GetMapping(value = "site/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SiteDTO>> getAllSites();

    @GetMapping(value = "batiment/getByLibelle/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<BatimentDTO>> getBatimentByName(
            @PathVariable String nom);

    @GetMapping(value = "batiment/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BatimentDTO>> getAllBatiments();

}
