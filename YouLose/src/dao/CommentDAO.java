package dao;

import java.util.HashMap;

import model.Comment;

public class CommentDAO {
	private static CommentDAO instance;
	private static final HashMap<String, Comment> allVideos = new HashMap<>();//


	public synchronized CommentDAO getInstance() {
		if (instance == null) {
			instance = new CommentDAO();
		}
		return instance;
	}
}
