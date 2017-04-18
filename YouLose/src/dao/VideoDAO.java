package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import model.Comment;
import model.Playlist;
import model.User;
import model.Video;

public class VideoDAO {

	private static VideoDAO instance;
	private static final HashMap<String, Video> allVideos = new HashMap<>();//


	public synchronized VideoDAO getInstance() {
		if (instance == null) {
			instance = new VideoDAO();
		}
		return instance;
	}

	public HashMap<String, Video> getAllVideos() {
		String sql = "SELECT videos_id, name, path, views,date,description FROM videos;";
		if (allVideos.isEmpty()) {
			PreparedStatement st;
			try {
				st = DBManager.getInstance().getConnection().prepareStatement(sql);
				ResultSet res = st.executeQuery();
				while (res.next()) {
					Video video = new Video();
					video.setId(res.getInt("videos_id"));
					video.setName(res.getString("name"));
					video.setPath(res.getString("path"));
					video.setViews(res.getInt("views"));
					video.setDate(res.getTimestamp("date").toLocalDateTime());
					video.setDescription(res.getString("description"));
					allVideos.put(video.getName(), video);
				}
			} catch (SQLException e) {
				System.out.println("problem in getting a video ");
				e.printStackTrace();
			}

		}
		return allVideos;
	}

	public HashMap<String, Video> searchAllByString(String partOfName) {
		String sql = "SELECT videos_id, name, path, views,date,description FROM videos WHERE name " + "like '"
				+ partOfName + "';";
		if (allVideos.isEmpty()) {
			PreparedStatement st;
			try {
				st = DBManager.getInstance().getConnection().prepareStatement(sql);
				ResultSet res = st.executeQuery();
				while (res.next()) {
					Video video = new Video();
					video.setId(res.getInt("videos_id"));
					video.setName(res.getString("name"));
					video.setPath(res.getString("path"));
					video.setViews(res.getInt("views"));
					video.setDate(res.getTimestamp("date").toLocalDateTime());
					video.setDescription(res.getString("description"));
					allVideos.put(video.getName(), video);
				}
			} catch (SQLException e) {
				System.out.println("problem in getting a video by this search");
				e.printStackTrace();
			}

		}
		return allVideos;
	}

	public void addVideo(Video video, User user) {// TODO ADD PUBLISHER TO DB
													// ???
		Connection con = DBManager.getInstance().getConnection();
		PreparedStatement st;
		try {
			st = con.prepareStatement("INSERT INTO videos (name, path, views,date,description) VALUES (?,?,?,?,?);");
			st.setString(1, video.getName());
			st.setString(2, video.getName());
			st.setInt(3, video.getViews());
			// TODO st.setTimestamp(4, video.getDate());
			// st.setPublisher(.....,video.getPublisher());
			st.setString(5, video.getDescription());
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println("not added to db ");
			e.printStackTrace();
		}

	}

	public void likeVideo(Video video, User user) {
		Connection con = DBManager.getInstance().getConnection();
		PreparedStatement st;
		try {
			st = con.prepareStatement(
					"INSERT INTO video_liked_or_disliked (users_user_id, videos_videos_id,like_or_dislike) VALUES (?,?,?);");
			st.setInt(1, video.getId());
			st.setInt(2, user.getUserID());
			// TODO LIKES OR DISLIKES ?? LIKES -1 DISLIKES -2
			st.setInt(3, 1);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(" NOT liked");
			e.printStackTrace();
		}

	}

	public void dislikeVideo(Video video, User user) {
		Connection con = DBManager.getInstance().getConnection();
		PreparedStatement st;
		try {
			st = con.prepareStatement(
					"INSERT INTO video_liked_or_disliked (users_user_id, videos_videos_id,like_or_dislike) VALUES (?,?,?);");
			st.setInt(1, video.getId());
			st.setInt(2, user.getUserID());
			// TODO LIKES OR DISLIKES ?? LIKES -1 DISLIKES -2
			st.setInt(3, 2);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(" NOT disliked");
			e.printStackTrace();
		}

	}

	public void removeLikeFromVideo(Video video, User user) {
		Connection con = DBManager.getInstance().getConnection();
		PreparedStatement st;
		try {
			st = con.prepareStatement("DELETE FROM video_liked_or_disliked WHERE users_user_id=" + user.getUserID()
					+ " AND videos_videos_id=" + video.getId() + " AND like_or_dislike=1 ;");
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(" NOT deleted like");
			e.printStackTrace();
		}
	}

	public void removeDislikeFromVideo(Video video, User user) {
		Connection con = DBManager.getInstance().getConnection();
		PreparedStatement st;
		try {
			st = con.prepareStatement("DELETE FROM video_liked_or_disliked WHERE users_user_id=" + user.getUserID()
					+ " AND videos_videos_id=" + video.getId() + " AND like_or_dislike=2 ;");
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(" NOT deleted dislike");
			e.printStackTrace();
		}
	}

	public void deleteVideo(Video video, User user) {
		if (user.getUserID() == video.getPublisher()) {
			Connection con = DBManager.getInstance().getConnection();
			PreparedStatement st;
			try {
				st = con.prepareStatement("DELETE FROM videos WHERE videos_id=" + video.getId() + ";");
				st.executeUpdate();
			} catch (SQLException e) {
				System.out.println(" NOT deleted video");
				e.printStackTrace();
			}
		}
	}

	public void addVideoToPlayList(Video video, Playlist playlist) {
		Connection con = DBManager.getInstance().getConnection();
		PreparedStatement st;
		try {
			st = con.prepareStatement(
					"INSERT INTO playlist_videos (videos_videos_id,playlists_playlist_id) VALUES (?,?);");
			st.setInt(1, video.getId());
			st.setInt(2, playlist.getPlaylistID());
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(" NOT video added to playlist");
			e.printStackTrace();
		}
	}

	public void removeVideoFromPlaylist(Video video, Playlist playlist) {
		Connection con = DBManager.getInstance().getConnection();
		PreparedStatement st;
		try {
			st = con.prepareStatement("DELETE FROM playlist_videos WHERE videos_videos_id= " + video.getId()
					+ " playlists_playlist_id=" + playlist.getPlaylistID() + ";");

			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(" NOT video deleted from playlist");
			e.printStackTrace();
		}
	}

	public void viewVideo(Video video) {
		String sql = "SELECT views FROM videos WHERE videos_id=" + video.getId() + ";";
		if (allVideos.isEmpty()) {
			PreparedStatement st;
			try {
				st = DBManager.getInstance().getConnection().prepareStatement(sql);
				ResultSet res = st.executeQuery();
				while (res.next()) {
					video.setId((res.getInt("videos_id") + 1));
				}
			} catch (SQLException e) {
				System.out.println("problem in viewing a video");
				e.printStackTrace();
			}
		}
	}
	
	public void commentVideo(Comment comment,Video video, User user){
		//TODO DA OPRAVIM V DB  nqkoi danni za comment 
		Connection con = DBManager.getInstance().getConnection();
		PreparedStatement st;
		try {
			st = con.prepareStatement(
					"INSERT INTO comments (users_user_id,video_id,content,postedDate) VALUES (?,?,?,?);");
			st.setInt(1, user.getUserID());
			st.setInt(2,video.getId());
			st.setString(3, comment.getContent());
			//TODO DATE THINGS
		//	st.setTimestamp(4,comment.getPostedDate());
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println("NOT commented video");
			e.printStackTrace();
		}
	}
	
	public void deleteComment(Comment comment){
		Connection con = DBManager.getInstance().getConnection();
		PreparedStatement st;
		try {
			st = con.prepareStatement("DELETE FROM comments WHERE comment_id= " +comment.getCommentID()+ ";");

			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(" NOT comment deleted");
			e.printStackTrace();
		}
	}
}
