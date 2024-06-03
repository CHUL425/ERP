package com.erp.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.erp.jdbc.dto.Board;

@Repository			// 데이터 액세스 객체로 빈 등록
public class BoardDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 게시글 목록 조회
	 * @return
	 */
	public List<Board> list() {
		
		String sql = "SELECT *    "
		           + "  FROM BOARD";
		List<Board> boardList = jdbcTemplate.query(sql, new RowMapper<Board>() {

			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board();
				board.setBoardNo(rs.getInt      ("board_no"));
				board.setTitle  (rs.getString   ("title"   ));
				board.setWriter (rs.getString   ("writer"  ));
				board.setContent(rs.getString   ("content" ));
				board.setRegDate(rs.getTimestamp("reg_date"));
				board.setUpdDate(rs.getTimestamp("upd_date"));
				board.setViews  (rs.getInt      ("views"   ));
				return board;
			}
		});
		
		return boardList;
	}

	/**
	 * 게시글 조회
	 * @param no
	 * @return
	 */
	public Board select(int boardNo) {
		
		String sql = "SELECT *           "
				   + "  FROM BOARD       "
				   + " WHERE BOARD_NO = ?";
		
		Board board = jdbcTemplate.queryForObject(sql, new RowMapper<Board>() {

			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board();
				board.setBoardNo(rs.getInt      ("board_no"));
				board.setTitle  (rs.getString   ("title"   ));
				board.setWriter (rs.getString   ("writer"  ));
				board.setContent(rs.getString   ("content" ));
				board.setRegDate(rs.getTimestamp("reg_date"));
				board.setUpdDate(rs.getTimestamp("upd_date"));
				board.setViews  (rs.getInt      ("views"   ));
				return board;
			}
		}, boardNo );
		
		return board;
	}

	/**
	 * 게시글 등록
	 * @param board
	 * @return
	 */
	public int insert(Board board) {
		
		String sql = " INSERT INTO BOARD "
		           + "        ( TITLE    "
				   + "        , WRITER   "
				   + "        , CONTENT  "
				   + "        )          "
				   + " VALUES ( ?, ?, ? )";
		Object[] args = new Object[] { board.getTitle()
			                         , board.getWriter()
									 , board.getContent()
									 };
									 
		int result = jdbcTemplate.update(sql, args);
		// int result = jdbcTemplate.update(sql, board.getTitle(), board.getWriter(), board.getContent());

		return result;
	}

	/**
	 * 게시글 수정
	 * @param board
	 * @return
	 */
	public int update(Board board) {
		
		String sql = "UPDATE BOARD           "
				   + "   SET TITLE    = ?    "
				   + "     , WRITER   = ?    "
				   + "     , CONTENT  = ?    "
				   + "     , UPD_DATE = now()"
				   + "WHERE BOARD_NO = ?     ";
				   
		String title   = board.getTitle()  ;
		String writer  = board.getWriter() ;
		String content = board.getContent();
		int    boardNo = board.getBoardNo();
		
		Object[] args = new Object[] {title, writer, content, boardNo};
		int result = jdbcTemplate.update(sql, args);
		
		return result;
	}

	/**
	 * 게시글 삭제
	 * @param no
	 * @return
	 */
	public int delete(int boardNo) {
		String sql = "DELETE FROM board  "
				   + " WHERE board_no = ?";
				   
		Object[] args = new Object[] { boardNo };
		int result = jdbcTemplate.update(sql, args);
		
		return result;
	}

}