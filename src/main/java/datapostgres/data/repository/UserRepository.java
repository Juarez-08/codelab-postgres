package datapostgres.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import datapostgres.data.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
