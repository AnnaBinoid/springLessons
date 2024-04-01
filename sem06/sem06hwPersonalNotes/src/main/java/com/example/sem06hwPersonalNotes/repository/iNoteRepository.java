package com.example.sem06hwPersonalNotes.repository;

import com.example.sem06hwPersonalNotes.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * ��������� ����������� �������, ������������� �� JPARepository.
 * ��������� ������������ ������������� �������
 *  ����� ������������ � ������������. ������ ������ �����,
 *  ��������� ������� ����� ������ ���������� �����������,
 *  ��� �� ��������� �� �����������.
 */
@Repository
public interface iNoteRepository extends JpaRepository<Note, Long> {
    Optional<Note> findById(Long id);
}
