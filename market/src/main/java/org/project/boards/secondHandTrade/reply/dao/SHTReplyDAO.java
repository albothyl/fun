package org.project.boards.secondHandTrade.reply.dao;

import java.util.List;

import org.project.boards.secondHandTrade.reply.domain.SHTReply;


public interface SHTReplyDAO {	
	//write
	public void write(SHTReply shtReply);
	//read
	public SHTReply read(SHTReply shtReply);
	//readCurrentlyWrite
	public SHTReply readCurrentlyWrite(SHTReply shtReply);
	//update
	public void update(SHTReply shtReply);
	//delete
	public void delete(SHTReply shtReply);
	//deleteLink
	public void deleteLink(SHTReply shtReply);
	//list
	public List<SHTReply> list(int tradeNo);
}