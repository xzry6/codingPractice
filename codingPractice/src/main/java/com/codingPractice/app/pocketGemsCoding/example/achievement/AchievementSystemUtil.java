package com.codingPractice.app.pocketGemsCoding.example.achievement;

import java.util.ArrayList;
import java.util.List;

public class AchievementSystemUtil {
	/**
	 * Given a list of achievement, check and get the reward.
	 * @param achievements {List<Achievement>} a list of achievement need to be checked.
	 * @return {List<Reward>} a list of reward you may get.
	 */
	public static List<Reward> checkAchievements(List<Achievement> achievements) {
		List<Reward> rewards = new ArrayList<Reward>();
		for(Achievement achievement: achievements) {
			List<Reward> temp = achievement.getReward();
			if(temp != null) {
				rewards.addAll(temp);
			}
		}
		return rewards;
	}
}
