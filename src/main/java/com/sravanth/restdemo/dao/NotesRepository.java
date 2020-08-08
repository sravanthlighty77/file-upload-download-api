/**
 * 
 */
package com.sravanth.restdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sravanth.restdemo.entity.NotesEntity;

/**
 * @author srava
 *
 */
public interface NotesRepository extends  JpaRepository<NotesEntity, Integer> {

}
