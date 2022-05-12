package ma.bkam.msiam.dao.repository;

import ma.bkam.msiam.dao.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @Query("SELECT u FROM USER u WHERE u.adressEmail = ?1")
    Optional<UserEntity> getUserByEmail(String email);
}
