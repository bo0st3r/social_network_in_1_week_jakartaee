package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entity.Member;

@Remote
public interface IMemberManagerEJB {
	public List<Member> selectAll();
	public Member add(Member m);
	public Member findByUsername(String username);
}
