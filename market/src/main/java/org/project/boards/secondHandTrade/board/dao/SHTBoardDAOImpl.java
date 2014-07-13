package org.project.boards.secondHandTrade.board.dao;

import org.springframework.stereotype.Repository;

@Repository("")
public class SHTBoardDAOImpl implements SHTBoardDAO{
/*	
	@Resource(name="sqlMapClient")
	private SqlMapClient JboardQuery;
	
	@Override
	public int write(jhwBoardVO vo) {

		System.out.println("jhwDAOImpl      :: write");
		
		try {
			
			JboardQuery.insert("jhwbq.write", vo);
			
		} catch (SQLException e) {
			if(e.getErrorCode() != defineCode.SQLCODE_GOOD)
			{
				System.out.println("SQL ERROR CODE  :: " + e.getErrorCode());
				
				if(e.getErrorCode() != defineCode.SQLCODE_DUP)
				{
					System.out.println("SQL ERROR MSG   :: " + e.getMessage());
					return defineCode.SQLCODE_DUP;
				}
				else
				{
					System.out.println("SQL ERROR MSG   :: " + e.getMessage());
					return defineCode.SQLCODE_ELSE;
				}
			}
		}
		
		return defineCode.SQLCODE_GOOD;
		
	}

	@Override
	public jhwBoardVO read(int bbsNo) {
		
		System.out.println("jhwDAOImpl      :: read");

		jhwBoardVO vo = null;
		
		try {
			
			vo = (jhwBoardVO) JboardQuery.queryForObject("jhwbq.read", bbsNo);
			
		} catch (SQLException e) {
			if(e.getErrorCode() != defineCode.SQLCODE_GOOD)
			{			
				vo = new jhwBoardVO();
				
				System.out.println("SQL ERROR CODE  :: " + e.getErrorCode());
				
				if(e.getErrorCode() != defineCode.SQLCODE_NOTFOUND)
				{
					System.out.println("SQL ERROR MSG   :: " + e.getMessage());
					vo.setError_code(defineCode.SQLCODE_NOTFOUND);
					return vo;
				}
				else
				{
					System.out.println("SQL ERROR MSG   :: " + e.getMessage());
					vo.setError_code(defineCode.SQLCODE_ELSE);
					return vo;
				}
			}
		}
		
		return vo;
	}

	@Override
	public int update(jhwBoardVO vo) {
		
		System.out.println("jhwDAOImpl      :: update");
		
		try {
			
			JboardQuery.update("jhwbq.update", vo);
			
		} catch (SQLException e) {
			if(e.getErrorCode() != defineCode.SQLCODE_GOOD)
			{
				System.out.println("SQL ERROR CODE  :: " + e.getErrorCode());
				
				if(e.getErrorCode() != defineCode.SQLCODE_NOTFOUND)
				{
					System.out.println("SQL ERROR MSG   :: " + e.getMessage());
					return defineCode.SQLCODE_NOTFOUND;
				}
				else
				{
					System.out.println("SQL ERROR MSG   :: " + e.getMessage());
					return defineCode.SQLCODE_ELSE;
				}
			}
		}
		
		return defineCode.SQLCODE_GOOD;
	}

	@Override
	public int delete(int bbsNo) {
		
		System.out.println("jhwDAOImpl      :: delete");

		try {
			
			JboardQuery.delete("jhwbq.delete", bbsNo);
			
		} catch (SQLException e) {
			if(e.getErrorCode() != defineCode.SQLCODE_GOOD)
			{
				System.out.println("SQL ERROR CODE  :: " + e.getErrorCode());
				
				if(e.getErrorCode() != defineCode.SQLCODE_NOTFOUND)
				{
					System.out.println("SQL ERROR MSG   :: " + e.getMessage());
					return defineCode.SQLCODE_NOTFOUND;
				}
				else
				{
					System.out.println("SQL ERROR MSG   :: " + e.getMessage());
					return defineCode.SQLCODE_ELSE;
				}
			}
		}
		
		return defineCode.SQLCODE_GOOD;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<jhwBoardVOList> list(Criteria cri) throws Exception{
		
		System.out.println("jhwDAOImpl      :: list");
		
		return JboardQuery.queryForList("jhwbq.list", cri);
		
	}
*/
}
