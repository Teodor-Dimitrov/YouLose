package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;

import model.Comment;
import model.User;
import model.Video;

public class CommentDAO {
	private static CommentDAO instance;
	private static final HashSet< Comment> allComments = new HashSet<>();//

	public synchronized CommentDAO getInstance() {
		if (instance == null) {
			instance = new CommentDAO();
		}
		return instance;
	}

	public HashSet< Comment> getAllComments() throws SQLException {
		if (allComments.isEmpty()) {
			String sql = "SELECT users_user_id,video_id,content,postedDate FROM comments;";
				PreparedStatement st;
				
					st = DBManager.getInstance().getConnection().prepareStatement(sql);
					ResultSet res = st.executeQuery();
					while (res.next()) {
						Comment comment = new Comment();
						comment.setContent(res.getString("content"));
						comment.setUserID(res.getInt("users_user_id"));
						comment.setVideoID(res.getInt("video_id"));
						comment.setPostedDate(res.getTimestamp("postedDate").toLocalDateTime());
						allComments.add(comment);
					}
				

			}
			return allComments;
			// TODO
		}
	

	public void commentVideo(Comment comment, Video video, User user) throws SQLException {
		// TODO DA OPRAVIM V DB nqkoi danni za comment
		Connection con = DBManager.getInstance().getConnection();
		PreparedStatement st;
		
			st = con.prepareStatement(
					"INSERT INTO comments (users_user_id,video_id,content,postedDate) VALUES (?,?,?,?);");
			st.setInt(1, user.getUserID());
			st.setInt(2, video.getId());
			st.setString(3, comment.getContent());
			// TODO DATE THINGS
			// st.setTimestamp(4,comment.getPostedDate());
			st.executeUpdate();
		
	}
	
	public void deleteComment(Comment comment){
		
	}
}
