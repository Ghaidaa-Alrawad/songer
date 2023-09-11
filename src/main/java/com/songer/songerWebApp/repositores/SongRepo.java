package com.songer.songerWebApp.repositores;

import com.songer.songerWebApp.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepo extends JpaRepository<Song, Long> {
}
