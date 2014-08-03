package org.project.boards.secondHandTrade.reply.service;

import java.util.List;

import org.project.boards.secondHandTrade.reply.domain.SHTReply;


public interface SHTReplyService {
	//write
	public SHTReply write(SHTReply shtReply);
	//read
	public SHTReply read(SHTReply shtReply);
	//update
	public void update(SHTReply shtReply);
	//delete
	public void delete(SHTReply shtReply);
	//deleteLink
	public void deleteLink(SHTReply shtReply);
	//list
	public List<SHTReply> list(int tradeNo);
}