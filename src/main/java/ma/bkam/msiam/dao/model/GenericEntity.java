package ma.bkam.msiam.dao.model;

import ma.bkam.msiam.common.dto.GenericDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * The type Generic entity.
 *  @author Alae Eddine Manar
 */
@MappedSuperclass
public abstract class GenericEntity {

    /**
     * The Id.
     */
    Long id;


    /**
     * Convert to dto t.
     *
     * @param <T> the type parameter
     * @return the t
     */
    public abstract  <T extends GenericDTO> T convertToDto();

    /**
     * Gets id.
     *
     * @return the id
     */
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }
}
