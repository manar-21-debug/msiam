package ma.bkam.msiam.common.dto;


import ma.bkam.msiam.dao.model.GenericEntity;

/**
 * The type Generic dto.
 *  @author Alae Eddine Manar
 */
public abstract class GenericDTO {


    /**
     * The Id.
     */
    Long id;


    /**
     * Convert to entity t.
     *
     * @param <T> the type parameter
     * @return the t
     */
    public abstract  <T extends GenericEntity>  T convertToEntity();


    /**
     * Gets id.
     *
     * @return the id
     */
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
