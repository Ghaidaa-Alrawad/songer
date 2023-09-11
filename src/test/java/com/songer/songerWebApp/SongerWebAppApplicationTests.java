package com.songer.songerWebApp;

import com.songer.songerWebApp.model.Album;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
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

	@Autowired
	MockMvc mockMvc;

	@Test
	public void testingPostToCreateAnAlbum() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
						.post("/albums/creat-album")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.param("title", "Testing")
						.param("artist", "Ghaidaa")
						.param("length", String.valueOf(20))
						.param("songCount", String.valueOf(2))
						.param("imgUrl", "image.jpg")
				)
				.andExpect(MockMvcResultMatchers.redirectedUrl("/albums"))
				.andExpect(MockMvcResultMatchers.status().isFound());
	}

	@Test
	public void testingPostToCreateSong() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
						.post("/add-song")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.param("songTitle", "Testing testing")
						.param("songLength", String.valueOf(100))
						.param("songTrackNumber", String.valueOf(2))
						.param("albumId", String.valueOf(6))
				)
				.andExpect(MockMvcResultMatchers.redirectedUrl("/albums"))
				.andExpect(MockMvcResultMatchers.status().isFound());
	}
}
