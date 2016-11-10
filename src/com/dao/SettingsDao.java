package com.dao;

import java.util.ArrayList;

import com.entity.Settings;
import com.entity.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface SettingsDao.
 */
public interface SettingsDao {


		/**
		 * Creates the settings for a new user.
		 *
		 * @param viaSms the via sms
		 * @param hazeInfo the haze info
		 * @param fireInfo the fire info
		 * @param maskInfo the mask info
		 * @param bombshelterInfo the bombshelter info
		 */
		public void createSettings(boolean viaSms,boolean hazeInfo,boolean fireInfo,boolean maskInfo,boolean bombshelterInfo);
		
		/**
		 * Update whether user wants sms notification.
		 *
		 * @param x the x
		 */
		public void updateSms(boolean x);
		
		/**
		 * Update whether user wants haze info notifications.
		 *
		 * @param x the x
		 */
		public void updateHazeInfo(boolean x);
		
		/**
		 *Update whether user wants bombshelterinfo notifications.
		 *
		 * @param x the x
		 */
		public void updateBombshelterinfo(boolean x);
		
		/**
		 * Update whether user wants fire info notifications.
		 *
		 * @param x the x
		 */
		public void updateFireInfo(boolean x);
		
		/**
		 * Update whether user wants mask info notifications.
		 *
		 * @param x the x
		 */
		public void updateMaskInfo(boolean x);
		
		/**
		 * Gets the settings object of the user.
		 *
		 * @return the settings
		 */
		public Settings getSettings();
		
		/**
		 * Gets list of users who want haze info notications.
		 *
		 * @return the haze info users
		 */
		public ArrayList<User> getHazeInfoUsers();
		
		/**
		 * Gets list of users who want fire info notications
		 *
		 * @return the fire info users
		 */
		public ArrayList<User> getFireInfoUsers();
		
		/**
		 * Gets list of users who want mask info notifications
		 *
		 * @return the mask info users
		 */
		public ArrayList<User> getMaskInfoUsers();
		
		/**
		 * Gets list of users who want bombshelter info notifications
		 *
		 * @return the bombshelter info users
		 */
		public ArrayList<User> getBombshelterInfoUsers();


}
