package com.dunkin.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dunkin.app.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
