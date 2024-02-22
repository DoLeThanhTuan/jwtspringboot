package com.dolethanhtuan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dolethanhtuan.entity.MyUserEntity;

public interface MyUserRepository extends JpaRepository<MyUserEntity, Long>{
	Optional<MyUserEntity> findOneByUsernameAndStatus(String username,int status);
}
