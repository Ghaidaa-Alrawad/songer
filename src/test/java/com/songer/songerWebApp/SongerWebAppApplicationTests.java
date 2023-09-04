package com.songer.songerWebApp;

import com.songer.songerWebApp.model.Album;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SongerWebAppApplicationTests {

	@Test
	public void testGetTitle() {
		Album album = new Album("Album Title", "Artist", 11, 46, "img.jpg");
		assertEquals("Album Title", album.getTitle());
	}

	@Test
	public void testGetArtist() {
		Album album = new Album("Album Title", "Artist", 11, 46, "img.jpg");
		assertEquals("Artist", album.getArtist());
	}

	@Test
	public void testGetSongCount() {
		Album album = new Album("Album Title", "Artist", 11, 46, "img.jpg");
		assertEquals(11, album.getSongCount());
	}

	@Test
	public void testGetLength() {
		Album album = new Album("Album Title", "Artist", 11, 46, "image.jpg");
		assertEquals(46, album.getLength());
	}

	@Test
	public void testGetImageUrl() {
		Album album = new Album("Album Title", "Artist", 11, 46, "img.jpg");
		assertEquals("img.jpg", album.getImgUrl());
	}

}
