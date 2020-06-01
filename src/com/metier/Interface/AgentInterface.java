package com.metier.Interface;

import java.util.List;

import com.metier.entities.Agent;;

public interface AgentInterface {

	public void create_agent(Agent agent);
	public void update_agent(Agent agent);
	public void delete_agent(Agent agent);
	public Agent find_agent(int agent_id);
	public List<Agent> list_agent();
}
