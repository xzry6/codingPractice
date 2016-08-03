package com.codingPractice.app.pocketGemsCoding.example.achievement;

import java.util.List;

public class Achievement {

	// Properties.
	List<Condition> conditions;
	List<Reward> rewards;

	// Constructor.

	/**
	 * Construct an achievement with a list of conditions an rewards.
	 * @param conditions {List<Condition>} a list of conditions need to be satisfied.
	 * @param rewards {List<Reward>} a list of rewards of this achievement.
	 */
	public Achievement(List<Condition> conditions, List<Reward> rewards) {
		this.conditions = conditions;
		this.rewards = rewards;
	}

	// Public methods.

	/**
	 * Add a condition to the list.
	 * @param condition {Condition} the condition need to be added.
	 */
	public void addCondition(Condition condition) {
		this.conditions.add(condition);
	}

	/**
	 * Add a reward to the list.
	 * @param reward {Reward} the reward need to be added.
	 */
	public void addReward(Reward reward) {
		this.rewards.add(reward);
	}

	/**
	 * Remove a condition on the list.
	 * @param condition {Condition} the condition need to be removed.
	 */
	public void removeCondition(Condition condition) {
		this.rewards.remove(condition);
	}

	/**
	 * Remove a reward on the list.
	 * @param reward {Reward} the reward need to be removed.
	 */
	public void removeReward(Reward reward) {
		this.rewards.remove(reward);
	}

	/**
	 * Get rewards.
	 * @return {List<Reward>} a list of rewards or null.
	 */
	public List<Reward> getReward() {
		return checkConditions() ? rewards : null;
	}

	/**
	 * Private methods.
	 * @return {boolean} true if all condition satisfied.
	 */
	private boolean checkConditions() {
		boolean bool = true;
		for(Condition condition:conditions) {
			bool = bool || condition.check();
		}
		return bool;
	}
}
