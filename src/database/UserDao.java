package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.vo.user.UserVo;

public class UserDao {
    

    Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
    
    /* JOIN MEMBER */
    public UserVo joinMember(UserVo user){

        UserVo vo = new UserVo();
        try {
            conn = DatabaseConnector.getConnection();
            String query = "SELECT * FROM TB_USER  WHERE user_id =? AND user_pw = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUserPw());
            rs = pstmt.executeQuery();
           
            while(rs.next()){
                vo.setUserId(rs.getString(1));
                vo.setUserPw(rs.getString(2));
                vo.setRegDate(rs.getDate(3));
                vo.setDelDate(rs.getDate(4));
                } 
                DatabaseConnector.close(rs);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return vo;
    }

}
